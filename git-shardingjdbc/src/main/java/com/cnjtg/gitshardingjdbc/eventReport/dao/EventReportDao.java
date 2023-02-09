package com.cnjtg.gitshardingjdbc.eventReport.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cnjtg.gitshardingjdbc.eventReport.dto.EventReportDto;
import com.cnjtg.gitshardingjdbc.eventReport.model.EventReport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 事件报告刀
 *
 * @author cnjtg
 * @date 2022/10/18
 */
@Mapper
public interface EventReportDao extends BaseMapper<EventReport> {

    /**
     * 选择列表
     *
     * @param eventReportDto 事件报告dto
     * @return {@link List}<{@link EventReportDto}>
     */
    List<EventReportDto> selectList(@Param("eventReportDto") EventReportDto eventReportDto);

}
