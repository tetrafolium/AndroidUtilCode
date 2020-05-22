package com.blankj.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ClickUtils;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/03/28
 *     desc  : base about v4-fragment
 * </pre>
 */
public abstract class BaseFragment extends Fragment
        implements IBaseView {

    private static Boolean isDebug;

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            onDebouncingClick(v);
        }
    };

    protected AppCompatActivity mActivity;
    protected LayoutInflater    mInflater;
    protected View              mContentView;

    protected boolean mIsVisibleToUser;
    protected boolean mIsBusinessDone;
    protected boolean mIsInPager;

    /**
     * @return true true {@link #doBusiness()} will lazy in view pager, false otherwise
     */
    public boolean isLazy() {
        return false;
    }

    @Override
    public void setUserVisibleHint(final boolean isVisibleToUser) {
        log("setUserVisibleHint: " + isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
        mIsInPager = true;
        if (isVisibleToUser) mIsVisibleToUser = true;
        if (isLazy()) {
            if (!mIsBusinessDone && isVisibleToUser && mContentView != null) {
                mIsBusinessDone = true;
                doBusiness();
            }
        }
    }

    @Override
    public void onAttach(final Context context) {
        log("onAttach");
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(final @Nullable Bundle savedInstanceState) {
        log("onCreate");
        super.onCreate(savedInstanceState);
        FragmentManager fm = getFragmentManager();
        if (fm == null) return;
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = fm.beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commitAllowingStateLoss();
        }
        Bundle bundle = getArguments();
        initData(bundle);
    }

    @Nullable
    @Override
    public View onCreateView(final @NonNull LayoutInflater inflater, final @Nullable ViewGroup container, final @Nullable Bundle savedInstanceState) {
        log("onCreateView");
        super.onCreateView(inflater, container, savedInstanceState);
        mInflater = inflater;
        setContentView();
        return mContentView;
    }

    @Override
    public void setContentView() {
        if (bindLayout() <= 0) return;
        mContentView = mInflater.inflate(bindLayout(), null);
    }

    @Override
    public void onViewCreated(final @NonNull View view, final @Nullable Bundle savedInstanceState) {
        log("onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(final @Nullable Bundle savedInstanceState) {
        log("onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        initView(savedInstanceState, mContentView);
        if (!mIsInPager || !isLazy() || mIsVisibleToUser) {
            mIsBusinessDone = true;
            doBusiness();
        }
    }

    @Override
    public void onHiddenChanged(final boolean hidden) {
        log("onHiddenChanged: " + hidden);
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onDestroyView() {
        log("onDestroyView");
        super.onDestroyView();
        mIsVisibleToUser = false;
        mIsBusinessDone = false;
    }

    @Override
    public void onSaveInstanceState(final @NonNull Bundle outState) {
        log("onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Override
    public void onDestroy() {
        log("onDestroy");
        super.onDestroy();
    }

    public void applyDebouncingClickListener(final View... views) {
        ClickUtils.applyGlobalDebouncing(views, mClickListener);
    }

    public <T extends View> T findViewById(final @IdRes int id) {
        if (mContentView == null) throw new NullPointerException("ContentView is null.");
        return mContentView.findViewById(id);
    }

    protected void log(final String msg) {
        if (isDebug == null) {
            isDebug = AppUtils.isAppDebug();
        }
        if (isDebug) {
            Log.d("BaseFragment", getClass().getSimpleName() + ": " + msg);
        }
    }
}
