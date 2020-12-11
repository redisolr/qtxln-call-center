package com.qtxln.service.impl;

import cn.hutool.core.util.StrUtil;
import com.qtxln.mapper.IvrMapper;
import com.qtxln.model.bo.IvrBO;
import com.qtxln.model.entity.Ivr;
import com.qtxln.service.IvrService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * IVR 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
@Service
public class IvrServiceImpl extends ServiceImpl<IvrMapper, Ivr> implements IvrService {

  private final IvrMapper ivrMapper;

  public IvrServiceImpl(IvrMapper ivrMapper) {
    this.ivrMapper = ivrMapper;
  }

  @Override
  public Long insertIvr(IvrBO ivrBO) {
    Ivr ivr = new Ivr();
    BeanUtils.copyProperties(ivrBO, ivr);
    ivrMapper.insert(ivr);
    return ivr.getId();
  }

  @Override
  public boolean updateIvr(IvrBO ivrBO) {
    Ivr ivr = new Ivr();
    BeanUtils.copyProperties(ivrBO, ivr);
    return updateById(ivr);
  }

  @Override
  public IvrBO getIvr(Long id) {
    Ivr ivr = getById(id);
    IvrBO ivrBO = new IvrBO();
    BeanUtils.copyProperties(ivr, ivrBO);
    return ivrBO;
  }

  @Override
  public boolean deleteIvr(Long id) {
    return removeById(id);
  }

  @Override
  public IPage<IvrBO> listIvr(IvrBO ivrBO) {
    IPage<Ivr> page = new Page<>(ivrBO.getPageNum(), ivrBO.getPageSize());
    LambdaQueryWrapper<Ivr> wrapper = Wrappers.<Ivr>lambdaQuery()
        .like(StrUtil.isNotBlank(ivrBO.getIvrName()), Ivr::getIvrName, "%" + ivrBO.getIvrName() + "%");
    wrapper.orderByDesc(Ivr::getCreateTime);
    IPage<Ivr> ivrPage = ivrMapper.selectPage(page, wrapper);

    IPage<IvrBO> pageIvr = new Page<>();
    List<IvrBO> ivrBOList = JSON.parseObject(JSON.toJSONString(ivrPage.getRecords()), new TypeReference<List<IvrBO>>() {
    });
    pageIvr.setCurrent(ivrPage.getCurrent());
    pageIvr.setSize(ivrPage.getSize());
    pageIvr.setRecords(ivrBOList);
    pageIvr.setTotal(ivrPage.getTotal());
    return pageIvr;
  }
}
