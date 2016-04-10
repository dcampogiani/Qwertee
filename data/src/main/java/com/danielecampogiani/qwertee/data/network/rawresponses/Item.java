package com.danielecampogiani.qwertee.data.network.rawresponses;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Item {

    @Element(name = "guid")
    private String guid;

    @Element(name = "pubDate")
    private String pubDate;

    @Element(name = "title")
    private String title;

    @Element(name = "description")
    private String description;

    @Element(name = "link")
    private String link;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        if (guid == null)
            throw new NullPointerException();
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        if (pubDate == null)
            throw new NullPointerException();
        this.pubDate = pubDate;
    }

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        if (link == null)
            throw new NullPointerException();
        this.link = link;
    }
}
