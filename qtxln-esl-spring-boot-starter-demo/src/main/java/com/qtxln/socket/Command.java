package com.qtxln.socket;

import com.qtxln.model.handler.ChannelCreate;
import lombok.Data;

/**
 * Command
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/15 10:43 上午
 * @since 1.0
 */
@Data
public class Command {

  private String commandName;
  private String extension;
  private String addr;
  private ChannelCreate current;
  private String dialNumber;
  private String agent;
  private String skillGroup;

}

