package com.qtxln.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * 用户VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/8 17:24 下午
 * @since 1.0
 */
@Data
public class UserVO {

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private String username;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private String password;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private String token;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> roles;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private String introduction;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private String avatar;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private String name;

}

