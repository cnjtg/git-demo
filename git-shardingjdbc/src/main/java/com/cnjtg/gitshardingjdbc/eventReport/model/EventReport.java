package com.cnjtg.gitshardingjdbc.eventReport.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@SuppressWarnings("serial")
@TableName("smp_event_report")
@Data
public class EventReport {
    private static final long serialVersionUID = 991580480004906398L;
 /**
  * 事件ID
  */
 @TableId("event_id")
 private String eventId;

 /**
  * 节点编码
  */
 @TableField("center_code")
 private String centerCode;

 /**
  * 事件名称
  */
 @TableField("event_name")
 private String eventName;

 /**
  * 事件规则ID
  */
 @TableField("event_rule_id")
 private Long eventRuleId;

 /**
  * 事件类型
  */
 @TableField("event_type")
 private String eventType;

 /**
  * 起始时间
  */
 @TableField("start_time")
 private Date startTime;

 /**
  * 结束时间
  */
 @TableField("end_time")
 private Date endTime;

 /**
  * 威胁等级
  1   很低
  2   低
  3   一般
  4   严重
  5   致命
  */
 @TableField("threat_level")
 private Integer threatLevel;

 /**
  * 可信度
  1   极低
  2   低
  3   中
  4   高
  5   极高
  */
 @TableField("reliability_level")
 private Integer reliabilityLevel;

 /**
  * 攻击方向
  0   其他。
  1   源是攻击者，目的是被攻击者
  2   源是被攻击者，目的是攻击者
  3   源是攻击者，目的不是被攻击者
  4   源是被攻击者，目的不是攻击者
  5   目的是攻击者，源不是被攻击者
  6   目的是被攻击者，源不是攻击者
  */
 @TableField("attack_dir")
 private Integer attackDir;

 /**
  * 事件结果
  -1 失败
  0   未知
  1   成功
  */
 @TableField("result")
 private Integer result;

 /**
  * 攻击链阶段
  1   侦查
  2   工具制作
  3   投放
  4   攻击渗透
  5   安装工具
  6   命令控制
  7   恶意活动
  */
 @TableField("kill_chain_stage")
 private Integer killChainStage;

 /**
  * 发生次数
  */
 @TableField("occur_count")
 private Integer occurCount;

 /**
  * 处置建议
  */
 @TableField("event_suggestion")
 private String eventSuggestion;

 /**
  * 路段记录创建时间
  */
 @TableField("create_time")
 private Date createTime;

 /**
  * 中心更新时间
  */
 @TableField("smp_update_time")
 private Date smpUpdateTime;

 /**
  * 中心创建时间
  */
 @TableField("smp_create_time")
 private Date smpCreateTime;

}