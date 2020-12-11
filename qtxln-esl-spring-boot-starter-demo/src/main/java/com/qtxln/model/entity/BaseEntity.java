package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 业务实体基础类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/5 21:28 下午
 * @since 1.0
 */
@Data
public class BaseEntity {

  /**
   * 创建时间
   */
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  /**
   * 创建用户id
   */
  private String createUser;
  /**
   * 是否删除
   * true ：删除
   * false：没有删除
   */
  @TableLogic
  @TableField(value = "is_deleted", select = false)
  private Boolean deleted;
  /**
   * 更新时间
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;
  /**
   * 更新用户id
   */
  private String updateUser;

}
