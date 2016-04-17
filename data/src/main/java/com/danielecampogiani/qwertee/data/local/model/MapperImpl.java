package com.danielecampogiani.qwertee.data.local.model;

import com.danielecampogiani.qwertee.data.local.model.realm.RealmDayCache;
import com.danielecampogiani.qwertee.data.local.model.realm.RealmSimpleDay;
import com.danielecampogiani.qwertee.data.local.model.realm.RealmTShirt;
import com.danielecampogiani.qwertee.presentation.data.TShirt;

import io.realm.RealmList;

public class MapperImpl implements Mapper {

    @Override
    public RealmTShirt map(TShirt tShirt) {
        RealmTShirt result = new RealmTShirt();
        result.setTitle(tShirt.getTitle());
        result.setDescription(tShirt.getDescription());
        result.setId(tShirt.getId());
        result.setPrice(tShirt.getPrice());
        return result;
    }

    @Override
    public TShirt map(RealmTShirt realmTShirt) {
        return new TShirt(realmTShirt.getTitle(), realmTShirt.getDescription(), realmTShirt.getId(), realmTShirt.getPrice());
    }

    @Override
    public RealmSimpleDay map(SimpleDay day) {
        RealmSimpleDay result = new RealmSimpleDay();
        result.setDay(day.getDay());
        result.setMonth(day.getMonth());
        result.setYear(day.getYear());
        return result;
    }

    @Override
    public SimpleDay map(RealmSimpleDay day) {
        return new SimpleDay(day.getDay(), day.getMonth(), day.getYear());
    }

    @Override
    public RealmDayCache map(SimpleDay day, TShirt[] dailyDeals, TShirt[] all) {

        RealmDayCache result = new RealmDayCache();
        result.setDay(map(day));

        int dailyDealsSize = dailyDeals.length;
        RealmList<RealmTShirt> dailyDealsRealm = new RealmList<>();
        for (int i = 0; i < dailyDealsSize; i++) {
            RealmTShirt realmTShirt = map(dailyDeals[i]);
            dailyDealsRealm.add(realmTShirt);
        }

        result.setDailyDeals(dailyDealsRealm);

        int allSize = all.length;
        RealmList<RealmTShirt> allRealm = new RealmList<>();
        for (int i = 0; i < allSize; i++) {
            RealmTShirt realmTShirt = map(all[i]);
            allRealm.add(realmTShirt);
        }

        result.setAll(allRealm);

        return result;
    }

    @Override
    public TShirt[] map(RealmList<RealmTShirt> tShirts) {

        int size = tShirts.size();
        TShirt[] result = new TShirt[size];

        for (int i = 0; i < size; i++) {
            TShirt tShirt = map(tShirts.get(i));
            result[i] = tShirt;
        }

        return result;
    }
}
