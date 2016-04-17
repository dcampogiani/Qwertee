package com.danielecampogiani.qwertee.data.local;

import com.danielecampogiani.qwertee.data.local.model.Mapper;
import com.danielecampogiani.qwertee.data.local.model.SimpleDay;
import com.danielecampogiani.qwertee.data.local.model.realm.RealmDayCache;
import com.danielecampogiani.qwertee.presentation.data.TShirt;
import com.danielecampogiani.qwertee.presentation.datasource.WritableDataSource;

import java.util.Calendar;

import io.realm.Realm;
import rx.Observable;

public class LocalDataSource implements WritableDataSource {

    private final Realm realm;
    private final Mapper mapper;

    public LocalDataSource(Realm realm, Mapper mapper) {
        this.realm = realm;
        this.mapper = mapper;
    }

    @Override
    public Observable<TShirt[]> getDailyDeals() {

        realm.where(RealmDayCache.class).findAllAsync().asObservable();

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

    @Override
    public void write(TShirt[] dailyDeals, TShirt[] all) {
        SimpleDay simpleDay = getCurrentSimpleDay();
        final RealmDayCache dayCache = mapper.map(simpleDay, dailyDeals, all);

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealm(dayCache);
            }
        });
    }

    private SimpleDay getCurrentSimpleDay() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR) - 1900;
        return new SimpleDay(day, month, year);
    }
}
