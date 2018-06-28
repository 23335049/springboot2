package com.wangn.codegen.test;

import com.wangn.codegen.JavaFileGen;
import com.wangn.codegen.OpType;
import org.junit.Test;

import java.util.Arrays;

import static com.wangn.codegen.core.FieldGens.*;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public class Test1 {

    @Test
    public void testGen() {
        JavaFileGen javaFileGen = new JavaFileGen("user",
                Arrays.asList(
                newString("id", Arrays.asList(OpType.ADD, OpType.CONDITION, OpType.SHOWN)),
                newString("age", Arrays.asList(OpType.ADD, OpType.CONDITION, OpType.SHOWN, OpType.MODIFY)),
                newString("salary", Arrays.asList(OpType.ADD, OpType.CONDITION, OpType.SHOWN, OpType.MODIFY)),
                newEnum("name", Arrays.asList(OpType.ADD, OpType.CONDITION, OpType.SHOWN, OpType.MODIFY), OpType.class))
        );
        javaFileGen.genTotal(System.out);
    }
}
