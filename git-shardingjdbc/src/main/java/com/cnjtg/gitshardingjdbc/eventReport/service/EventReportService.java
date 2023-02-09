package com.cnjtg.gitshardingjdbc.eventReport.service;

import com.cnjtg.gitshardingjdbc.eventReport.dto.EventReportDto;
import com.cnjtg.gitshardingjdbc.eventReport.dto.EventReportExportDto;

import java.util.List;

/**
 * 事件服务
 *
 * @author cnjtg
 * @date 2022/10/24
 */
public interface EventReportService {


    /**
     * 获取列表
     *
     * @param eventReportDto 事件报告dto
     * @return {@link List}<{@link EventReportExportDto}>
     */
    List<EventReportDto> selectList(EventReportDto eventReportDto);
}
