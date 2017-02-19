package com.rakaadinugroho.bookmvpsample.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.rakaadinugroho.bookmvpsample.base.ui.BaseFragment;
import com.rakaadinugroho.bookmvpsample.base.ui.BasePresenter;

/**
 * Created by Raka Adi Nugroho on 2/17/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P presenter;
    protected abstract P createPresenter();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter   = createPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.dettachView();
        }
    }
}
