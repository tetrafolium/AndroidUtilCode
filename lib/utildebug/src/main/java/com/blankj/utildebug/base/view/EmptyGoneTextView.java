package com.blankj.utildebug.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;

/**
 * <pre>
 *     author: blankj
 *     blog  : http://blankj.com
 *     time  : 2019/09/03
 *     desc  :
 * </pre>
 */
@SuppressLint("AppCompatCustomView")
public class EmptyGoneTextView extends TextView {

    public EmptyGoneTextView(final Context context) {
        this(context, null);
    }

    public EmptyGoneTextView(final Context context, final @Nullable AttributeSet attrs) {
        super(context, attrs);
        setVisibility(GONE);
    }

    @Override
    protected void onTextChanged(final CharSequence text, final int start, final int lengthBefore, final int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (StringUtils.isEmpty(text)) {
            setVisibility(GONE);
        } else {
            setVisibility(VISIBLE);
        }
    }
}
