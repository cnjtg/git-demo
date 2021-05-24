package com.cnjtg.gitspringboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-11 10:43
 * @remark 本类引用druid-spring-boot-starter 后不用自己配置
 */
//@Configuration
//@ConditionalOnProperty("spring.datasource.type")
public class DruidConfiguration {

    /**
     * 数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

//    @Bean
//    public DataSource dataSource(DataSourceProperties properties){
//        return properties.initializeDataSourceBuilder().build();
//    }

    /**
     * 监控台
     * @return
     */

    @Bean
    public ServletRegistrationBean startViewServlet(){

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //允许访问
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //禁止访问
//        servletRegistrationBean.addInitParameter("deny","127.0.0.1");
        //登录账号密码
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","admin");

        //是否可以重置数据
        servletRegistrationBean.addInitParameter("restEnable","false");

        return servletRegistrationBean;
    }


    /**
     * 过滤资源
     * @return
     */
    @Bean
    public FilterRegistrationBean startFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.css,*.png,*.ico,druid/*");

        return filterRegistrationBean;
    }

}
