package com.qtxln.service;

import com.qtxln.model.bo.FsBasicBO;
import com.qtxln.model.entity.FsBasic;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * FS基本信息 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-05
 */
public interface FsBasicService extends IService<FsBasic> {

  /**
   * 添加fs
   * @param fsBasicBO fs信息
   * @return 是否添加成功
   */
  boolean insertFs(FsBasicBO fsBasicBO);

  /**
   * 查询fs列表
   * @param fsBasicBO 查询参数
   * @return 分页信息和数据
   */
  IPage<FsBasicBO> listFs(FsBasicBO fsBasicBO);

  /**
   * 获取fs详情
   * @param id 主键
   * @return fs详情
   */
  FsBasicBO getFs(Long id);

  /**
   * 更新fs信息
   * @param fsBasicBO fs信息
   * @return 是否更新成功
   */
  boolean updateFs(FsBasicBO fsBasicBO);

  /**
   * 删除fs信息
   * @param id 主键
   * @return 是否删除成功
   */
  boolean deleteFs(Long id);

  /**
   * 连接服务
   * @param id 服务id
   * @return 是否连接成功
   */
  boolean connectionServer(Long id);

  /**
   * 顿开连接
   * @param id 服务id
   * @return 是否断开成功
   */
  boolean disConnectionServer(Long id);

}
