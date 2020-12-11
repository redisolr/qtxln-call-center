package com.qtxln.service;

import com.qtxln.model.bo.FsExtendBO;
import com.qtxln.model.entity.FsExtend;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * FS服务器扩展信息 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-05
 */
public interface FsExtendService extends IService<FsExtend> {

  /**
   * 获取fs扩展详情
   *
   * @param fsBasicId fs基本信息id
   * @return fs扩展详情
   */
  FsExtendBO getExtendFs(Long fsBasicId);


  /**
   * 更新fs扩展信息
   *
   * @param fsExtendBO fs扩展信息
   * @return 是否更新成功
   */
  boolean updateFsExtend(FsExtendBO fsExtendBO);

}
