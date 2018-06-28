package com.wangn.codegen;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.springframework.expression.TypedValue;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public class JavaFileGen {

    private List<? extends FieldGen> fieldGens;

    private String entityName;


    public JavaFileGen(String entityName, List<? extends FieldGen> fieldGens) {
        this.entityName = entityName;
        this.fieldGens = fieldGens;
    }

    public JavaFileGen(String entityName) {
        this(entityName,new ArrayList<>());
    }

    public JavaFileGen(String entityName, FieldGen...fieldGens) {
        this(entityName,Arrays.asList(fieldGens));
    }

    public void genTotal(PrintStream printStream) {
        Map<OpType, TypeSpec.Builder> typeBuilderMap = Stream.of(OpType.values())
                .collect(Collectors.toMap(
                        o -> o,
                        o -> TypeSpec.classBuilder(o.javaName(this.entityName))));
        fieldGens.forEach(fieldGen -> {
            typeBuilderMap.entrySet().forEach(entry -> {
                switch (entry.getKey()) {
                    case ADD:
                        fieldGen.onAdd(entry.getValue());
                        break;
                    case SHOWN:
                        fieldGen.onDto(entry.getValue());
                        break;
                    case CONDITION:
                        fieldGen.onQo(entry.getValue());
                        break;
                    case MODIFY:
                        fieldGen.onModify(entry.getValue());
                        break;
                    case BIZ:
                        fieldGen.onDomain(entry.getValue());
                        default:
                }
            });
        });
        typeBuilderMap.values().forEach(typeBuilder -> {
            JavaFile javaFile = JavaFile.builder("com.example", typeBuilder.build()).build();
            try {
                javaFile.writeTo(printStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
