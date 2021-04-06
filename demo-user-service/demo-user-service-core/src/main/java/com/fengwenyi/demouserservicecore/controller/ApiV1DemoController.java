package com.fengwenyi.demouserservicecore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-06
 */
@RestController
@RefreshScope
@RequestMapping("/api/v1/demo")
public class ApiV1DemoController {

    @Value("${author.name: test}")
    private String authorName;

    @GetMapping("/authorName")
    public String getAuthorName() {
        return authorName;
    }

}
