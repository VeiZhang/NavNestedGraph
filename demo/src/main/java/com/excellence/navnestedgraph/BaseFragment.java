package com.excellence.navnestedgraph;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2020/6/7
 *     desc   :
 * </pre> 
 */
public abstract class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected Context mContext = null;

    protected View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getContentViewLayoutId(), container, false);
            init();
        }
        Log.i(TAG, "onCreateView: " + this);
        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        onSupportVisible();
    }

    @Override
    public void onStop() {
        super.onStop();
        onSupportInvisible();
    }

    protected void onSupportVisible() {

    }

    protected void onSupportInvisible() {

    }

    @Override
    public void onDestroyView() {
        /**
         * 当A->B后，但B快速回退到A时，A执行onDestroyView与onCreateView间隔时间过短，
         * onDestroyView还没来得及将{@link mRootView}移除，从而导致onCreateView抛出异常
         */
        ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        super.onDestroyView();
    }

    public void post(Runnable runnable) {
        mRootView.post(runnable);
    }

    public void postDelayed(Runnable runnable, long delayMillis) {
        mRootView.postDelayed(runnable, delayMillis);
    }

    /**
     * get content view id
     *
     * @return
     */
    @LayoutRes
    protected abstract int getContentViewLayoutId();

    /**
     * create -> init -> visible
     * <p>
     * init data and view once
     */
    protected void init() {

    }
}
