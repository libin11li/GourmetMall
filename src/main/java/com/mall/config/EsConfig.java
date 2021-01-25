package com.mall.config;

import com.mall.properties.EsProperties;
import com.mall.properties.ToolsProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: li
 * description:
 * date: 2020/7/23
 */
//@Configuration
@Slf4j
@RequiredArgsConstructor
@Data
public class EsConfig {

    private final ToolsProperties toolsProperties;

//    @Bean
//    public RestHighLevelClient getClient() {
//        EsProperties es = toolsProperties.getEs();
//        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "sckj@2020"));
//        RestClientBuilder builder = RestClient.builder(new HttpHost(es.getHostname(), es.getPort(), es.getScheme()));
//        // 异步httpclient连接延时配置
//        builder.setRequestConfigCallback(requestConfigBuilder -> {
//            requestConfigBuilder.setConnectTimeout(es.getConnectTimeOut());
//            requestConfigBuilder.setSocketTimeout(es.getSocketTimeOut());
//            requestConfigBuilder.setConnectionRequestTimeout(es.getConnectionRequestTimeOut());
//            return requestConfigBuilder;
//        });
//        // 异步httpclient连接数配置
//        builder.setHttpClientConfigCallback(httpClientBuilder -> {
//            httpClientBuilder.setMaxConnTotal(es.getMaxConnectNum());
//            httpClientBuilder.setMaxConnPerRoute(es.getMaxConnectPerRoute());
//            httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//            return httpClientBuilder;
//        });
//        //设置账号密码
//        builder.setHttpClientConfigCallback(httpClientBuilder -> {
//            httpClientBuilder.disableAuthCaching();
//            return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//        });
//        return new RestHighLevelClient(builder);
//    }

}
