package com.blankj.utilcode.util.reflect;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/01/12
 *     desc  :
 * </pre>
 */
public class Test3 {

    public Object     n;
    public MethodType methodType;

    public void method() {
        this.n = null;
        this.methodType = MethodType.NO_ARGS;
    }

    public void method(final Integer n1) {
        this.n = n1;
        this.methodType = MethodType.INTEGER;
    }

    public void method(final Number n1) {
        this.n = n1;
        this.methodType = MethodType.NUMBER;
    }

    public void method(final Object n1) {
        this.n = n1;
        this.methodType = MethodType.OBJECT;
    }

    public static enum MethodType {
        NO_ARGS,
        INTEGER,
        NUMBER,
        OBJECT
    }
}
