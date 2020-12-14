package com.qtxln.controller;


import com.qtxln.component.result.InvokerPageResult;
import com.qtxln.component.result.Pager;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.bo.SkillGroupBasicsDataBO;
import com.qtxln.model.vo.SkillGroupBasicsDataVO;
import com.qtxln.service.SkillGroupBasicsDataService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 技能组基础数据 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-22
 */
@RestController
@RequestMapping("/api/v1/skill_group_basics_data")
public class SkillGroupBasicsDataController extends BaseController {

  private final SkillGroupBasicsDataService skillGroupBasicsDataService;

  public SkillGroupBasicsDataController(SkillGroupBasicsDataService skillGroupBasicsDataService) {
    this.skillGroupBasicsDataService = skillGroupBasicsDataService;
  }

  @GetMapping()
  public InvokerPageResult<List<SkillGroupBasicsDataVO>> listPageSkillGroupBasicsDataOneDay(
      @Validated(value = {SkillGroupBasicsDataVO.GroupQuery.class}) SkillGroupBasicsDataVO skillGroupBasicsDataVO) {
    SkillGroupBasicsDataBO skillGroupBasicsDataBO = new SkillGroupBasicsDataBO();
    BeanUtils.copyProperties(skillGroupBasicsDataVO, skillGroupBasicsDataBO);
    IPage<SkillGroupBasicsDataBO> page = skillGroupBasicsDataService.listPageSkillGroupBasicsDataOneDay(skillGroupBasicsDataBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<SkillGroupBasicsDataVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

