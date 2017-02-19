package com.rakaadinugroho.bookmvpsample.base.mvp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.rakaadinugroho.bookmvpsample.base.ui.BaseActivity;
import com.rakaadinugroho.bookmvpsample.base.ui.BasePresenter;

/**
 * Created by Raka Adi Nugroho on 2/17/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P presenter;
    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.dettachView();
        }
    }
}
