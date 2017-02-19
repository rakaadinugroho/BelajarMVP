package com.rakaadinugroho.bookmvpsample.feature.home;

import android.content.Intent;

import com.rakaadinugroho.bookmvpsample.model.Books;

/**
 * Created by Raka Adi Nugroho on 2/18/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

interface MainView {
    void showLoading();
    void hideLoading();
    void getDataSuccess(Books model);
    void getDataFail(String message);
    void moveToDetail(Intent intent);
}
