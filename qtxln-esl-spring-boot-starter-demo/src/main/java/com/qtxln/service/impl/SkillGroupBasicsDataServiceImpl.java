package com.qtxln.service.impl;

import com.qtxln.mapper.SkillGroupBasicsDataMapper;
import com.qtxln.model.bo.SkillGroupBasicsDataBO;
import com.qtxln.model.entity.SkillGroupBasicsData;
import com.qtxln.service.SkillGroupBasicsDataService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 技能组基础数据 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-22
 */
@Service
public class SkillGroupBasicsDataServiceImpl extends ServiceImpl<SkillGroupBasicsDataMapper, SkillGroupBasicsData> implements SkillGroupBasicsDataService {

  private final SkillGroupBasicsDataMapper skillGroupBasicsDataMapper;

  public SkillGroupBasicsDataServiceImpl(SkillGroupBasicsDataMapper skillGroupBasicsDataMapper) {
    this.skillGroupBasicsDataMapper = skillGroupBasicsDataMapper;
  }

  @Override
  public IPage<SkillGroupBasicsDataBO> listPageSkillGroupBasicsDataOneDay(SkillGroupBasicsDataBO skillGroupBasicsDataBO) {
    IPage<SkillGroupBasicsData> page = new Page<>(skillGroupBasicsDataBO.getPageNum(), skillGroupBasicsDataBO.getPageSize());
    IPage<SkillGroupBasicsData> skillGroupBasicsDataPage = skillGroupBasicsDataMapper.listPageSkillGroupDataOneDay(page, skillGroupBasicsDataBO);
    IPage<SkillGroupBasicsDataBO> basicsDataPage = new Page<>();
    List<SkillGroupBasicsDataBO> skillGroupList = JSON.parseObject(JSON.toJSONString(skillGroupBasicsDataPage.getRecords()), new TypeReference<List<SkillGroupBasicsDataBO>>() {
    });
    skillGroupList.forEach(agentBasics -> {
      // 总登录时长
      agentBasics.setTotalLoggedInTime(agentBasics.getTotalBreakTime() + agentBasics.getTotalReadyTime()
          + agentBasics.getTotalRingTime() + agentBasics.getTotalTalkTime());
      // 平均通话时长
      agentBasics.setAverageTalkTime(BigDecimal.ZERO);
      if (agentBasics.getTotalCalls() != null && agentBasics.getTotalCalls() != 0) {
        BigDecimal divide = BigDecimal.valueOf(agentBasics.getTotalTalkTime())
            .divide(new BigDecimal(agentBasics.getTotalCalls()), 2, BigDecimal.ROUND_HALF_UP);
        agentBasics.setAverageTalkTime(divide);
      }
      // 平均就绪时长
      agentBasics.setAverageReadyTime(BigDecimal.ZERO);
      if (agentBasics.getReadyCount() != null && agentBasics.getReadyCount() != 0) {
        BigDecimal divide = BigDecimal.valueOf(agentBasics.getTotalReadyTime())
            .divide(new BigDecimal(agentBasics.getReadyCount()), 2, BigDecimal.ROUND_HALF_UP);
        agentBasics.setAverageReadyTime(divide);
      }
    });

    basicsDataPage.setCurrent(skillGroupBasicsDataPage.getCurrent());
    basicsDataPage.setSize(skillGroupBasicsDataPage.getSize());
    basicsDataPage.setRecords(skillGroupList);
    basicsDataPage.setTotal(skillGroupBasicsDataPage.getTotal());
    return basicsDataPage;
  }
}
