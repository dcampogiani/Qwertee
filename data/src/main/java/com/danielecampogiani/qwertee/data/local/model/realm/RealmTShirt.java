package com.danielecampogiani.qwertee.data.local.model.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmTShirt extends RealmObject {

    private String title;
    private String description;
    @PrimaryKey
    private int id;
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
