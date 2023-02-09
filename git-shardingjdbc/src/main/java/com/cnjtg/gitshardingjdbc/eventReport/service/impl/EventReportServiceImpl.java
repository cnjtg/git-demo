package com.cnjtg.gitshardingjdbc.eventReport.service.impl;

import com.cnjtg.gitshardingjdbc.eventReport.dao.EventReportDao;
import com.cnjtg.gitshardingjdbc.eventReport.dto.EventReportDto;
import com.cnjtg.gitshardingjdbc.eventReport.service.EventReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 事件报告服务impl
 *
 * @author cnjtg
 * @date 2022/10/21
 */
@Service
public class EventReportServiceImpl implements EventReportService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private EventReportDao eventReportDao;



    @Override
    public List<EventReportDto> selectList(EventReportDto eventReportDto) {
        long start = System.currentTimeMillis();
        List<EventReportDto> list = eventReportDao.selectList(eventReportDto);
        return list;
    }


}
