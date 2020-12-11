package com.qtxln.service.es.impl;

import com.qtxln.model.es.ElasticEntity;
import com.qtxln.service.es.ElasticSearchService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * es 服务实现类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-08 17:34
 * @since 1.0
 */
@Service
@Slf4j
public class ElasticSearchServiceImpl implements ElasticSearchService {

  private final RestHighLevelClient restHighLevelClient;

  public ElasticSearchServiceImpl(RestHighLevelClient restHighLevelClient) {
    this.restHighLevelClient = restHighLevelClient;
  }

  @Override
  public boolean createIndex(String idxName, String idxSql) {
    if (indexExist(idxName)) {
      CreateIndexRequest request = new CreateIndexRequest(idxName);
      buildSetting(request);
      request.mapping(idxSql, XContentType.JSON);
      try {
        CreateIndexResponse res = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        return res.isAcknowledged();
      } catch (IOException ex) {
        log.error("创建索引失败", ex);
      }
    }
    return false;
  }

  public void buildSetting(CreateIndexRequest request) {
    request.settings(Settings.builder().put("index.number_of_shards", 3)
        .put("index.number_of_replicas", 2));
  }

  @Override
  public boolean indexExist(String idxName) {
    GetIndexRequest request = new GetIndexRequest(idxName);
    request.local(false);
    request.humanReadable(true);
    request.includeDefaults(false);
    request.indicesOptions(IndicesOptions.lenientExpandOpen());
    try {
      return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    } catch (IOException ex) {
      log.error("判断索引是否存在错误", ex);
    }
    return false;
  }

  @Override
  public boolean insertOne(String idxName, ElasticEntity elasticEntity) {
    try {
      IndexRequest request = new IndexRequest(idxName);
      request.id(System.currentTimeMillis() + "");
      request.source(elasticEntity.getData(), XContentType.JSON);
      restHighLevelClient.index(request, RequestOptions.DEFAULT);
      return true;
    } catch (IOException ex) {
      log.error("添加es出错", ex);
    }
    return false;
  }

  @Override
  public <T> boolean deleteBatch(String idxName, Collection<T> idList) {
    BulkRequest request = new BulkRequest();
    idList.forEach(item -> request.add(new DeleteRequest(idxName, item.toString())));
    try {
      restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
      return true;
    } catch (IOException ex) {
      log.error("删除数据出错", ex);
    }
    return false;
  }

  @Override
  public <T> List<T> search(String idxName, SearchSourceBuilder builder, Class<T> c) {
    SearchRequest request = new SearchRequest(idxName);
    request.source(builder);
    try {
      SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
      SearchHit[] hits = response.getHits().getHits();
      List<T> res = new ArrayList<>(hits.length);
      for (SearchHit hit : hits) {
        res.add(JSON.parseObject(hit.getSourceAsString(), c));
      }
      return res;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

}
