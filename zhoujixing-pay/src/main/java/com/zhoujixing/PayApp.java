package com.zhoujixing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ServletComponentScan
public class PayApp extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(PayApp.class,args);
    }


    /**
     * 这个方法主要是让springboot在Tomcat134679825133753126
     * 中启动
     * @param builder
     *
     *
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PayApp.class);
    }
}
