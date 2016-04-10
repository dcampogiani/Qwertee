package com.danielecampogiani.qwertee.data.local.model;

import com.danielecampogiani.qwertee.presentation.data.TShirt;

public class MapperImpl implements Mapper{

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
        return new TShirt(realmTShirt.getTitle(),realmTShirt.getDescription(),realmTShirt.getId(),realmTShirt.getPrice());
    }
}
