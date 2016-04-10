package com.danielecampogiani.qwertee.data.network.rawresponses;


import com.danielecampogiani.qwertee.presentation.data.TShirt;

public class Page {

    private final TShirt[] tShirts;

    public Page(TShirt[] tShirts) {
        if (tShirts != null) {
            this.tShirts = tShirts;
        } else {
            this.tShirts = new TShirt[0];
        }
    }

    public TShirt[] gettShirts() {
        return tShirts;
    }
}
