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
public class LiveFragment extends Fragment {

    private static final String TAG = LiveFragment.class.getSimpleName();

    private NavController mNavController;
    private NavController mSubNavController;
    private View mRootView = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            // TODO: 2020/6/29 这里不能用旧的，因为退出的时候，界面没有显示，用新的则可以显示出来
            mRootView = inflater.inflate(R.layout.live_fragment, container, false);
        }
//        mRootView = inflater.inflate(R.layout.live_fragment, container, false);
        return mRootView;
    }

    private boolean isInit = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i(TAG, "module onViewCreated: " + this);

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

    @Override
    public void onDestroyView() {
        /**
         * 当A->B后，但B快速回退到A时，A执行onDestroyView与onCreateView间隔时间过短，
         * onDestroyView还没来得及将{@link mRootView}移除，从而导致onCreateView抛出异常
         */
        if (mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        }
        //        ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        super.onDestroyView();
    }
}
