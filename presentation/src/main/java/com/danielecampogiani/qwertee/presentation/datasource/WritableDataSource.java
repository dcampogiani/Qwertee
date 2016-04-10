package com.danielecampogiani.qwertee.presentation.datasource;


import com.danielecampogiani.qwertee.presentation.data.TShirt;

public interface WritableDataSource extends DataSource {

    void write(TShirt[] toBeSaved);
}
