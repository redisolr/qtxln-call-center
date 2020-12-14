/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云RDS
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : rm-8vb3419geot0335r3qo.mysql.zhangbei.rds.aliyuncs.com:3306
 Source Schema         : fs

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 14/12/2020 16:15:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agent_basics_data
-- ----------------------------
DROP TABLE IF EXISTS `agent_basics_data`;
CREATE TABLE `agent_basics_data`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `agent_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐席名称',
  `total_logged_in_time` bigint(20) NULL DEFAULT NULL COMMENT '总登录时长(单位:秒)',
  `total_break_time` bigint(20) NULL DEFAULT NULL COMMENT '总未就绪时长(单位:秒)',
  `max_break_time` bigint(20) NULL DEFAULT NULL COMMENT '最大未就绪时长(单位:秒)',
  `total_ready_time` bigint(20) NULL DEFAULT NULL COMMENT '总就绪时长(单位:秒)',
  `max_ready_time` bigint(20) NULL DEFAULT NULL COMMENT '最大就绪时长(单位:秒)',
  `average_ready_time` decimal(10, 2) NULL DEFAULT NULL COMMENT '平均就绪时长(单位:秒)',
  `total_calls` bigint(20) NULL DEFAULT NULL COMMENT '总电话接待量',
  `total_ring_time` bigint(20) NULL DEFAULT NULL COMMENT '总振铃时长(单位:秒)',
  `max_ring_time` bigint(20) NULL DEFAULT NULL COMMENT '最大振铃时长(单位:秒)',
  `average_ring_time` decimal(10, 2) NULL DEFAULT NULL COMMENT '平均振铃时长(单位:秒)',
  `total_talk_time` bigint(20) NULL DEFAULT NULL COMMENT '总通话时长(单位:秒)',
  `max_talk_time` bigint(20) NULL DEFAULT NULL COMMENT '最大通话时长(单位:秒)',
  `average_talk_time` decimal(10, 2) NULL DEFAULT NULL COMMENT '平均通话时长(单位:秒)',
  `total_work_time` bigint(20) NULL DEFAULT NULL COMMENT '总话后处理时长(单位:秒)',
  `max_work_time` bigint(20) NULL DEFAULT NULL COMMENT '最大话后处理时长(单位:秒)',
  `average_work_time` decimal(10, 2) NULL DEFAULT NULL COMMENT '平均话后处理时长(单位:秒)',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '坐席数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for agent_state_record
-- ----------------------------
DROP TABLE IF EXISTS `agent_state_record`;
CREATE TABLE `agent_state_record`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `agent_id` bigint(20) NOT NULL COMMENT '坐席id',
  `agent_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐席名称',
  `agent_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐席状态',
  `duration` bigint(20) UNSIGNED NULL DEFAULT 0 COMMENT '持续时间(单位:秒)',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 492 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '坐席状态记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for call_bill
-- ----------------------------
DROP TABLE IF EXISTS `call_bill`;
CREATE TABLE `call_bill`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `unique_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'channel的uuid',
  `member_session_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '同一通电话标识',
  `caller_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主叫号码',
  `called_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被叫号码',
  `call_time` datetime(0) NULL DEFAULT NULL COMMENT '拨打时间',
  `answer_time` datetime(0) NULL DEFAULT NULL COMMENT '接听时间',
  `hang_up_time` datetime(0) NULL DEFAULT NULL COMMENT '挂断时间',
  `call_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '呼叫类型',
  `hangup_cause` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '挂断原因',
  `hangup_cause_str` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '挂断原因含义',
  `total_time` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '总时长',
  `talk_time` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '通话时长',
  `satisfaction` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '满意度',
  `agent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐席',
  `skill_group` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技能组 ',
  `is_transfer` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否转接(0否,1是)',
  `is_effective` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否有效(0否,1是)',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_id_index`(`unique_id`) USING BTREE COMMENT 'channel uuid index'
) ENGINE = InnoDB AUTO_INCREMENT = 4925 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通话清单(话单)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for call_bill_statistics
-- ----------------------------
DROP TABLE IF EXISTS `call_bill_statistics`;
CREATE TABLE `call_bill_statistics`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `in_coming_line_count` bigint(20) NULL DEFAULT NULL COMMENT '进线量',
  `in_coming_queue_count` bigint(20) NULL DEFAULT NULL COMMENT '转人工量',
  `intelligent_voice_count` bigint(20) NULL DEFAULT NULL COMMENT '智能语音量',
  `answered_by_agent_count` bigint(20) NULL DEFAULT NULL COMMENT '接听量',
  `outbound_count` bigint(20) NULL DEFAULT NULL COMMENT '回拨量',
  `outbound_answered_count` bigint(20) NULL DEFAULT NULL COMMENT '回拨接听量',
  `abandoned_in_contact_flow_count` bigint(20) NULL DEFAULT NULL COMMENT '今日IVR放弃量',
  `abandoned_in_queue_count` bigint(20) NULL DEFAULT NULL COMMENT '今日队列放弃量',
  `abandoned_in_queue_timeout` bigint(20) NULL DEFAULT NULL COMMENT '队列超时量',
  `abandoned_by_ring_count` bigint(20) NULL DEFAULT NULL COMMENT '振铃放弃量',
  `abandoned_by_agent_count` bigint(20) NULL DEFAULT NULL COMMENT '今日坐席放弃量',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '话单统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for call_center_extension
