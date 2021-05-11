package com.cnjtg.gitspringboot;

import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cnjtg
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.cnjtg.gitspringboot.mapper")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.trace("跟踪");
        log.debug("调试");
        log.info("信息");
        log.warn("警告");
        log.error("异常");
    }

}
