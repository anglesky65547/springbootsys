package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid监控配置
 */
@Configuration
public class MyDruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource getDataSource(){
        return new DruidDataSource();
    }

    /**
     * 配置Druid监控，实习步骤
     * 1.配置一个Servlet：管理后台
     * 2.配置一个Filter：排除哪些不需要的监控请求
     */

    @Bean
    public ServletRegistrationBean statViewServlet(){
        //创建注册Servlet的bean对象
        ServletRegistrationBean servletBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置初始化参数
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        servletBean.setInitParameters(initParams);
        return servletBean;
    }

    /**
     * 配置过滤器
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        //设置相关参数
        filterBean.setFilter(new WebStatFilter());
        //设置url映射
        filterBean.setUrlPatterns(Arrays.asList("/*"));
        //添加初始化参数
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        filterBean.setInitParameters(initParams);
        return filterBean;
    }


}
