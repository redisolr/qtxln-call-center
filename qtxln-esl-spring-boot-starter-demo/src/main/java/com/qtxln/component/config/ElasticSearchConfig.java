package com.qtxln.component.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * es配置类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-08 17:03
 * @since 1.0
 */
@Configuration
public class ElasticSearchConfig {

  @Bean
  public RestHighLevelClient restHighLevelClient() {
    return new RestHighLevelClient(
        RestClient.builder(
            new HttpHost("192.168.10.5", 9200, "http")));
  }

}
