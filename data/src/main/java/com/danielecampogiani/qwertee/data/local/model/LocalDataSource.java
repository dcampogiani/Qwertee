package com.danielecampogiani.qwertee.data.local.model;

import com.danielecampogiani.qwertee.presentation.data.TShirt;
import com.danielecampogiani.qwertee.presentation.datasource.WritableDataSource;

import rx.Observable;

public class LocalDataSource implements WritableDataSource {

    @Override
    public void writeDailyDeals(TShirt[] toBeSaved) {

    }

    @Override
    public void writeAll(TShirt[] toBeSaved) {

    }

    @Override
    public Observable<TShirt[]> getDailyDeals() {
        return null;
    }

    @Override
    public Observable<TShirt[]> getAll() {
        return null;
    }

    @Override
    public Observable<TShirt> get(long id) {
        return null;
    }
}
