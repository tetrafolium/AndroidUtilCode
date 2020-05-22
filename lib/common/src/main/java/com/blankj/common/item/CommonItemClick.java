package com.blankj.common.item;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

import com.blankj.base.rv.ItemViewHolder;
import com.blankj.common.R;
import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

/**
 * <pre>
 *     author: blankj
 *     blog  : http://blankj.com
 *     time  : 2019/10/31
 *     desc  :
 * </pre>
 */
public class CommonItemClick extends CommonItem<CommonItemClick> {

    private CharSequence mTitle;
    private CharSequence mContent;
    private boolean      mIsJump;

    public CommonItemClick(final @StringRes int title) {
        this(StringUtils.getString(title), "", false, null);
    }

    public CommonItemClick(final @NonNull CharSequence title) {
        this(title, "", false, null);
    }

    public CommonItemClick(final @StringRes int title, final boolean isJump) {
        this(StringUtils.getString(title), "", isJump);
    }

    public CommonItemClick(final @NonNull CharSequence title, final boolean isJump) {
        this(title, "", isJump, null);
    }

    public CommonItemClick(final @StringRes int title, final CharSequence content) {
        this(StringUtils.getString(title), content, false, null);
    }

    public CommonItemClick(final @NonNull CharSequence title, final CharSequence content) {
        this(title, content, false, null);
    }

    public CommonItemClick(final @StringRes int title, final CharSequence content, final boolean isJump) {
        this(StringUtils.getString(title), content, isJump);
    }

    public CommonItemClick(final @NonNull CharSequence title, final CharSequence content, final boolean isJump) {
        this(title, content, isJump, null);
    }

    public CommonItemClick(final @StringRes int title, final Runnable simpleClickListener) {
        this(StringUtils.getString(title), "", false, simpleClickListener);
    }

    public CommonItemClick(final @NonNull CharSequence title, final Runnable simpleClickListener) {
        this(title, "", false, simpleClickListener);
    }

    public CommonItemClick(final @StringRes int title, final boolean isJump, final Runnable simpleClickListener) {
        this(StringUtils.getString(title), "", isJump, simpleClickListener);
    }

    public CommonItemClick(final @NonNull CharSequence title, final boolean isJump, final Runnable simpleClickListener) {
        this(title, "", isJump, simpleClickListener);
    }

    public CommonItemClick(final @StringRes int title, final CharSequence content, final Runnable simpleClickListener) {
        this(StringUtils.getString(title), content, false, simpleClickListener);
    }

    public CommonItemClick(final @NonNull CharSequence title, final CharSequence content, final Runnable simpleClickListener) {
        this(title, content, false, simpleClickListener);
    }

    public CommonItemClick(final @StringRes int title, final CharSequence content, final boolean isJump, final Runnable simpleClickListener) {
        this(StringUtils.getString(title), content, isJump, simpleClickListener);
    }

    public CommonItemClick(final @NonNull CharSequence title, final CharSequence content, final boolean isJump, final Runnable simpleClickListener) {
        super(R.layout.common_item_title_click);
        mTitle = title;
        mContent = content;
        mIsJump = isJump;
        if (simpleClickListener == null) return;
        setOnItemClickListener(new OnItemClickListener<CommonItemClick>() {
            @Override
            public void onItemClick(final ItemViewHolder holder, final CommonItemClick item, final int position) {
                if (simpleClickListener != null) {
                    simpleClickListener.run();
                }
            }
        });
    }

    public CommonItemClick setOnClickUpdateContentListener(@NonNull final Utils.Supplier<CharSequence> supplier) {
        setOnItemClickListener(new OnItemClickListener<CommonItemClick>() {
            @Override
            public void onItemClick(final ItemViewHolder holder, final CommonItemClick item, final int position) {
                item.mContent = supplier.get();
                update();
            }
        });
        return this;
    }

    @Override
    public void bind(final @NonNull ItemViewHolder holder, final int position) {
        super.bind(holder, position);
        final TextView titleTv = holder.findViewById(R.id.commonItemTitleTv);
        final TextView contentTv = holder.findViewById(R.id.commonItemContentTv);

        titleTv.setText(mTitle);
        contentTv.setText(mContent);

        ClickUtils.applyPressedBgDark(holder.itemView);
        holder.findViewById(R.id.commonItemGoIv).setVisibility(mIsJump ? View.VISIBLE : View.GONE);
    }

    public void setTitle(final CharSequence title) {
        mTitle = title;
        update();
    }

    public CharSequence getTitle() {
        return mTitle;
    }
}
