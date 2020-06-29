package com.excellence.navnestedgraph;

import android.os.Bundle;
import android.util.Log;
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
 *     time   : 2020/6/28
 *     desc   :
 * </pre> 
 */
public class VodFragment extends Fragment {

    private static final String TAG = VodFragment.class.getSimpleName();

    private NavController mNavController;
    private NavController mSubNavController;
    private View mRootView = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        if (mRootView == null) {
        // TODO: 2020/6/29 这里不能用旧的，因为退出的时候，界面没有显示，用新的则可以显示出来
//            mRootView = inflater.inflate(R.layout.vod_fragment, container, false);
//        }
        mRootView = inflater.inflate(R.layout.vod_fragment, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i(TAG, "module onViewCreated: " + this);
        mNavController = Navigation.findNavController(view);
        mSubNavController = Navigation.findNavController(view.findViewById(R.id.nav_host_fragment));
        mSubNavController.setGraph(R.navigation.vod_nav_graph);
    }
}
