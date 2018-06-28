package com.wangn.springboot2;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-07
 */
@Component
public class SimpleComponent {

    public String test() {
        return "test1";
    }

    @Bean
    public ClassA newInstanceA(SimpleComponent simpleComponent) {
        assert Objects.nonNull(simpleComponent);
        assert simpleComponent == this;
        return new ClassA();
    }
}
class ClassA {

}
