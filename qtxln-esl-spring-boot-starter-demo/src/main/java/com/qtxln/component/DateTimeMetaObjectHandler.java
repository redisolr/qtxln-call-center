package com.qtxln.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis plus 新增更新自动赋值
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/5 21:29 下午
 * @since 1.0.0
 */
@Component
public class DateTimeMetaObjectHandler implements MetaObjectHandler {

  private static final String CREATE_TIME_NAME = "createTime";
  private static final String UPDATE_TIME_NAME = "updateTime";

  @Override
  public void insertFill(MetaObject metaObject) {
    this.strictInsertFill(metaObject, CREATE_TIME_NAME, LocalDateTime.class, LocalDateTime.now());
    this.strictInsertFill(metaObject, UPDATE_TIME_NAME, LocalDateTime.class, LocalDateTime.now());
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, UPDATE_TIME_NAME, LocalDateTime.class, LocalDateTime.now());
  }

}