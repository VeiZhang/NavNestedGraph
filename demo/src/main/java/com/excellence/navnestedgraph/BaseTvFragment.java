package com.excellence.navnestedgraph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2019/10/12
 *     desc   : 主要是用于处理TV端焦点恢复，用于子Fragment（父NavHostFragment->ModuleFragment）
 * </pre>
 */
public abstract class BaseTvFragment extends BaseFragment
        implements ViewTreeObserver.OnGlobalFocusChangeListener {

    private View mRestoreFocusView;
    protected NavController mNavController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mNavController = NavHostFragment.findNavController(this);

        if (mRestoreFocusView != null) {
            mRestoreFocusView.requestFocus();
        }
        mRootView.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
        return mRootView;
    }

    /**
     * 如果需要监听返回键，则在{@link #onViewCreated}中增加该方法，并且重写{@link #onBackPressed}
     * 表示按返回键的时候，会触发{@link #onBackPressed}
     *
     * @param view
     */
    protected void addBackPressHandler(View view) {
        if (view == null) {
            return;
        }
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        onBackPressed();
                    }
                });
    }

    /**
     * Navigation的返回键也是触发{@link NavController#navigateUp}
     */
    protected void onBackPressed() {
        if (mNavController != null) {
            mNavController.navigateUp();
        }
    }

    @Override
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        mRestoreFocusView = newFocus;
        if (newFocus == null) {
            return;
        }
        View v = mRootView.findViewById(newFocus.getId());
        if (v != null) {
            mRestoreFocusView = newFocus;
        }
    }

    @Override
    public void onDestroyView() {
        mRootView.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        super.onDestroyView();
    }

    /**
     * 父NavHostFragment -> ModuleFragment
     *
     * @return
     */
    public static Fragment requireParentModuleFragment(Fragment f) {
        Fragment parent = f;
        do {
            if (parent instanceof NavHostFragment) {
                break;
            }
            parent = parent.requireParentFragment();
        } while (true);
        return parent.requireParentFragment();
    }

}
