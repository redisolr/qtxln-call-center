package com.qtxln.service.impl;

import com.qtxln.mapper.FsExtendMapper;
import com.qtxln.model.bo.FsExtendBO;
import com.qtxln.model.entity.FsExtend;
import com.qtxln.service.FsExtendService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * FS服务器扩展信息 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-05
 */
@Service
public class FsExtendServiceImpl extends ServiceImpl<FsExtendMapper, FsExtend> implements FsExtendService {

  @Override
  public FsExtendBO getExtendFs(Long fsBasicId) {
    LambdaQueryWrapper<FsExtend> wrapper = Wrappers.<FsExtend>lambdaQuery().eq(FsExtend::getFsBasicId, fsBasicId);
    FsExtend fsExtend = getOne(wrapper);
    FsExtendBO fsExtendBO = new FsExtendBO();
    BeanUtils.copyProperties(fsExtend, fsExtendBO);
    return fsExtendBO;
  }

  @Override
  public boolean updateFsExtend(FsExtendBO fsExtendBO) {
    FsExtend fsExtend = new FsExtend();
    BeanUtils.copyProperties(fsExtendBO, fsExtend);
    return updateById(fsExtend);
  }
}
