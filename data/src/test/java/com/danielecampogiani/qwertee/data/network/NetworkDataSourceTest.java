package com.danielecampogiani.qwertee.data.network;

import com.danielecampogiani.qwertee.data.network.rawresponses.Mapper;
import com.danielecampogiani.qwertee.data.network.rawresponses.MapperImpl;
import com.danielecampogiani.qwertee.data.network.retrofit.PageAdapter;
import com.danielecampogiani.qwertee.data.network.retrofit.RetrofitQwertee;
import com.danielecampogiani.qwertee.presentation.data.TShirt;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class NetworkDataSourceTest {

    private RetrofitQwertee retrofitQwertee;
    private Mapper mapper;
    private NetworkDataSource subjectUnderTest;

    @Before
    public void setUp() throws Exception {
        retrofitQwertee = buildRetrofit();
        mapper = new MapperImpl();
        subjectUnderTest = new NetworkDataSource(retrofitQwertee, mapper);
    }

    @Test
    public void testGetDailyDeals() throws Exception {
        final TShirt[] tshirts = subjectUnderTest.getDailyDeals().toBlocking().first();
        assertThat(tshirts).hasSize(6);
    }

    @Test
    public void testGetAll() throws Exception {
        TShirt[] tShirts = subjectUnderTest.getAll().toBlocking().first();
        assertThat(tShirts).hasSize(119);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFromIdNotLoadedData() throws Exception {
        subjectUnderTest.get(91268).toBlocking().first();
    }

    @Test
    public void testGetFromId() throws Exception {
        subjectUnderTest.getAll().toBlocking().first();
        final TShirt tShirt = subjectUnderTest.get(91268).toBlocking().first();
        assertThat(tShirt.getId()).isEqualTo(91268);

    }

    private RetrofitQwertee buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.qwertee.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(PageAdapter.FACTORY)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        return retrofit.create(RetrofitQwertee.class);
    }
}