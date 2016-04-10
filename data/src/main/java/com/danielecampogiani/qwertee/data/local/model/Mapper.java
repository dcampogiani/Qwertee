package com.danielecampogiani.qwertee.data.local.model;

import com.danielecampogiani.qwertee.presentation.data.TShirt;

public interface Mapper {

    RealmTShirt map(TShirt tShirt);
    TShirt map(RealmTShirt realmTShirt);
}
