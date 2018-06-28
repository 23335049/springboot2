package com.wangn.codegen;

import java.util.Set;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public interface FieldDefine {

    FieldType filedType();
    Set<OpType> opTypeSet();
    String name();

    default boolean hasOp(OpType opType) {
        return opTypeSet().contains(opType);
    }
}
