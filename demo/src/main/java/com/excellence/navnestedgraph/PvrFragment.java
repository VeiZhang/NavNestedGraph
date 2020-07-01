package com.excellence.navnestedgraph;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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

    private static final String TAG = PvrFragment.class.getSimpleName();

    private NavController mNavController;
    private View mRootView = null;
    private ModuleNavHostFragment mModuleNavHostFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: " + this);
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.pvr_fragment, container, false);

//            mModuleNavHostFragment = new ModuleNavHostFragment();
//            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//            transaction.add(R.id.frame_layout, mModuleNavHostFragment);
//            transaction.commit();
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
//            final NavHostFragment navHostFragment = ModuleNavHostFragment.create(R.navigation.live_nav_graph);

            mModuleNavHostFragment = new ModuleNavHostFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.frame_layout, mModuleNavHostFragment);
            transaction.commit();

            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    NavController subNavController = mModuleNavHostFragment.getNavController();
                    subNavController.setGraph(R.navigation.live_nav_graph);
                    subNavController.navigate(R.id.action_live_info_bar_fragment_to_live_list_fragment);
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

    public void onNestedCreateView() {
        Log.i(TAG, "onNestedCreateView: ");
    }
}
