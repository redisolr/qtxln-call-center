package com.qtxln.controller;

import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.service.es.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * es 前端控制器
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-09 11:45
 * @since 1.0
 */
@RestController
@RequestMapping("es")
public class ElasticSearchController {

  private final ElasticSearchService elasticSearchService;

  @Autowired
  public ElasticSearchController(ElasticSearchService elasticSearchService) {
    this.elasticSearchService = elasticSearchService;
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteData(@PathVariable String id) {
    return ResultExt.successWithData(elasticSearchService.deleteBatch("fs_event", Collections.singletonList(id)));
  }

}
