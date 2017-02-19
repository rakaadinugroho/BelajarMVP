package com.rakaadinugroho.bookmvpsample.feature.detailbook;

import com.rakaadinugroho.bookmvpsample.model.Item;

/**
 * Created by Raka Adi Nugroho on 2/19/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface DetailView {
    void showLoading();
    void hideLoading();
    void getDataSuccess(Item item);
    void getDataFail(String message);
    void refreshData();
}
