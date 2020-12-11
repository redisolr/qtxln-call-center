package com.qtxln.service.es;

import com.qtxln.model.es.ElasticEntity;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.Collection;
import java.util.List;

/**
 * es 服务类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-08 17:33
 * @since 1.0
 */
public interface ElasticSearchService {

  /**
   * 创建索引
   *
   * @param idxName 索引名称
   * @param idxSql  索引描述
   * @return 是否创建成功
   */
  boolean createIndex(String idxName, String idxSql);

  /**
   * 判断索引是否存在
   *
   * @param idxName 索引名称
   * @return 是否存在
   */
  boolean indexExist(String idxName);

  /**
   * 添加数据
   *
   * @param idxName       索引名称
   * @param elasticEntity 要添加的数据
   * @return 是否添加成功
   */
  boolean insertOne(String idxName, ElasticEntity elasticEntity);

  /**
   * 删除数据
   *
   * @param idxName 索引名
   * @param idList  数据id
   * @param <T>     类型
   * @return 是否删除成功
   */
  <T> boolean deleteBatch(String idxName, Collection<T> idList);

  /**
   * 查询数据
   *
   * @param idxName 索引类型
   * @param builder 查询构造器
   * @param c       返回值类型
   * @param <T>     集合
   * @return 返回值集合
   */
  <T> List<T> search(String idxName, SearchSourceBuilder builder, Class<T> c);

}
