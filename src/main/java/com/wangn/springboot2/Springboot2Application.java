package com.wangn.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Springboot2Application {


    @Autowired
    private SimpleComponent simpleComponent;

    @Autowired
    private SimpleComponent2 simpleComponent2;

    static ConfigurableApplicationContext applicationContext;

    static Thread startThread;

    @RequestMapping("/")
    String home() {
        return "Hello World3!" + hh2() + simple() + simpleComponent2.test();
    }

    private String hh() {
        return "niam1a";
    }


    private String hh2() {
        return "niam1a2";
    }

    @RequestMapping("hi")
    public String hi() {
        int i = 1;
        return "hi";
    }

    @RequestMapping("si")
    public String simple() {
        return "seom culatr";
    }

    @RequestMapping("/ye")
    String home1() {
        return "hahha";
    }
    public static void main(String[] args) {
        startThread = Thread.currentThread();
        applicationContext = SpringApplication.run(Springboot2Application.class, args);
        System.out.println("ok");
    }
}
