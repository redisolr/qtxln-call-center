package com.qtxln.service.impl;

import cn.hutool.core.util.StrUtil;
import com.qtxln.mapper.DialplanApplicationMapper;
import com.qtxln.model.bo.DialplanApplicationBO;
import com.qtxln.model.entity.DialplanApplication;
import com.qtxln.service.DialplanApplicationService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 拨号计划-app表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-06
 */
@Service
public class DialplanApplicationServiceImpl extends ServiceImpl<DialplanApplicationMapper, DialplanApplication> implements DialplanApplicationService {

  private final DialplanApplicationMapper dialplanApplicationMapper;

  @Autowired
  public DialplanApplicationServiceImpl(DialplanApplicationMapper dialplanApplicationMapper) {
    this.dialplanApplicationMapper = dialplanApplicationMapper;
  }

  @Override
  public boolean insertDialplanApp(DialplanApplicationBO dialplanApplicationBO) {
    DialplanApplication dialplanApplication = new DialplanApplication();
    BeanUtils.copyProperties(dialplanApplicationBO, dialplanApplication);
    return save(dialplanApplication);
  }

  @Override
  public boolean updateDialplanApp(DialplanApplicationBO dialplanApplicationBO) {
    DialplanApplication dialplanApplication = new DialplanApplication();
    BeanUtils.copyProperties(dialplanApplicationBO, dialplanApplication);
    return updateById(dialplanApplication);
  }

  @Override
  public IPage<DialplanApplicationBO> listDialplanApp(DialplanApplicationBO dialplanApplicationBO) {
    IPage<DialplanApplication> page = new Page<>(dialplanApplicationBO.getPageNum(), dialplanApplicationBO.getPageSize());
    LambdaQueryWrapper<DialplanApplication> wrapper = Wrappers.<DialplanApplication>lambdaQuery()
        .like(StrUtil.isNotBlank(dialplanApplicationBO.getApplicationName()), DialplanApplication::getApplicationName, dialplanApplicationBO.getApplicationName());
    IPage<DialplanApplication> dialplanApplicationPage = dialplanApplicationMapper.selectPage(page, wrapper);
    IPage<DialplanApplicationBO> pageDialplanApp = new Page<>();
    List<DialplanApplicationBO> dialplanApplicationBOList = JSON.parseObject(JSON.toJSONString(dialplanApplicationPage.getRecords()), new TypeReference<List<DialplanApplicationBO>>() {
    });
    pageDialplanApp.setCurrent(dialplanApplicationPage.getCurrent());
    pageDialplanApp.setSize(dialplanApplicationPage.getSize());
    pageDialplanApp.setRecords(dialplanApplicationBOList);
    pageDialplanApp.setTotal(dialplanApplicationPage.getTotal());
    return pageDialplanApp;
  }

  @Override
  public DialplanApplicationBO getDialplanApp(Long id) {
    DialplanApplication dialplanApplication = getById(id);
    DialplanApplicationBO dialplanApplicationBO = new DialplanApplicationBO();
    BeanUtils.copyProperties(dialplanApplication, dialplanApplicationBO);
    return dialplanApplicationBO;
  }

  @Override
  public boolean deleteDialplanApp(Long id) {
    return removeById(id);
  }
}
