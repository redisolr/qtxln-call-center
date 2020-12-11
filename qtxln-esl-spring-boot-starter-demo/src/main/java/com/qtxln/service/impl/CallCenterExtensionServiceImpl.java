package com.qtxln.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.qtxln.esl.InboundClient;
import com.qtxln.component.config.FreeSwitchApiTemplate;
import com.qtxln.component.constants.FreeSwitchApiEnum;
import com.qtxln.component.exception.BaseException;
import com.qtxln.component.result.ResultCode;
import com.qtxln.mapper.CallCenterExtensionMapper;
import com.qtxln.model.bo.CallCenterExtensionBO;
import com.qtxln.model.entity.CallCenterExtension;
import com.qtxln.service.CallCenterExtensionService;
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

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 分机表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-31
 */
@Service
public class CallCenterExtensionServiceImpl extends ServiceImpl<CallCenterExtensionMapper, CallCenterExtension> implements CallCenterExtensionService {

  private final CallCenterExtensionMapper callCenterExtensionMapper;
  private final InboundClient inboundClient;
  private final FreeSwitchApiTemplate freeSwitchApiTemplate;

  @Autowired
  public CallCenterExtensionServiceImpl(CallCenterExtensionMapper callCenterExtensionMapper, InboundClient inboundClient, FreeSwitchApiTemplate freeSwitchApiTemplate) {
    this.callCenterExtensionMapper = callCenterExtensionMapper;
    this.inboundClient = inboundClient;
    this.freeSwitchApiTemplate = freeSwitchApiTemplate;
  }

  @Override
  public boolean insertCallCenterExtension(CallCenterExtensionBO callCenterExtensionBO) {
    checkExtensionNumber(callCenterExtensionBO.getExtensionNumber());
    if (StrUtil.isBlank(callCenterExtensionBO.getExtensionName())) {
      callCenterExtensionBO.setExtensionName(callCenterExtensionBO.getExtensionNumber());
    }
    CallCenterExtension callCenterExtension = new CallCenterExtension();
    BeanUtils.copyProperties(callCenterExtensionBO, callCenterExtension);
    save(callCenterExtension);
    inboundClient.sendSyncApiCommand("114.115.179.177:8012", freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.LUA_RUN.getApiCommand(), "aegis-extension.lua"));
    return true;
  }

  @Override
  public boolean updateCallCenterExtension(CallCenterExtensionBO callCenterExtensionBO) {
    checkExtensionNumber(callCenterExtensionBO.getExtensionNumber());
    CallCenterExtension callCenterExtension = new CallCenterExtension();
    BeanUtils.copyProperties(callCenterExtensionBO, callCenterExtension);
    return updateById(callCenterExtension);
  }

  @Override
  public CallCenterExtensionBO getCallCenterExtension(Long id) {
    CallCenterExtension callCenterExtension = getById(id);
    CallCenterExtensionBO callCenterExtensionBO = new CallCenterExtensionBO();
    BeanUtils.copyProperties(callCenterExtension, callCenterExtensionBO);
    return callCenterExtensionBO;
  }

  @Override
  public boolean deleteCallCenterExtension(Long id) {
    return removeById(id);
  }

  @Override
  public IPage<CallCenterExtensionBO> listCallCenterExtension(CallCenterExtensionBO callCenterExtensionBO) {

    IPage<CallCenterExtension> page = new Page<>(callCenterExtensionBO.getPageNum(), callCenterExtensionBO.getPageSize());

    LambdaQueryWrapper<CallCenterExtension> wrapper = Wrappers.<CallCenterExtension>lambdaQuery()
        .like(StrUtil.isNotBlank(callCenterExtensionBO.getExtensionName()), CallCenterExtension::getExtensionName, callCenterExtensionBO.getExtensionName())
        .like(StrUtil.isNotBlank(callCenterExtensionBO.getExtensionNumber()), CallCenterExtension::getExtensionNumber, callCenterExtensionBO.getExtensionNumber());
    wrapper.orderByDesc(CallCenterExtension::getCreateTime);
    IPage<CallCenterExtension> ceBasicPage = callCenterExtensionMapper.selectPage(page, wrapper);

    IPage<CallCenterExtensionBO> pageCallCenterExtension = new Page<>();
    List<CallCenterExtensionBO> fsBasicBOList = JSON.parseObject(JSON.toJSONString(ceBasicPage.getRecords()), new TypeReference<List<CallCenterExtensionBO>>() {
    });
    pageCallCenterExtension.setCurrent(ceBasicPage.getCurrent());
    pageCallCenterExtension.setSize(ceBasicPage.getSize());
    pageCallCenterExtension.setRecords(fsBasicBOList);
    pageCallCenterExtension.setTotal(ceBasicPage.getTotal());
    return pageCallCenterExtension;
  }

  @Override
  public List<CallCenterExtensionBO> queryAll() {
    List<CallCenterExtension> callCenterExtensions = callCenterExtensionMapper.queryAll();
    if (CollUtil.isEmpty(callCenterExtensions)) {
      return new ArrayList<>();
    }
    return JSON.parseObject(JSON.toJSONString(callCenterExtensions), new TypeReference<List<CallCenterExtensionBO>>() {
    });
  }

  /**
   * 判断分机号是否存在
   * @param extensionUmber 分机号
   */
  private void checkExtensionNumber(String extensionUmber) {
    LambdaQueryWrapper<CallCenterExtension> wrapper = Wrappers.<CallCenterExtension>lambdaQuery()
        .eq(StrUtil.isNotBlank(extensionUmber), CallCenterExtension::getExtensionNumber, extensionUmber);
    int count = count(wrapper);
    if (count > 0) {
      throw new BaseException(ResultCode.A1001);
    }
  }

}
