package com.qtxln.service.impl;

import com.qtxln.mapper.DailplanTemplateMapper;
import com.qtxln.model.bo.DialplanTemplateBO;
import com.qtxln.model.entity.DialplanTemplate;
import com.qtxln.service.DialplanTemplateService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 拨号计划-模板表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-07
 */
@Service
public class DialplanTemplateServiceImpl extends ServiceImpl<DailplanTemplateMapper, DialplanTemplate> implements DialplanTemplateService {

  private final DailplanTemplateMapper dailplanTemplateMapper;

  @Autowired
  public DialplanTemplateServiceImpl(DailplanTemplateMapper dailplanTemplateMapper) {
    this.dailplanTemplateMapper = dailplanTemplateMapper;
  }

  @Override
  public boolean insertDailplanTemplate(DialplanTemplateBO dialplanTemplateBO) {
    DialplanTemplate dialplanTemplate = new DialplanTemplate();
    BeanUtils.copyProperties(dialplanTemplateBO, dialplanTemplate);
    return save(dialplanTemplate);
  }

  @Override
  public boolean updateDailplanTemplate(DialplanTemplateBO dialplanTemplateBO) {
    DialplanTemplate dialplanTemplate = new DialplanTemplate();
    BeanUtils.copyProperties(dialplanTemplateBO, dialplanTemplate);
    return updateById(dialplanTemplate);
  }

  @Override
  public IPage<DialplanTemplateBO> listDailplanTemplate(DialplanTemplateBO dialplanTemplateBO) {
    IPage<DialplanTemplate> page = new Page<>(dialplanTemplateBO.getPageNum(), dialplanTemplateBO.getPageSize());
    IPage<DialplanTemplate> dialplanTemplatePage = dailplanTemplateMapper.listPageDailplanTemplate(page, dialplanTemplateBO);
    IPage<DialplanTemplateBO> pageDialplanTemplate = new Page<>();
    List<DialplanTemplateBO> dialplanApplicationBOList = JSON.parseObject(JSON.toJSONString(dialplanTemplatePage.getRecords()), new TypeReference<List<DialplanTemplateBO>>() {
    });
    pageDialplanTemplate.setCurrent(dialplanTemplatePage.getCurrent());
    pageDialplanTemplate.setSize(dialplanTemplatePage.getSize());
    pageDialplanTemplate.setRecords(dialplanApplicationBOList);
    pageDialplanTemplate.setTotal(dialplanTemplatePage.getTotal());
    return pageDialplanTemplate;
  }

  @Override
  public DialplanTemplateBO getDailplanTemplate(Long id) {
    DialplanTemplate dialplanTemplate = getById(id);
    DialplanTemplateBO dialplanTemplateBO = new DialplanTemplateBO();
    BeanUtils.copyProperties(dialplanTemplate, dialplanTemplateBO);
    return dialplanTemplateBO;
  }

  @Override
  public boolean deleteDailplanTemplate(Long id) {
    return removeById(id);
  }

}
