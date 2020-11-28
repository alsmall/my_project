package com.aismall.idea_sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    /*路径*/
    @RequestMapping("/test")
    /*返回的是一个字符串*/
    @ResponseBody
    public String test(){
        return "test my controller";
    }
}
