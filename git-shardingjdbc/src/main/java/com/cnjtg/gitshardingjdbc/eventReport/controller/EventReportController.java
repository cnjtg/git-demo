package com.cnjtg.gitshardingjdbc.eventReport.controller;

import com.cnjtg.gitshardingjdbc.eventReport.dto.EventReportDto;
import com.cnjtg.gitshardingjdbc.eventReport.service.EventReportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/eventReport")
public class EventReportController {
    protected Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private EventReportService eventReportService;

    @GetMapping(value = "/page")
    public List<EventReportDto> listPage(EventReportDto eventreportDto) {
        return eventReportService.selectList(eventreportDto);
    }

}

