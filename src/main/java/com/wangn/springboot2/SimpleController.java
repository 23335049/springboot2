package com.wangn.springboot2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-07
 */
@Controller
@RestController
public class SimpleController {

    @RequestMapping("get")
    public String get() {
        return "get 1";
    }
}