-- ----------------------------
DROP TABLE IF EXISTS `call_center_extension`;
CREATE TABLE `call_center_extension`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fs_id` bigint(20) NULL DEFAULT NULL COMMENT 'fs服务器id',
  `extension_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分机名称',
  `extension_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分机号',
  `outbound_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外呼显示名称',
  `outbound_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外呼显示号码',
  `agent_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐席工号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `is_outbound` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '允许外呼',
  `is_play_job_num` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '播报工号',
  `media_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '媒体文件id',
  `is_after_process` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '坐席通话后启用后处理功能',
  `is_sound_recording` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '允许录音',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分机类型',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `sip_trunk` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sip网关',
  `is_web_rtc` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '启用WebRTC',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分机表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for call_center_media
-- ----------------------------
DROP TABLE IF EXISTS `call_center_media`;
CREATE TABLE `call_center_media`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fs_id` bigint(20) NULL DEFAULT NULL COMMENT 'fs服务器id',
  `business_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务名称',
  `file_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `original_file_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原始文件名称',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件类型',
  `size` bigint(20) NOT NULL COMMENT '文件大小(单位:字节)',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '呼叫中心-媒体资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for call_center_skill_group
-- ----------------------------
DROP TABLE IF EXISTS `call_center_skill_group`;
CREATE TABLE `call_center_skill_group`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `skill_group_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技能组名称',
  `routing_strategy` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由(振铃)策略',
  `moh_sound` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '队列语音(语音文件参数)',
  `announce_sound` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '播报音乐',
  `announce_frequency` int(10) NULL DEFAULT NULL COMMENT '播报频率',
  `record_template` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '录音文件参数(录音文件路径)',
  `time_base_score` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时基分数(优先级相关的时间积分选项)',
  `max_wait_time` int(10) NULL DEFAULT NULL COMMENT '最大等待时间(超过时间未被接通将退出callcenter)0为禁用',
  `max_wait_time_with_no_agent` int(10) NULL DEFAULT NULL COMMENT '最大等待时间与无代理(超出时间电话会退出callcenter )0为禁用',
  `max_wait_time_with_no_agent_time_reached` int(10) NULL DEFAULT NULL COMMENT '拒绝新来电间隔时间(max-wait-time-with-no-agent触发时有效)',
  `tier_rules_apply` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '梯队匹配(0所有梯队,1匹配规则tier-rule*)',
  `tier_rule_wait_second` int(10) NULL DEFAULT NULL COMMENT '梯队的等待时间(进入下个梯队的时间)',
  `tier_rule_wait_multiply_level` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '梯队等待级别(0第一个梯队等其余不等,1所有梯队都等)',
  `tier_rule_no_agent_no_wait` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否跳过no-agent的梯队(0不跳过,1跳过)',
  `abandoned_resume_allowed` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '丢弃后是否允许恢复或者重新进入队列(0否,1是)',
  `discard_abandoned_after` int(10) NULL DEFAULT NULL COMMENT '最大放弃时长(丢弃超过此时长,将不可以恢复)',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '技能组表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for call_center_skill_group_agent
