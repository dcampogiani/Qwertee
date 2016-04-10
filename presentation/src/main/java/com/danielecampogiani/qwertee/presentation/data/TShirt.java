package com.danielecampogiani.qwertee.presentation.data;

public class TShirt {

    private final String title;
    private final String description;
    private final String id;
    private final int price;

    public TShirt(String title, String description, String id, int price) {

        if (title != null)
            this.title = title;
        else
            this.title = "";

        if (description != null)
            this.description = description;
        else
            this.description = "";

        if (id != null)
            this.id = id;
        else
            this.id = "";

        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
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

        if (price != tShirt.price)
            return false;
        if (title != null ? !title.equals(tShirt.title) : tShirt.title != null)
            return false;
        if (description != null ? !description.equals(tShirt.description) : tShirt.description != null)
            return false;
        return id != null ? id.equals(tShirt.id) : tShirt.id == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
