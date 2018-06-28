package com.wangn.codegen.core;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.CodeBlock;
import com.wangn.codegen.FieldGen;
import com.wangn.codegen.FieldType;
import com.wangn.codegen.OpType;

import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public class FieldGens {

    public static FieldGen newString(String name, Collection<OpType> opTypes) {
        return new SimpleFieldGen(name, new HashSet<>(opTypes), String.class);
    }

    public static FieldGen newLong(String name, Collection<OpType> opTypes) {
        return new SimpleFieldGen(name, new HashSet<>(opTypes), Long.class);
    }

    public static FieldGen newInt(String name, Collection<OpType> opTypes) {
        return new SimpleFieldGen(name, new HashSet<>(opTypes), Integer.class);
    }

    public static FieldGen newBigDecimal(String name, Collection<OpType> opTypes) {
        return new SimpleFieldGen(name, new HashSet<>(opTypes), BigDecimal.class);
    }

    public static FieldGen newDate(String name, Collection<OpType> opTypes) {
        return new SimpleFieldGen(name, new HashSet<>(opTypes), Date.class);
    }

    public static FieldGen newEnum(String name, Collection<OpType> opTypes, Class<? extends Enum> enumType) {
        return new SimpleFieldGen(name, new HashSet<>(opTypes), enumType){
            @Override
            public FieldType filedType() {
                return FieldType.ENUM_FILED;
            }

            @Override
            protected List<AnnotationSpec> getFiledAnnotationSpecs() {
                List<AnnotationSpec> annotationSpecs = super.getFiledAnnotationSpecs();
                AnnotationSpec enumAnnotation = AnnotationSpec.builder(Enumerated.class)
                        .addMember("value", "EnumType.STRING")
                        .build();
                annotationSpecs.add(0, enumAnnotation);
                return annotationSpecs;
            }
        };
    }
}
