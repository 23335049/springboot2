package com.wangn.codegen;

import java.util.Objects;

/**
 * class functional description
 *
 * @author wang.xiongfei
 * @version 1.0.0
 * @since 2018-06-27
 */
public enum  OpType {

    CONDITION(null, "Qo"),
    SHOWN(null, "Dto"),
    ADD("Add", "ShellCmd"),
    MODIFY("Modify","ShellCmd"),
    BIZ("", "Biz")
    ;

    private String prefix;

    private String suffix;

    OpType(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String javaName(String entityName) {
        return Objects.toString(getPrefix(), "")
                + Utils.upperFirstChar(entityName) + Objects.toString(getSuffix(), "");
    }
}