package com.danielecampogiani.qwertee.presentation.datasource;


import com.danielecampogiani.qwertee.presentation.data.TShirt;

import rx.Observable;

public interface DataSource {

    Observable<TShirt[]> getDailyDeals();

    Observable<TShirt[]> getAll();

    Observable<TShirt> get(long id);
}
