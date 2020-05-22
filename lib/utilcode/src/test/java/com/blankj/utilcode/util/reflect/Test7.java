package com.blankj.utilcode.util.reflect;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/01/12
 *     desc  :
 * </pre>
 */
public class Test7 {

    public final String  s;
    public final Integer i;

    private Test7(final int i) {
        this(null, i);
    }

    private Test7(final String s) {
        this(s, null);
    }

    private Test7(final String s, final int i) {
        this(s, (Integer) i);
    }

    private Test7(final String s, final Integer i) {
        this.s = s;
        this.i = i;
    }
}
