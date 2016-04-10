package com.danielecampogiani.qwertee.data.local.model;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;

public class DayCache extends RealmObject {

    private Date day;
    private RealmList<RealmTShirt> dailyDeals;
    private RealmList<RealmTShirt> all;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
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
