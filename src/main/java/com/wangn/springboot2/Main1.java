package com.wangn.springboot2;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-14
 */
public class Main1 {

    public static void main(String[] args) throws IOException {

        FieldSpec fieldSpec = FieldSpec.builder(String.class, "test", Modifier.PRIVATE)
                .addAnnotation(NotNull.class)
                .build();
        TypeSpec h = TypeSpec.classBuilder("H")
                .addModifiers(Modifier.PUBLIC)
                .addField(fieldSpec)
                .build();
        JavaFile javaFile = JavaFile.builder("", h).build();
        javaFile.writeTo(System.out);
    }
}
