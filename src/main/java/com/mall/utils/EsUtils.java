package com.mall.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.mall.enums.common.QueryTypeEnum;
import com.mall.exception.NormalException;
import com.mall.dto.es.SearchDataFromEs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author: li
 * description:ES操作工具类
 * date: 2020/7/27
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class EsUtils {

    private final RestHighLevelClient client;

    /**
     * 添加数据到ES
     * @param indexName 索引名称
     * @param id 索引下文档id
     * @param data 数据
     */
    public void addDataToEs(String indexName, Long id, Object data){
        IndexRequest indexRequest = new IndexRequest(indexName);
        indexRequest.id(String.valueOf(id));
        indexRequest.source(JSONObject.toJSONString(data), XContentType.JSON);
        try {
            client.index(indexRequest,  RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("ES插入数据失败:"+e.toString());
            throw new NormalException("ES插入数据失败");
        }
    }

    /**
     * 更新ES中的数据
     * @param indexName 索引名称
     * @param id 索引下文档id
     * @param data 数据
     */
    public void updateDataToEs(String indexName, Long id, Object data){
        UpdateRequest updateRequest = new UpdateRequest(indexName, String.valueOf(id));
        String s = JSON.toJSONString(data);
        updateRequest.doc(JSONObject.parseObject(s));
        try {
            client.update(updateRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("ES更新数据失败:"+e.toString());
            throw new NormalException("ES更新数据失败");
        }
    }

    /**
     * 删除ES中的数据
     * @param indexName 索引名称
     * @param id 索引下文档id
     */
    public void deleteDataToEs(String indexName, Long id){
        DeleteRequest deleteRequest = new DeleteRequest(indexName, String.valueOf(id));
        try {
            client.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("ES删除数据失败:"+e.toString());
            throw new NormalException("ES删除数据失败");
        }
    }

    /**
     * 清空ES中数据
     * @param indexName 索引名称
     */
    public void clear(String indexName){
        //todo
    }

    /**
     * 从ES中搜索数据
     * @param indexName 索引名称
     * @param searchDataFromEs 搜索信息
     * @return 搜索的结果
     */
    public <T> List<T> searchDataFromEs(String indexName, SearchDataFromEs searchDataFromEs, Class<T> resultClass){
        List<T> resultData = Lists.newArrayList();
        try {
            SearchRequest searchRequest = new SearchRequest(indexName);
            SearchSourceBuilder builder = new SearchSourceBuilder();
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            //关键词查询
            if (searchDataFromEs.getKeyword() != null) {
                searchDataFromEs.getKeyword().forEach(keywords -> {
                    MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(keywords.getKey(), keywords.getValue());
                    if (QueryTypeEnum.MUST == keywords.getQueryType()) {
                        boolQueryBuilder.must(matchQueryBuilder);
                    } else if (QueryTypeEnum.SHOULD == keywords.getQueryType()) {
                        boolQueryBuilder.should(matchQueryBuilder);
                    } else if (QueryTypeEnum.MUST_NOT == keywords.getQueryType()) {
                        boolQueryBuilder.mustNot(matchQueryBuilder);
                    }
                });
            }
            //范围匹配
            if(searchDataFromEs.getFilterFields() != null){
                searchDataFromEs.getFilterFields().forEach(filterField -> boolQueryBuilder.must(QueryBuilders.rangeQuery(filterField.getKey()).from(filterField.getLowValue()).to(filterField.getHighValue()).includeLower(Boolean.TRUE).includeUpper(Boolean.TRUE)));
            }
            builder.query(boolQueryBuilder);
            //排序
            if (searchDataFromEs.getSortFields() != null) {
                searchDataFromEs.getSortFields().forEach((sortCondition -> {
                    FieldSortBuilder sortBuilder = new FieldSortBuilder(sortCondition.getFieldName()).
                            order(sortCondition.getSortOrder());
                    builder.sort(sortBuilder);
                }));
            }
            //分页
            if (searchDataFromEs.getPageSize() > 0 && searchDataFromEs.getPageNum() >= 0){
                int start = searchDataFromEs.getPageNum() * searchDataFromEs.getPageSize();
                builder.from(start).size(searchDataFromEs.getPageSize());
            }
            searchRequest.source(builder);
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            //转成需要的类型
            SearchHit[] hits = searchResponse.getHits().getHits();
            for(SearchHit hit : hits){
                T t = JSONObject.parseObject(hit.getSourceAsString(), resultClass);
                resultData.add(t);
            }
        } catch (IOException e) {
            log.error("从ES中查询数据失败:"+e.toString());
            throw new NormalException("从ES中查询数据失败");
        }
        return resultData;
    }

}
