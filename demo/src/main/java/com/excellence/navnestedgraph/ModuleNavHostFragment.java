package com.excellence.navnestedgraph;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2020/6/29
 *     desc   :
 * </pre> 
 */
public class ModuleNavHostFragment extends NavHostFragment {

    private static final String TAG = ModuleNavHostFragment.class.getSimpleName();

    private View mRootView = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "nav host onCreateView: " + this);
        if (mRootView == null) {
            mRootView = super.onCreateView(inflater, container, savedInstanceState);
        }

        requireFragmentManager().beginTransaction()
                .setPrimaryNavigationFragment(this)
                .commit();

        if (requireParentFragment() instanceof PvrFragment) {
            ((PvrFragment) requireParentFragment()).onNestedCreateView();
        }
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG, "onDestroyView: " + this);
        ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        super.onDestroyView();
    }
}
