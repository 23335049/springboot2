package com.wangn.codegen.core;

import com.squareup.javapoet.TypeSpec;
import com.wangn.codegen.FieldDefine;
import com.wangn.codegen.FieldGen;
import com.wangn.codegen.OpType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public abstract class AbstractFieldGen implements FieldDefine, FieldGen {

    private String name;

    private Set<OpType> opTypes;

    public AbstractFieldGen(String name, Set<OpType> opTypes) {
        this.name = name;
        this.opTypes = opTypes;
    }

    public AbstractFieldGen(String name, OpType...opTypes) {
        this(name, new HashSet<>(Arrays.asList(opTypes)));
    }

    @Override
    public Set<OpType> opTypeSet() {
        return this.opTypes;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public void onAdd(TypeSpec.Builder typeBuilder) {
        if(hasOp(OpType.ADD)) genAdd(typeBuilder);
    }

    @Override
    public void onModify(TypeSpec.Builder typeBuilder) {
        if(hasOp(OpType.MODIFY)) genModify(typeBuilder);
    }

    protected abstract void genModify(TypeSpec.Builder typeBuilder);

    @Override
    public void onDto(TypeSpec.Builder typeBuilder) {
        if(hasOp(OpType.SHOWN)) genDto(typeBuilder);
    }

    protected abstract void genDto(TypeSpec.Builder typeBuilder);

    @Override
    public void onQo(TypeSpec.Builder typeBuilder) {
        if(hasOp(OpType.CONDITION)) genQo(typeBuilder);
    }

    protected abstract void genQo(TypeSpec.Builder typeBuilder);

    protected abstract void genAdd(TypeSpec.Builder typeBuilder);

    @Override
    public void onDomain(TypeSpec.Builder typeBuilder) {
        genDomain(typeBuilder);
    }

    protected abstract void genDomain(TypeSpec.Builder typeBuilder);

}
