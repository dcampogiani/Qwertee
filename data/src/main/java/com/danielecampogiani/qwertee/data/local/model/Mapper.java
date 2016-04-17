package com.danielecampogiani.qwertee.data.local.model;

import com.danielecampogiani.qwertee.data.local.model.realm.RealmDayCache;
import com.danielecampogiani.qwertee.data.local.model.realm.RealmSimpleDay;
import com.danielecampogiani.qwertee.data.local.model.realm.RealmTShirt;
import com.danielecampogiani.qwertee.presentation.data.TShirt;

import io.realm.RealmList;

public interface Mapper {

    RealmTShirt map(TShirt tShirt);

    TShirt map(RealmTShirt realmTShirt);

    RealmSimpleDay map(SimpleDay day);

    SimpleDay map(RealmSimpleDay day);

    RealmDayCache map(SimpleDay day, TShirt[] dailyDeals, TShirt[] all);

    TShirt[] map(RealmList<RealmTShirt> tShirts);
}
