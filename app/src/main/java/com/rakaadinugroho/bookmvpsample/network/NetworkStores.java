package com.rakaadinugroho.bookmvpsample.network;

import com.rakaadinugroho.bookmvpsample.model.Books;
import com.rakaadinugroho.bookmvpsample.model.Item;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Raka Adi Nugroho on 2/17/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface NetworkStores {
    @GET("volumes")
    Observable<Books> getTopBooks(@Query("q") String key);

    @GET("volumes/{id}")
    Observable<Item> getDetailBook(@Path("id") String id);
}
