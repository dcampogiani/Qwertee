package com.danielecampogiani.qwertee.data.network.retrofit;

import com.danielecampogiani.qwertee.data.network.rawresponses.Page;
import com.danielecampogiani.qwertee.data.network.rawresponses.Rss;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

public interface RetrofitQwertee {

    @GET("rss")
    Observable<Response<Rss>> getDailyDeals();

    @GET("shop/all")
    Observable<Response<Page>> getAll();

}
