package com.qtxln.service.impl;

import cn.hutool.core.util.StrUtil;
import com.qtxln.mapper.CallCenterMediaMapper;
import com.qtxln.model.bo.CallCenterMediaBO;
import com.qtxln.model.entity.CallCenterMedia;
import com.qtxln.service.CallCenterMediaService;
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
 * 呼叫中心-媒体资源表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-30
 */
@Service
public class CallCenterMediaServiceImpl extends ServiceImpl<CallCenterMediaMapper, CallCenterMedia> implements CallCenterMediaService {

  private final CallCenterMediaMapper callCenterMediaMapper;

  @Autowired
  public CallCenterMediaServiceImpl(CallCenterMediaMapper callCenterMediaMapper) {
    this.callCenterMediaMapper = callCenterMediaMapper;
  }

  @Override
  public boolean insertCallCenterMedia(CallCenterMediaBO callCenterMediaBO) {
    CallCenterMedia callCenterMedia = new CallCenterMedia();
    BeanUtils.copyProperties(callCenterMediaBO, callCenterMedia);
    return save(callCenterMedia);
  }

  @Override
  public boolean updateCallCenterMedia(CallCenterMediaBO callCenterMediaBO) {
    CallCenterMedia callCenterMedia = new CallCenterMedia();
    BeanUtils.copyProperties(callCenterMediaBO, callCenterMedia);
    return updateById(callCenterMedia);
  }

  @Override
  public IPage<CallCenterMediaBO> listCallCenterMedia(CallCenterMediaBO callCenterMediaBO) {
    IPage<CallCenterMedia> page = new Page<>(callCenterMediaBO.getPageNum(), callCenterMediaBO.getPageSize());
    LambdaQueryWrapper<CallCenterMedia> wrapper = Wrappers.<CallCenterMedia>lambdaQuery()
        .like(StrUtil.isNotBlank(callCenterMediaBO.getBusinessName()), CallCenterMedia::getBusinessName, callCenterMediaBO.getBusinessName());
    wrapper.orderByDesc(CallCenterMedia::getCreateTime);
    IPage<CallCenterMedia> callCenterMediaPage = callCenterMediaMapper.selectPage(page, wrapper);
    IPage<CallCenterMediaBO> pageFsBasic = new Page<>();
    List<CallCenterMediaBO> callCenterMediaBOList = JSON.parseObject(JSON.toJSONString(callCenterMediaPage.getRecords()), new TypeReference<List<CallCenterMediaBO>>() {
    });
    pageFsBasic.setCurrent(callCenterMediaPage.getCurrent());
    pageFsBasic.setSize(callCenterMediaPage.getSize());
    pageFsBasic.setRecords(callCenterMediaBOList);
    pageFsBasic.setTotal(callCenterMediaPage.getTotal());
    return pageFsBasic;
  }

  @Override
  public CallCenterMediaBO getCallCenterMedia(Long id) {
    CallCenterMedia callCenterMedia = getById(id);
    CallCenterMediaBO callCenterMediaBO = new CallCenterMediaBO();
    BeanUtils.copyProperties(callCenterMedia, callCenterMediaBO);
    return callCenterMediaBO;
  }

  @Override
  public boolean deleteCallCenterMedia(Long id) {
    return removeById(id);
  }
}
