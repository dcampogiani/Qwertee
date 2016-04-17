package com.danielecampogiani.qwertee.data.local.model.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RealmDayCache extends RealmObject {

    private RealmSimpleDay day;
    private RealmList<RealmTShirt> dailyDeals;
    private RealmList<RealmTShirt> all;

    public RealmSimpleDay getDay() {
        return day;
    }

    public void setDay(RealmSimpleDay day) {
        this.day = day;
    }

    public RealmList<RealmTShirt> getDailyDeals() {
        return dailyDeals;
    }

    public void setDailyDeals(RealmList<RealmTShirt> dailyDeals) {
        this.dailyDeals = dailyDeals;
    }

    public RealmList<RealmTShirt> getAll() {
        return all;
    }

    public void setAll(RealmList<RealmTShirt> all) {
        this.all = all;
    }
}
