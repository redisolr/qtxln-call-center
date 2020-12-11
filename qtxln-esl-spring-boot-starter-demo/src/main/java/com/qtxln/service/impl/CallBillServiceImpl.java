package com.qtxln.service.impl;

import cn.hutool.core.util.StrUtil;
import com.qtxln.core.cb.CallBillInfoGenerate;
import com.qtxln.mapper.CallBillMapper;
import com.qtxln.model.bo.CallBillBO;
import com.qtxln.model.bo.CallBillInfoBO;
import com.qtxln.model.core.cb.CallBillInfo;
import com.qtxln.model.entity.CallBill;
import com.qtxln.service.CallBillService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 通话清单(话单) 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-21
 */
@Service
public class CallBillServiceImpl extends ServiceImpl<CallBillMapper, CallBill> implements CallBillService {

  private final CallBillMapper callBillMapper;
  private final CallBillInfoGenerate callBillInfoGenerate;

  @Autowired
  public CallBillServiceImpl(CallBillMapper callBillMapper, CallBillInfoGenerate callBillInfoGenerate) {
    this.callBillMapper = callBillMapper;
    this.callBillInfoGenerate = callBillInfoGenerate;
  }


  @Override
  public boolean updateByUniqueId(CallBill callBill) {
    if (StrUtil.isBlank(callBill.getUniqueId())) {
      return Boolean.FALSE;
    }
    LambdaQueryWrapper<CallBill> wrapper = Wrappers.lambdaQuery();
    wrapper.eq(CallBill::getUniqueId, callBill.getUniqueId());
    return update(callBill, wrapper);
  }

  @Override
  public int countByMemberSessionId(String memberSessionId) {
    LambdaQueryWrapper<CallBill> wrapper = Wrappers.lambdaQuery();
    wrapper.eq(CallBill::getMemberSessionId, memberSessionId);
    return count(wrapper);
  }

  @Override
  public List<CallBill> getByMemberSessionId(String memberSessionId) {
    LambdaQueryWrapper<CallBill> wrapper = Wrappers.lambdaQuery();
    wrapper.eq(CallBill::getMemberSessionId, memberSessionId);
    return list(wrapper);
  }

  @Override
  public IPage<CallBillBO> listCallBill(CallBillBO callBillBO) {
    IPage<CallBill> page = new Page<>(callBillBO.getPageNum(), callBillBO.getPageSize());
    LambdaQueryWrapper<CallBill> wrapper = Wrappers.<CallBill>lambdaQuery()
        .eq(CallBill::getEffective, Boolean.TRUE)
        .like(StrUtil.isNotBlank(callBillBO.getCallerNumber()), CallBill::getCallerNumber, callBillBO.getCallerNumber())
        .like(StrUtil.isNotBlank(callBillBO.getCalledNumber()), CallBill::getCalledNumber, callBillBO.getCalledNumber())
        .eq(StrUtil.isNotBlank(callBillBO.getCallType()), CallBill::getCallType, callBillBO.getCallType())
        .eq(StrUtil.isNotBlank(callBillBO.getAgent()), CallBill::getAgent, callBillBO.getAgent());
    wrapper.orderByDesc(CallBill::getCreateTime);
    IPage<CallBill> callBillPagePage = callBillMapper.selectPage(page, wrapper);

    IPage<CallBillBO> pageCallBill = new Page<>();
    List<CallBillBO> callBillBOList = JSON.parseObject(JSON.toJSONString(callBillPagePage.getRecords()), new TypeReference<List<CallBillBO>>() {
    });
    pageCallBill.setCurrent(callBillPagePage.getCurrent());
    pageCallBill.setSize(callBillPagePage.getSize());
    pageCallBill.setRecords(callBillBOList);
    pageCallBill.setTotal(callBillPagePage.getTotal());
    return pageCallBill;
  }

  @Override
  public List<CallBillInfoBO> getCallBill(Long id) {
    CallBill callBill = getById(id);
    List<CallBillInfo> callBillInfos = callBillInfoGenerate.generateCallBillInfo(callBill.getUniqueId());
    return JSON.parseObject(JSON.toJSONString(callBillInfos), new TypeReference<List<CallBillInfoBO>>() {
    });
  }

}
