package com.rakaadinugroho.bookmvpsample.base.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Raka Adi Nugroho on 2/17/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class BaseFragment extends Fragment {
    public Activity activity;
    private CompositeSubscription compositeSubscription;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity    = getActivity();
        ButterKnife.bind(activity, view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onUnsubscribe();
    }

    private void onUnsubscribe() {
        if (compositeSubscription != null){
            compositeSubscription.unsubscribe();
        }
    }
}
