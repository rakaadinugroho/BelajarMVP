package com.rakaadinugroho.bookmvpsample.feature.home;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.rakaadinugroho.bookmvpsample.base.ui.BasePresenter;
import com.rakaadinugroho.bookmvpsample.feature.detailbook.DetailActivity;
import com.rakaadinugroho.bookmvpsample.model.Books;
import com.rakaadinugroho.bookmvpsample.model.Item;
import com.rakaadinugroho.bookmvpsample.network.NetworkCallback;

/**
 * Created by Raka Adi Nugroho on 2/18/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView view) {
        super.attachView(view);
    }
    void loadData(String key) {
        view.showLoading();
        addSubscribe(apiStores.getTopBooks(key), new NetworkCallback<Books>() {
            @Override
            public void onSuccess(Books model) {
                view.getDataSuccess(model);
            }

            @Override
            public void onFailure(String message) {
                view.getDataFail(message);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        });
    }
    void getItem(Item item, Activity activity){
        Intent intent   = new Intent(activity, DetailActivity.class);
        intent.putExtra("id", item.getId());
        view.moveToDetail(intent);
    }
}