-- ----------------------------
DROP TABLE IF EXISTS `call_center_skill_group_agent`;
CREATE TABLE `call_center_skill_group_agent`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `agent_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '坐席名称',
  `skill_group_id` bigint(20) NULL DEFAULT NULL COMMENT '技能组id',
  `extension_id` bigint(20) NULL DEFAULT NULL COMMENT '分机id',
  `call_time_out` int(20) NULL DEFAULT NULL COMMENT '呼叫超时时间',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `max_no_answer` int(10) NULL DEFAULT NULL COMMENT '最大无应答次数',
  `wrap_up_time` int(10) NULL DEFAULT NULL COMMENT '话后处理时间',
  `reject_delay_time` int(10) NULL DEFAULT NULL COMMENT '坐席拒绝后延迟时间',
  `busy_delay_time` int(10) NULL DEFAULT NULL COMMENT '坐席忙延迟时间',
  `level` int(10) NULL DEFAULT NULL COMMENT '等级',
  `position` int(10) NULL DEFAULT NULL COMMENT '地位',
  `no_answer_delay_time` int(10) NULL DEFAULT NULL COMMENT '无应答重试时间',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '技能组坐席表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dialplan
-- ----------------------------
DROP TABLE IF EXISTS `dialplan`;
CREATE TABLE `dialplan`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dialplan_chinese_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中文名',
  `dialplan_english_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文名',
  `regular_rules` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正则表达式',
  `dialplan_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `dialplan_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '拨号计划内容',
  `dialplan_template_arr` json NULL COMMENT '拨号计划模板id数组',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '拨号计划表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dialplan_application
-- ----------------------------
DROP TABLE IF EXISTS `dialplan_application`;
CREATE TABLE `dialplan_application`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fs_id` bigint(20) NULL DEFAULT NULL COMMENT 'fs服务器id',
  `application_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'app名称',
  `application_meaning` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'app含义',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '拨号计划-app表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dialplan_template
-- ----------------------------
DROP TABLE IF EXISTS `dialplan_template`;
CREATE TABLE `dialplan_template`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dialplan_app_id` bigint(20) NULL DEFAULT NULL COMMENT '拨号计划appid',
  `dialplan_app_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拨号计划app参数值',
  `dialplan_template_effect` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板作用',
  `dialplan_template_class_id` bigint(20) NULL DEFAULT NULL COMMENT '模板分类id',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '拨号计划-模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fs_basic
-- ----------------------------
DROP TABLE IF EXISTS `fs_basic`;
CREATE TABLE `fs_basic`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'FS名称',
  `host_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主机名',
  `host_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ip地址',
  `port` smallint(5) UNSIGNED NOT NULL COMMENT '端口',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'FS服务器基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fs_extend
