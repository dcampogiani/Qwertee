package com.danielecampogiani.qwertee.data.network.rawresponses;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Channel {

    @Element(name = "title")
    private String title;

    @Element(name = "description")
    private String description;


    @ElementList(entry = "item", inline = true)
    private List<Item> list;

    @Element(name = "language")
    private String language;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null)
            throw new NullPointerException();
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null)
            throw new NullPointerException();
        this.description = description;
    }


    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        if (list == null)
            throw new NullPointerException();
        this.list = list;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if (language == null)
            throw new NullPointerException();
        this.language = language;
    }
}
