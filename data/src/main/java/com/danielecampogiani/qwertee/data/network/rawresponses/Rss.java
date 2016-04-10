package com.danielecampogiani.qwertee.data.network.rawresponses;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Rss {
    @Element(name = "channel")
    private Channel channel;

    @Attribute(name = "version")
    private String version;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        if (channel == null)
            throw new NullPointerException();
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        if (version == null)
            throw new NullPointerException();
        this.version = version;
    }
}
