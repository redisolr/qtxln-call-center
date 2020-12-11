package com.qtxln.service.impl;

import cn.hutool.core.util.StrUtil;
import com.qtxln.esl.InboundClient;
import com.qtxln.esl.inbound.option.ServerOption;
import com.qtxln.mapper.FsBasicMapper;
import com.qtxln.model.bo.FsBasicBO;
import com.qtxln.model.entity.FsBasic;
import com.qtxln.model.entity.FsExtend;
import com.qtxln.service.FsBasicService;
import com.qtxln.service.FsExtendService;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * FS基本信息 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-05
 */
@Service
public class FsBasicServiceImpl extends ServiceImpl<FsBasicMapper, FsBasic> implements FsBasicService {

  private final FsBasicMapper fsBasicMapper;
  private final FsExtendService fsExtendService;

  @Autowired
  public FsBasicServiceImpl(FsBasicMapper fsBasicMapper, FsExtendService fsExtendService) {
    this.fsBasicMapper = fsBasicMapper;
    this.fsExtendService = fsExtendService;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public boolean insertFs(FsBasicBO fsBasicBO) {
    FsBasic fsBasic = new FsBasic();
    BeanUtils.copyProperties(fsBasicBO, fsBasic);
    save(fsBasic);
    FsExtend fsExtend = new FsExtend();
    fsExtend.setFsBasicId(fsBasic.getId());
    return fsExtendService.save(fsExtend);
  }

  @Override
  public IPage<FsBasicBO> listFs(FsBasicBO fsBasicBO) {
    IPage<FsBasic> page = new Page<>(fsBasicBO.getPageNum(), fsBasicBO.getPageSize());
    LambdaQueryWrapper<FsBasic> wrapper = Wrappers.<FsBasic>lambdaQuery()
        .like(StrUtil.isNotBlank(fsBasicBO.getName()), FsBasic::getName, "%" + fsBasicBO.getName() + "%")
        .like(StrUtil.isNotBlank(fsBasicBO.getHostName()), FsBasic::getHostName, "%" + fsBasicBO.getHostName() + "%");
    wrapper.orderByDesc(FsBasic::getCreateTime);
    IPage<FsBasic> fsBasicPage = fsBasicMapper.selectPage(page, wrapper);

    IPage<FsBasicBO> pageFsBasic = new Page<>();
    List<FsBasicBO> fsBasicBOList = JSON.parseObject(JSON.toJSONString(fsBasicPage.getRecords()), new TypeReference<List<FsBasicBO>>() {
    });
    pageFsBasic.setCurrent(fsBasicPage.getCurrent());
    pageFsBasic.setSize(fsBasicPage.getSize());
    pageFsBasic.setRecords(fsBasicBOList);
    pageFsBasic.setTotal(fsBasicPage.getTotal());
    return pageFsBasic;
  }

  @Override
  public FsBasicBO getFs(Long id) {
    FsBasic fsBasic = getById(id);
    FsBasicBO fsBasicBO = new FsBasicBO();
    BeanUtils.copyProperties(fsBasic, fsBasicBO);
    return fsBasicBO;
  }

  @Override
  public boolean updateFs(FsBasicBO fsBasicBO) {
    FsBasic fsBasic = new FsBasic();
    BeanUtils.copyProperties(fsBasicBO, fsBasic);
    return updateById(fsBasic);
  }

  @Override
  public boolean deleteFs(Long id) {
    return removeById(id);
  }

  @Override
  public boolean connectionServer(Long id) {
    FsBasic fsBasic = getById(id);
    if (fsBasic == null) {
      return false;
    }
    InboundClient.getInstance().option().addServerOption(new ServerOption(fsBasic.getHostIp(), fsBasic.getPort()));
    return true;
  }

  @Override
  public boolean disConnectionServer(Long id) {
    FsBasic fsBasic = getById(id);
    if (fsBasic == null) {
      return false;
    }
    InboundClient inboundClient = InboundClient.getInstance();
    List<ServerOption> serverOptions = inboundClient.option().serverOptions();
    for (ServerOption serverOption : serverOptions) {
      if (Objects.equals(fsBasic.getHostIp(), serverOption.host())) {
        inboundClient.option().removeServerOption(serverOption);
        break;
      }
    }
    return true;
  }


}
