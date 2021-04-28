package com.fengwenyi.demogoodsservicecore.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
@Configuration
//@EnableDubbo(scanBasePackages = "com.fengwenyi.demogoodsservicecore.dubbo")
@EnableDubbo
public class DubboConfiguration {
}
