package com.danielecampogiani.qwertee.data.network;

import com.danielecampogiani.qwertee.data.network.rawresponses.Mapper;
import com.danielecampogiani.qwertee.data.network.rawresponses.Page;
import com.danielecampogiani.qwertee.data.network.rawresponses.Rss;
import com.danielecampogiani.qwertee.data.network.retrofit.RetrofitQwertee;
import com.danielecampogiani.qwertee.presentation.data.TShirt;
import com.danielecampogiani.qwertee.presentation.datasource.DataSource;

import retrofit2.Response;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

public class NetworkDataSource implements DataSource {

    private final Mapper mapper;
    private final RetrofitQwertee retrofitQwertee;

    private TShirt[] dailyDeals;
    private TShirt[] all;

    public NetworkDataSource(RetrofitQwertee retrofitQwertee, Mapper mapper) {
        this.retrofitQwertee = retrofitQwertee;
        this.mapper = mapper;
    }

    @Override
    public Observable<TShirt[]> getDailyDeals() {
        if (dailyDeals != null) {
            return Observable.just(dailyDeals);
        } else {
            return retrofitQwertee.getDailyDeals()
                    .map(new FromRssToArrayAction(mapper))
                    .doOnNext(new Action1<TShirt[]>() {
                        @Override
                        public void call(TShirt[] tShirts) {
                            NetworkDataSource.this.dailyDeals = tShirts;
                        }
                    });
        }
    }

    @Override
    public Observable<TShirt[]> getAll() {
        if (all != null) {
            return Observable.just(all);
        } else return retrofitQwertee.getAll()
                .map(new FromPageToArrayAction())
                .doOnNext(new Action1<TShirt[]>() {
                    @Override
                    public void call(TShirt[] tShirts) {
                        NetworkDataSource.this.all = tShirts;
                    }
                });
    }

    @Override
    public Observable<TShirt> get(final long id) {
        return Observable.fromCallable(new GetFromIdAction(id, dailyDeals, all));
    }

    private static final class FromRssToArrayAction implements Func1<Response<Rss>, TShirt[]> {

        private final Mapper mapper;

        private FromRssToArrayAction(Mapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public TShirt[] call(Response<Rss> rssResponse) {
            if (rssResponse.isSuccessful()) {
                return mapper.map(rssResponse.body());
            } else {
                return new TShirt[0];
            }
        }
    }

    private static final class FromPageToArrayAction implements Func1<Response<Page>, TShirt[]> {

        @Override
        public TShirt[] call(Response<Page> pageResponse) {
            if (pageResponse.isSuccessful()) {
                return pageResponse.body().gettShirts();
            } else {
                return new TShirt[0];
            }
        }
    }

    private static class GetFromIdAction implements Func0<TShirt> {

        private final long id;
        private final TShirt[] dailyDeals;
        private final TShirt[] all;

        public GetFromIdAction(long id, TShirt[] dailyDeals, TShirt[] all) {
            this.id = id;
            if (dailyDeals != null) {
                this.dailyDeals = dailyDeals;
            } else
                this.dailyDeals = new TShirt[0];

            if (all != null) {
                this.all = all;
            } else
                this.all = new TShirt[0];
        }

        @Override
        public TShirt call() {
            int dailyDealsSize = dailyDeals.length;
            for (int i = 0; i < dailyDealsSize; i++) {
                if (dailyDeals[i].getId() == id) {
                    return dailyDeals[i];
                }
            }
            int allSize = all.length;
            for (int i = 0; i < allSize; i++) {
                if (all[i].getId() == id) {
                    return all[i];
                }
            }
            throw new IllegalArgumentException("Can't find a TShirt with id: " + id);
        }
    }
}
