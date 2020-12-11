package com.qtxln.service;

import com.qtxln.model.bo.SysDictionaryBO;
import com.qtxln.model.entity.SysDictionary;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-14
 */
public interface SysDictionaryService extends IService<SysDictionary> {

  /**
   * 添加字典数据
   * @param sysDictionaryBO 字典数据信息
   * @return 是否添加成功
   */
  boolean insertSysDictionary(SysDictionaryBO sysDictionaryBO);

  /**
   * 查询字典数据列表
   * @param sysDictionaryBO 字典数据查询条件
   * @return 分页信息和数据
   */
  IPage<SysDictionaryBO> listSysDictionary(SysDictionaryBO sysDictionaryBO);

  /**
   * 获取字段详情
   * @param id 主键
   * @return 字典数据详情
   */
  SysDictionaryBO getSysDictionary(Long id);

  /**
   * 更新字典信息
   * @param sysDictionaryBO 字典信息
   * @return 是否更新成功
   */
  boolean updateSysDictionary(SysDictionaryBO sysDictionaryBO);

  /**
   * 删除字典信息
   * @param id 主键
   * @return 是否删除成功
   */
  boolean deleteSysDictionary(Long id);

  /**
   * 根据code获取该字典数据的子数据
   * @param code 字典code
   * @return 数据列表
   */
  List<SysDictionaryBO> listSysDictionaryByCode(String code);

}
