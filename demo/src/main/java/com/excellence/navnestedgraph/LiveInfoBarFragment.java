package com.excellence.navnestedgraph;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2020/6/28
 *     desc   :
 * </pre> 
 */
public class LiveInfoBarFragment extends BaseTvFragment {

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.live_info_bar_fragment;
    }

    private int i = 0;

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
        i++;
        if (i % 2 == 0) {
            Navigation.findNavController(v).navigate(R.id.action_live_info_bar_fragment_to_live_list_fragment);
        } else {
            Navigation.findNavController(v).navigate(R.id.action_live_info_bar_fragment_to_epg_fragment);
        }
    }
}
