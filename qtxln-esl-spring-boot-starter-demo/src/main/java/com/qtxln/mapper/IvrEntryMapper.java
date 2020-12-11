package com.qtxln.mapper;

import com.qtxln.model.bo.IvrEntryBO;
import com.qtxln.model.entity.IvrEntry;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
public interface IvrEntryMapper extends BaseMapper<IvrEntry> {

  IPage<IvrEntry> listPageIvrEntry(IPage<IvrEntry> page,
                                   @Param("ivrEntryBO") IvrEntryBO ivrEntryBO);

}
