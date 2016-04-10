package com.danielecampogiani.qwertee.presentation.datasource;


import com.danielecampogiani.qwertee.presentation.data.TShirt;

public interface WritableDataSource extends DataSource {

    void writeDailyDeals(TShirt[] toBeSaved);

    void writeAll(TShirt[] toBeSaved);
}
