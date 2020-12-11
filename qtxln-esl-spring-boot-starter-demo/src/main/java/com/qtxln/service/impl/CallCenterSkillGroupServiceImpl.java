package com.qtxln.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.qtxln.mapper.CallCenterSkillGroupMapper;
import com.qtxln.model.bo.CallCenterSkillGroupBO;
import com.qtxln.model.entity.CallCenterSkillGroup;
import com.qtxln.service.CallCenterSkillGroupService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 技能组表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-02
 */
@Service
public class CallCenterSkillGroupServiceImpl extends ServiceImpl<CallCenterSkillGroupMapper, CallCenterSkillGroup> implements CallCenterSkillGroupService {

  private final CallCenterSkillGroupMapper callCenterSkillGroupMapper;

  @Autowired
  public CallCenterSkillGroupServiceImpl(CallCenterSkillGroupMapper callCenterSkillGroupMapper) {
    this.callCenterSkillGroupMapper = callCenterSkillGroupMapper;
  }

  @Override
  public boolean insertCallCenterSkillGroup(CallCenterSkillGroupBO callCenterSkillGroupBO) {
    CallCenterSkillGroup callCenterSkillGroup = new CallCenterSkillGroup();
    BeanUtils.copyProperties(callCenterSkillGroupBO, callCenterSkillGroup);
    return save(callCenterSkillGroup);
  }

  @Override
  public boolean updateCallCenterSkillGroup(CallCenterSkillGroupBO callCenterSkillGroupBO) {
    CallCenterSkillGroup callCenterSkillGroup = new CallCenterSkillGroup();
    BeanUtils.copyProperties(callCenterSkillGroupBO, callCenterSkillGroup);
    return updateById(callCenterSkillGroup);
  }

  @Override
  public IPage<CallCenterSkillGroupBO> listCallCenterSkillGroup(CallCenterSkillGroupBO callCenterSkillGroupBO) {
    IPage<CallCenterSkillGroup> page = new Page<>(callCenterSkillGroupBO.getPageNum(), callCenterSkillGroupBO.getPageSize());
    IPage<CallCenterSkillGroup> skillGroupPage = callCenterSkillGroupMapper.listPageSkillGroup(page, callCenterSkillGroupBO);
    IPage<CallCenterSkillGroupBO> pageSkillGroupBO = new Page<>();
    List<CallCenterSkillGroupBO> skillGroupList = JSON.parseObject(JSON.toJSONString(skillGroupPage.getRecords()), new TypeReference<List<CallCenterSkillGroupBO>>() {
    });
    pageSkillGroupBO.setCurrent(skillGroupPage.getCurrent());
    pageSkillGroupBO.setSize(skillGroupPage.getSize());
    pageSkillGroupBO.setRecords(skillGroupList);
    pageSkillGroupBO.setTotal(skillGroupPage.getTotal());
    return pageSkillGroupBO;
  }

  @Override
  public CallCenterSkillGroupBO getCallCenterSkillGroup(Long id) {
    CallCenterSkillGroupBO callCenterSkillGroupBO = new CallCenterSkillGroupBO();
    CallCenterSkillGroup callCenterSkillGroup = getById(id);
    BeanUtils.copyProperties(callCenterSkillGroup, callCenterSkillGroupBO);
    return callCenterSkillGroupBO;
  }

  @Override
  public boolean deleteCallCenterSkillGroup(Long id) {
    return removeById(id);
  }

  @Override
  public List<CallCenterSkillGroupBO> queryAll() {
    List<CallCenterSkillGroup> centerSkillGroupList = callCenterSkillGroupMapper.queryAll();
    if (CollUtil.isEmpty(centerSkillGroupList)) {
      return new ArrayList<>();
    }
    return JSON.parseObject(JSON.toJSONString(centerSkillGroupList), new TypeReference<List<CallCenterSkillGroupBO>>() {
    });
  }

}
