package com.mall.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author li
 * description:
 * date: 2021/1/25
 */
@Configuration
@PropertySource("classpath:tools.properties")
@ConfigurationProperties(prefix = "mall")
@Data
public class ToolsProperties {

    private EsProperties es;

    private SnowProperties snow;

}