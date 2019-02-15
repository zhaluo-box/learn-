package com.zlb.springboot_jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.zlb.springboot_jpa.dao")  // 接收的参数 用来扫描数据访问层接口
public class MyJpaConfig {

}
