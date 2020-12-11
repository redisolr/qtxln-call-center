package com.qtxln.service.impl;

import com.qtxln.mapper.IvrEntryMapper;
import com.qtxln.model.bo.IvrEntryBO;
import com.qtxln.model.entity.IvrEntry;
import com.qtxln.service.IvrEntryService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
@Service
public class IvrEntryServiceImpl extends ServiceImpl<IvrEntryMapper, IvrEntry> implements IvrEntryService {

  private final IvrEntryMapper ivrEntryMapper;

  public IvrEntryServiceImpl(IvrEntryMapper ivrEntryMapper) {
    this.ivrEntryMapper = ivrEntryMapper;
  }

  @Override
  public Long insertIvrEntry(IvrEntryBO ivrEntryBO) {
    IvrEntry ivrEntry = new IvrEntry();
    BeanUtils.copyProperties(ivrEntryBO, ivrEntry);
    ivrEntryMapper.insert(ivrEntry);
    return ivrEntry.getId();
  }

  @Override
  public boolean updateIvrEntry(IvrEntryBO ivrEntryBO) {
    IvrEntry ivrEntry = new IvrEntry();
    BeanUtils.copyProperties(ivrEntryBO, ivrEntry);
    return updateById(ivrEntry);
  }

  @Override
  public IvrEntryBO getIvrEntry(Long id) {
    IvrEntry ivrEntry = getById(id);
    IvrEntryBO ivrEntryBO = new IvrEntryBO();
    BeanUtils.copyProperties(ivrEntry, ivrEntryBO);
    return ivrEntryBO;
  }

  @Override
  public boolean deleteIvrEntry(Long id) {
    return removeById(id);
  }

  @Override
  public IPage<IvrEntryBO> listIvrEntry(IvrEntryBO ivrEntryBO) {
    IPage<IvrEntry> page = new Page<>(ivrEntryBO.getPageNum(), ivrEntryBO.getPageSize());
    IPage<IvrEntry> ivrEntryPage = ivrEntryMapper.listPageIvrEntry(page, ivrEntryBO);

    IPage<IvrEntryBO> pageIvrEntry = new Page<>();
    List<IvrEntryBO> ivrEntryBOList = JSON.parseObject(JSON.toJSONString(ivrEntryPage.getRecords()), new TypeReference<List<IvrEntryBO>>() {
    });
    pageIvrEntry.setCurrent(ivrEntryPage.getCurrent());
    pageIvrEntry.setSize(ivrEntryPage.getSize());
    pageIvrEntry.setRecords(ivrEntryBOList);
    pageIvrEntry.setTotal(ivrEntryPage.getTotal());
    return pageIvrEntry;
  }
}
