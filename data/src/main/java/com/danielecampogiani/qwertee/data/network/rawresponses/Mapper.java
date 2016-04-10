package com.danielecampogiani.qwertee.data.network.rawresponses;


import com.danielecampogiani.qwertee.presentation.data.TShirt;

public interface Mapper {

    TShirt[] map(Rss rssResponse);

    Page map(String html);
}
