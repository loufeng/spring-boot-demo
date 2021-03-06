package com.lou.controller;

import com.lou.exception.WebException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author loufeng
 * @date 2018/9/6 下午3:28
 */
@Api("demo controller")
@RestController
public class DemoController {
    @ApiOperation("demo")
    @GetMapping("/api/demo")
    public String demo() {
        return "Hello demo";
    }

    @GetMapping("/api/test/webException")
    public void testWeb() throws WebException {
        throw new WebException("测试错误");
    }

    @GetMapping("/api/test/exception")
    public void testException() throws Exception {
        throw new Exception("测试错误");
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        // 目的是
        return args -> {
            System.out.println("SpringBoot 默认提供的 Bean：");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            Arrays.stream(beanNames).forEach(System.out::println);
        };
    }
}
