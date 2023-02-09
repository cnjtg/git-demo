package com.cnjtg.gitshardingjdbc.eventReport.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author cnjtg
 */
@Data
@ToString
public class EventReportExportDto implements Serializable {
    /**
     * 事件ID
     */
    private String eventId;

    /**
     * 节点编码
     */
    private String centerCode;

    /**
     * 事件名称
     */
    private String eventName;

    /**
     * 事件规则ID
     */
    private Long eventRuleId;

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 起始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 威胁等级
     1   很低
     2   低
     3   一般
     4   严重
     5   致命
     */
    private Integer threatLevel;
    public String threatLevelName;
    /**
     * 可信度
     1   极低
     2   低
     3   中
     4   高
     5   极高
     */
    private Integer reliabilityLevel;
    public String reliabilityLevelName;
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
    private Integer attackDir;
    public String attackDirName;
    /**
     * 事件结果
     -1 失败
     0   未知
     1   成功
     */
    private Integer result;
    public String resultName;
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
    private Integer killChainStage;
    public String killChainStageName;
    /**
     * 发生次数
     */
    private Integer occurCount;

    /**
     * 处置建议
     */
    private String eventSuggestion;

    /**
     * 路段记录创建时间
     */
    private Date createTime;

    /**
     * 中心更新时间
     */
    private Date smpUpdateTime;

    /**
     * 中心创建时间
     */
    private Date smpCreateTime;
    private String smpOrgid;
    private String smpOrgName;
    private String centerName;
    private String orgQueryCode;
    /**
     * 搜索开始时间
     */
    private Date searchBeginTime;
    /**
     * 搜索结束时间
     */
    private Date searchEndTime;

    /**
     * 研判告警级别
     * <p>
     * 1: 低（状态标红）
     * 2: 中（状态标黄）
     * 3: 高
     */
    private Integer alarmLevel;
    public String alarmLevelName;

    private String sIp;
    private String sPort;
    private String sCity;
    private String sDeviceName;
    private String sContact;
    private String sContactTel;
    private String sCenterCode;
    private String sCenterName;

    private String dIp;
    private String dPort;
    private String dCity;
    private String dDeviceName;
    private String dContact;
    private String dContactTel;
    private String dCenterCode;
    private String dCenterName;

    //源端口
    private String sourcePorts;
    //目的端口
    private String destinationPorts;
    //DNS请求记录
    private String dnsQname;
    //DNS应答
    private String dnsAnswer;
    private String dnsAnswer1;
    private String dnsAnswer2;
    //DNS响应码
    private String dnsRcode;
    //白名单事件
    private Integer isMatch;

    private String martchName;

    private Integer smpOrgSearchType;

    private String sourceIps;
    private String destinationIps;
    private String dnsRcord;

    private List<String> sourceIpList;
    private List<String> destinationIpList;

    private Integer handle;

    private String handleName;

}
