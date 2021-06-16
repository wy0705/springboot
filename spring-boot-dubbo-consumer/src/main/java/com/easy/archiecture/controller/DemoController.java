package com.easy.archiecture.controller;

import com.easy.archiecture.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @DubboReference(
            version = "1.0.0",
            url = "dubbo://127.0.0.1:1111",
            timeout = 100,
            methods = {
                    @Method(name = "firstTestDubbo", timeout = 300)
            }
    )
    private DemoService demoService;


    @RequestMapping("")
    public String demo() {
        return demoService.firstTestDubbo();
//        return "aaa";
    }
}
