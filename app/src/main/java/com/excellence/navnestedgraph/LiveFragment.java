package com.excellence.navnestedgraph;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2020/6/28
 *     desc   :
 * </pre> 
 */
public class LiveFragment extends BaseFragment {

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.live_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                mNavController.navigate(R.id.action_live_fragment_to_live_nav_graph);
            }
        }, 2000);
    }
}
