package com.rakaadinugroho.bookmvpsample.feature.detailbook;

import com.rakaadinugroho.bookmvpsample.base.ui.BasePresenter;
import com.rakaadinugroho.bookmvpsample.model.Item;
import com.rakaadinugroho.bookmvpsample.network.NetworkCallback;

/**
 * Created by Raka Adi Nugroho on 2/19/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class DetailPresenter extends BasePresenter<DetailView> {
    public DetailPresenter(DetailView view) {
        super.attachView(view);
    }
    void loadData(String id){
        view.showLoading();
        addSubscribe(apiStores.getDetailBook(id), new NetworkCallback<Item>() {
            @Override
            public void onSuccess(Item model) {
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
}
