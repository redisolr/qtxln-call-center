package com.qtxln.component.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis自动生成
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/5 21:12 下午
 * @since 1.0
 */
public class MybatisGenerator {
  /**
   * 要生产的表名
   */
  private static final String[] TABLE = {"recording_information"};
  /**
   * global
   */
  private static final String AUTHOR = "秦腾";
  /**
   * data-source
   */
  // private static final String JDBC = "jdbc:mysql://rm-8vb3419geot0335r3qo.mysql.zhangbei.rds.aliyuncs.com/fs?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
  private static final String JDBC = "jdbc:mysql://192.168.10.9:3309/aegis_callcenter?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
  private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
  // private static final String USERNAME = "xushaofan";
  // private static final String PASSWORD = "fange654321";
  private static final String USERNAME = "court";
  private static final String PASSWORD = "Txtfy_CC_Court_2019";

  /**
   * package
   */
  private static final String PARENT_PACKAGE = "com.aegis.fs";
  private static final String ENTITY_PACKAGE = "model.entity";
  private static final String MAPPER_PACKAGE = "mapper";
  private static final String SERVICE_PACKAGE = "service";
  private static final String SERVICE_IMPL_PACKAGE = "service.impl";
  private static final String CONTROLLER_PACKAGE = "controller";


  public static void main(String[] args) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    // 输出目录
    gc.setOutputDir(projectPath + "/freeswitch-esl-spring-boot-starter-demo/src/main/java");
    // 作者
    gc.setAuthor(AUTHOR);
    // 生成后打开文件
    gc.setOpen(false);
    // 是否覆盖文件
    gc.setFileOverride(true);
    // 自定义文件命名，注意 %s 会自动填充表实体属性！
    gc.setMapperName("%sMapper");
    gc.setXmlName("%sMapper");
    gc.setServiceName("%sService");
    gc.setServiceImplName("%sServiceImpl");
    gc.setControllerName("%sController");
    // 实体属性 Swagger2 注解
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(JDBC);
    dsc.setDriverName(DRIVER_NAME);
    dsc.setUsername(USERNAME);
    dsc.setPassword(PASSWORD);
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setParent(PARENT_PACKAGE);
    pc.setEntity(ENTITY_PACKAGE);
    pc.setMapper(MAPPER_PACKAGE);
    pc.setService(SERVICE_PACKAGE);
    pc.setServiceImpl(SERVICE_IMPL_PACKAGE);
    pc.setController(CONTROLLER_PACKAGE);
    mpg.setPackageInfo(pc);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    // 表名生成策略
    strategy.setNaming(NamingStrategy.underline_to_camel);
    // 字段名生成策略
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    // 是否为lombok模型
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    // boolean类型字段是否移除前缀
    strategy.setEntityBooleanColumnRemoveIsPrefix(true);
    strategy.setControllerMappingHyphenStyle(true);
    // 表名前缀
    strategy.setTablePrefix(pc.getModuleName() + "_");
    // 需要生成的表
    strategy.setInclude(TABLE);
    mpg.setStrategy(strategy);

    // 模板配置
    TemplateConfig tc = new TemplateConfig();
    //关闭xml生成
    tc.setXml(null);
    mpg.setTemplate(tc);

    mpg.execute();
  }
}

