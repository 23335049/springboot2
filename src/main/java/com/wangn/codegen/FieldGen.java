package com.wangn.codegen;

import com.squareup.javapoet.TypeSpec;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public interface FieldGen {

    void onDomain(TypeSpec.Builder typeBuilder);

    void onAdd(TypeSpec.Builder typeBuilder);

    void onQo(TypeSpec.Builder typeBuilder);

    void onDto(TypeSpec.Builder typeBuilder);

    void onModify(TypeSpec.Builder typeBuilder);

}
