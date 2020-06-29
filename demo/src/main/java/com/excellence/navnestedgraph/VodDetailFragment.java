package com.excellence.navnestedgraph;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2020/6/28
 *     desc   :
 * </pre> 
 */
public class VodDetailFragment extends BaseFragment {

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.vod_detail_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(v);
            }
        });
    }
    
    public void intent(View v) {
        NavHostFragment.findNavController(this).navigate(R.id.action_vod_detail_fragment_to_vod_info_bar_fragment);
    }
}
