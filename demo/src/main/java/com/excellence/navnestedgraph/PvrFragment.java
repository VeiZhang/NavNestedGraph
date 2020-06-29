package com.excellence.navnestedgraph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2020/6/29
 *     desc   :
 * </pre> 
 */
public class PvrFragment extends Fragment {

    private NavController mNavController;
    private NavController mSubNavController;
    private View mRootView = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.pvr_fragment, container, false);
        }
//        mRootView = inflater.inflate(R.layout.pvr_fragment, container, false);
        return mRootView;
    }

    private boolean isInit = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (!isInit) {
            mNavController = Navigation.findNavController(view);
            mSubNavController = Navigation.findNavController(view.findViewById(R.id.nav_host_fragment));
            mSubNavController.setGraph(R.navigation.live_nav_graph);
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSubNavController.navigate(R.id.action_live_info_bar_fragment_to_live_list_fragment);
                }
            }, 2000);

            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mNavController.navigate(R.id.action_global_vod_fragment);
                }
            }, 5000);
        }
        isInit = true;
    }

}
