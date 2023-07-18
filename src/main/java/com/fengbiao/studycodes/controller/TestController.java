package com.fengbiao.studycodes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("test")
@Api(tags = "测试模块")
public class TestController {

    @GetMapping("test1")
    @ApiOperation("测试方法1")
    public String test1() {
        return "test1";
    }
}
