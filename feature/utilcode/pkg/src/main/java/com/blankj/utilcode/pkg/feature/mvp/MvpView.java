package com.blankj.utilcode.pkg.feature.mvp;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.blankj.base.mvp.BaseView;
import com.blankj.utilcode.pkg.R;
import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.ToastUtils;

/**
 * <pre>
 *     author: blankj
 *     blog  : http://blankj.com
 *     time  : 2019/11/26
 *     desc  :
 * </pre>
 */
public class MvpView extends BaseView<MvpView>
        implements IMvp.View {

    private TextView mvpTv;

    public MvpView(final FragmentActivity activity) {
        super(activity);
        mvpTv = activity.findViewById(R.id.mvpUpdateTv);
        ClickUtils.applyPressedBgDark(mvpTv);
        mvpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                getPresenter(MvpPresenter.class).updateMsg();
            }
        });
    }

    @Override
    public void setLoadingVisible(final boolean visible) {
        final MvpActivity activity = getActivity();
        if (visible) {
            activity.showLoading(new Runnable() {
                @Override
                public void run() {
                    activity.finish();
                }
            });
        } else {
            activity.dismissLoading();
        }
    }

    @Override
    public void showMsg(final CharSequence msg) {
        ToastUtils.showLong(msg);
    }

    @Override
    public void onDestroyView() {

    }
}
