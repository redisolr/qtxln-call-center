package com.qtxln.component.util;

import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.concurrent.TimeUnit;

/**
 * es 工具类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-09 13:52
 * @since 1.0
 */
public class ElasticSearchUtils {

  private ElasticSearchUtils() {}

  public static SearchSourceBuilder initSearchSourceBuilder(QueryBuilder queryBuilder, int from, int size, int timeout) {
    // 使用默认选项创建 SearchSourceBuilder
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    // 设置查询对象 可以使任何类型的 QueryBuilder
    sourceBuilder.query(queryBuilder);
    // 设置from选项 确定要开始搜索的结果索引 默认为0
    sourceBuilder.from(from);
    // 设置大小选项 确定要返回的搜索匹配数 默认为10
    sourceBuilder.size(size);
    sourceBuilder.timeout(new TimeValue(timeout, TimeUnit.SECONDS));
    return sourceBuilder;
  }

  public static SearchSourceBuilder initSearchSourceBuilder(QueryBuilder queryBuilder) {
    return initSearchSourceBuilder(queryBuilder, 0, 10, 60);
  }

}