-- ----------------------------
DROP TABLE IF EXISTS `fs_extend`;
CREATE TABLE `fs_extend`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fs_basic_id` bigint(20) NULL DEFAULT NULL COMMENT 'FS基本信息id',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'FS安装路径',
  `voice_device_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '语音设备类型',
  `record_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '录音文件位置',
  `sip_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'internal' COMMENT 'SIP类型(语音服务分机注册类型)',
  `is_auto_answer` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动应答',
  `is_sip_auto_answer` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'sip是否自动应答',
  `is_call_center` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用呼叫中心',
  `is_after_process` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '坐席通话后是否启用后处理功能',
  `abs_codec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通信编码',
  `is_web_rtc` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用WebRTC',
  `web_rtc_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'WebRTC地址',
  `web_rtc_port` smallint(5) NULL DEFAULT NULL COMMENT 'WebRTC端口',
  `sip_port` smallint(5) NULL DEFAULT NULL COMMENT 'SIP服务端口',
  `is_web_rtc_ssl` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT 'WebRTC启用SSL',
  `web_rtc_ring` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来电铃声',
  `is_hidden_number` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '外呼隐藏号码',
  `min_num_length` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '最小号码长度',
  `max_num_length` tinyint(3) NULL DEFAULT NULL COMMENT '最大号码长度',
  `blacklist` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '黑名单筛选条件',
  `whitelist` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '白名单筛选条件',
  `blacklist_ip_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '黑名单ip地区',
  `whitelist_ip_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '白名单ip地区',
  `is_call_blocking_record` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否保存呼叫拦截记录',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'FS服务器扩展信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ivr
-- ----------------------------
DROP TABLE IF EXISTS `ivr`;
CREATE TABLE `ivr`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ivr_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ivr名称',
  `great_long` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '欢迎音',
  `greet_short` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简短提示音',
  `invalid_sound` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按键错误提示音',
  `exit_sound` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退出(超时)提示音',
  `trans_sound` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转接提示音',
  `timeout` int(10) NULL DEFAULT NULL COMMENT '超时时间(单位:毫秒)',
  `max_failures` int(10) NULL DEFAULT NULL COMMENT '最大错误按键次数',
  `max_timeouts` int(10) NULL DEFAULT NULL COMMENT '最大超时次数',
  `inter_digit_timeout` int(10) NULL DEFAULT NULL COMMENT '两次按键的最大时间间隔(单位:毫秒)',
  `digit_len` int(10) NULL DEFAULT NULL COMMENT '菜单长度',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父id',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `ivr_graph` json NULL COMMENT 'ivr图(可放入mongoDB或es)',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'IVR' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ivr_entry
-- ----------------------------
DROP TABLE IF EXISTS `ivr_entry`;
CREATE TABLE `ivr_entry`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ivr_id` bigint(20) NULL DEFAULT NULL COMMENT 'ivrId',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'action类型',
  `digits` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按键',
  `param` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建用户',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for skill_group_basics_data
-- ----------------------------
DROP TABLE IF EXISTS `skill_group_basics_data`;
CREATE TABLE `skill_group_basics_data`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `skill_group_id` bigint(20) NULL DEFAULT NULL COMMENT '技能组id',
  `skill_group_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技能组名称',
  `total_calls` bigint(20) NULL DEFAULT NULL COMMENT '总电话接待量',
  `total_logged_in_time` bigint(20) NULL DEFAULT NULL COMMENT '总登录时长',
  `total_break_time` bigint(20) NULL DEFAULT NULL COMMENT '总未就绪时长',
  `total_ready_time` bigint(20) NULL DEFAULT NULL COMMENT '总就绪时长',
  `max_ready_time` bigint(20) NULL DEFAULT NULL COMMENT '最大就绪时长',
  `average_ready_time` decimal(10, 2) NULL DEFAULT NULL COMMENT '平均就绪时长',
  `total_ring_time` bigint(20) NULL DEFAULT NULL COMMENT '总振铃时长',
  `total_talk_time` bigint(20) NULL DEFAULT NULL COMMENT '总通话时长',
  `max_talk_time` bigint(20) NULL DEFAULT NULL COMMENT '最大通话时长',
  `average_talk_time` decimal(10, 2) NULL DEFAULT NULL COMMENT '平均通话时长',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '技能组基础数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典名',
  `dic_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代码',
  `dic_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父id',
  `sort_value` tinyint(3) NULL DEFAULT NULL COMMENT '排序值',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0否,1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
