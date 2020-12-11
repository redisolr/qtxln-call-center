package com.qtxln.service.impl;

import cn.hutool.core.util.StrUtil;
import com.qtxln.mapper.SysDictionaryMapper;
import com.qtxln.model.bo.SysDictionaryBO;
import com.qtxln.model.entity.SysDictionary;
import com.qtxln.service.SysDictionaryService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-14
 */
@Service
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements SysDictionaryService {

  private final SysDictionaryMapper sysDictionaryMapper;

  @Autowired
  public SysDictionaryServiceImpl(SysDictionaryMapper sysDictionaryMapper) {
    this.sysDictionaryMapper = sysDictionaryMapper;
  }

  @Override
  public boolean insertSysDictionary(SysDictionaryBO sysDictionaryBO) {
    SysDictionary sysDictionary = new SysDictionary();
    BeanUtils.copyProperties(sysDictionaryBO, sysDictionary);
    return save(sysDictionary);
  }

  @Override
  public IPage<SysDictionaryBO> listSysDictionary(SysDictionaryBO sysDictionaryBO) {
    IPage<SysDictionary> page = new Page<>(sysDictionaryBO.getPageNum(), sysDictionaryBO.getPageSize());
    LambdaQueryWrapper<SysDictionary> wrapper = Wrappers.<SysDictionary>lambdaQuery()
        .like(StrUtil.isNotBlank(sysDictionaryBO.getDicName()), SysDictionary::getDicName, "%" + sysDictionaryBO.getDicName() + "%")
        .like(StrUtil.isNotBlank(sysDictionaryBO.getDicCode()), SysDictionary::getDicCode, "%" + sysDictionaryBO.getDicCode() + "%")
        .eq(sysDictionaryBO.getParentId() != null, SysDictionary::getParentId, sysDictionaryBO.getParentId());
    wrapper.orderByDesc(SysDictionary::getSortValue);
    wrapper.orderByDesc(SysDictionary::getCreateTime);
    IPage<SysDictionary> sysDictionaryPage = sysDictionaryMapper.selectPage(page, wrapper);
    IPage<SysDictionaryBO> sd = new Page<>();
    List<SysDictionaryBO> sysDictionaryBOList = JSON.parseObject(JSON.toJSONString(sysDictionaryPage.getRecords()),
        new TypeReference<List<SysDictionaryBO>>() {
        });
    sd.setCurrent(sysDictionaryPage.getCurrent());
    sd.setSize(sysDictionaryPage.getSize());
    sd.setRecords(sysDictionaryBOList);
    sd.setTotal(sysDictionaryPage.getTotal());
    return sd;
  }

  @Override
  public SysDictionaryBO getSysDictionary(Long id) {
    SysDictionary sysDictionary = getById(id);
    SysDictionaryBO sysDictionaryBO = new SysDictionaryBO();
    BeanUtils.copyProperties(sysDictionary, sysDictionaryBO);
    return sysDictionaryBO;
  }

  @Override
  public boolean updateSysDictionary(SysDictionaryBO sysDictionaryBO) {
    SysDictionary sysDictionary = new SysDictionary();
    BeanUtils.copyProperties(sysDictionaryBO, sysDictionary);
    return updateById(sysDictionary);
  }

  @Override
  public boolean deleteSysDictionary(Long id) {
    return removeById(id);
  }

  @Cacheable(value = "eh-sys-dictionary", key = "#code")
  @Override
  public List<SysDictionaryBO> listSysDictionaryByCode(String code) {
    LambdaQueryWrapper<SysDictionary> wrapper = Wrappers.<SysDictionary>lambdaQuery()
        .eq(SysDictionary::getDicCode, code);
    SysDictionary sysDictionary = getOne(wrapper);
    LambdaQueryWrapper<SysDictionary> wrapper1 = Wrappers.<SysDictionary>lambdaQuery()
        .eq(SysDictionary::getParentId, sysDictionary.getId());
    List<SysDictionary> list = list(wrapper1);
    return JSON.parseObject(JSON.toJSONString(list), new TypeReference<List<SysDictionaryBO>>() {
    });
  }


}
