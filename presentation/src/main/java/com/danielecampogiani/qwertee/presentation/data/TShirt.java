package com.danielecampogiani.qwertee.presentation.data;

public class TShirt {

    private final String title;
    private final String description;
    private final int id;
    private final int price;

    public TShirt(String title, String description, int id, int price) {

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be >0");
        }
        this.price = price;
        this.id = id;

        if (title != null)
            this.title = title;
        else
            this.title = "";

        if (description != null)
            this.description = description;
        else
            this.description = "";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TShirt tShirt = (TShirt) o;

        return id == tShirt.id && price == tShirt.price && (title.equals(tShirt.title));

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (description.hashCode());
        result = 31 * result + id;
        result = 31 * result + price;
        return result;
    }
}
