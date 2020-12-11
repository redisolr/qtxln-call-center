package com.qtxln.mapper;

import com.qtxln.model.entity.CallCenterExtension;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 分机表 Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-31
 */
public interface CallCenterExtensionMapper extends BaseMapper<CallCenterExtension> {

  /**
   * 查询全部分机
   * @return 分机列表
   */
  List<CallCenterExtension> queryAll();

}
