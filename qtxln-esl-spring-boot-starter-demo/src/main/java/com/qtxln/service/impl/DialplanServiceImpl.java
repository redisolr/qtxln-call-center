package com.qtxln.service.impl;

import cn.hutool.core.util.StrUtil;
import com.qtxln.mapper.DialplanMapper;
import com.qtxln.model.bo.DialplanBO;
import com.qtxln.model.entity.Dialplan;
import com.qtxln.service.DialplanService;
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
 * 拨号计划表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-08
 */
@Service
public class DialplanServiceImpl extends ServiceImpl<DialplanMapper, Dialplan> implements DialplanService {

  private final DialplanMapper dialplanMapper;

  public DialplanServiceImpl(DialplanMapper dialplanMapper) {
    this.dialplanMapper = dialplanMapper;
  }

  @Override
  public boolean insertDialplan(DialplanBO dialplanBO) {
    Dialplan dialplan = new Dialplan();
    BeanUtils.copyProperties(dialplanBO, dialplan);
    return save(dialplan);
  }

  @Override
  public boolean updateDialplan(DialplanBO dialplanBO) {
    Dialplan dialplan = new Dialplan();
    BeanUtils.copyProperties(dialplanBO, dialplan);
    return updateById(dialplan);
  }

  @Override
  public DialplanBO getDialplan(Long id) {
    Dialplan dialplan = getById(id);
    DialplanBO dialplanBO = new DialplanBO();
    BeanUtils.copyProperties(dialplan, dialplanBO);
    return dialplanBO;
  }

  @Override
  public boolean deleteDialplan(Long id) {
    return removeById(id);
  }

  @Override
  public IPage<DialplanBO> listDialplan(DialplanBO dialplanBO) {
    IPage<Dialplan> page = new Page<>(dialplanBO.getPageNum(), dialplanBO.getPageSize());
    LambdaQueryWrapper<Dialplan> wrapper = Wrappers.<Dialplan>lambdaQuery()
        .like(StrUtil.isNotBlank(dialplanBO.getDialplanChineseName()), Dialplan::getDialplanChineseName, dialplanBO.getDialplanChineseName());
    IPage<Dialplan> dialplanPage = dialplanMapper.selectPage(page, wrapper);
    IPage<DialplanBO> pageDialplan = new Page<>();
    List<DialplanBO> dialplanBOList = JSON.parseObject(JSON.toJSONString(dialplanPage.getRecords()), new TypeReference<List<DialplanBO>>() {
    });
    pageDialplan.setCurrent(dialplanPage.getCurrent());
    pageDialplan.setSize(dialplanPage.getSize());
    pageDialplan.setRecords(dialplanBOList);
    pageDialplan.setTotal(dialplanPage.getTotal());
    return pageDialplan;
  }

}
