package com.wangn.codegen.core;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;
import com.wangn.codegen.FieldType;
import com.wangn.codegen.OpType;
import com.wangn.codegen.Utils;

import javax.lang.model.element.Modifier;
import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public class SimpleFieldGen extends AbstractFieldGen{

    private Class<?> type;

    public SimpleFieldGen(String name, Set<OpType> opTypes, Class<?> type) {
        super(name, opTypes);
        this.type = type;
    }

    @Override
    protected void genModify(TypeSpec.Builder typeBuilder) {
        typeBuilder.addField(getFieldBuilder().build());
    }

    @Override
    protected void genDto(TypeSpec.Builder typeBuilder) {
        genModify(typeBuilder);
    }

    @Override
    protected void genQo(TypeSpec.Builder typeBuilder) {
        genModify(typeBuilder);
    }

    @Override
    protected void genAdd(TypeSpec.Builder typeBuilder) {
        genModify(typeBuilder);
    }
    
    
    @Override
    protected void genDomain(TypeSpec.Builder typeBuilder) {
        typeBuilder.addField(getFieldBuilder().addAnnotations(getFiledAnnotationSpecs()).build());
    }

    protected List<AnnotationSpec> getFiledAnnotationSpecs() {
        AnnotationSpec annotationSpec = AnnotationSpec.builder(Column.class)
                .addMember("name", Utils.surroundWithQuo(Utils.underscoreName(name())))
                .build();
        List<AnnotationSpec> list = new ArrayList<>();
        list.add(annotationSpec);
        return list;
    }

    protected FieldSpec.Builder getFieldBuilder() {
        return FieldSpec.builder(type, name(), Modifier.PRIVATE);
    }

    @Override
    public FieldType filedType() {
        return FieldType.SIMPLE;
    }
}
