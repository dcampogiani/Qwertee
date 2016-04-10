package com.danielecampogiani.qwertee.data.network.retrofit;


import com.danielecampogiani.qwertee.data.network.rawresponses.Mapper;
import com.danielecampogiani.qwertee.data.network.rawresponses.MapperImpl;
import com.danielecampogiani.qwertee.data.network.rawresponses.Page;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class PageAdapter implements Converter<ResponseBody, Page> {

    public static final Converter.Factory FACTORY = new Converter.Factory() {
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(
                Type type, Annotation[] annotations, Retrofit retrofit) {
            if (type == Page.class)
                return new PageAdapter();
            return null;
        }
    };

    private final Mapper mapper;

    //TODO this should be injected
    public PageAdapter() {
        this.mapper = new MapperImpl();
    }

    @Override
    public Page convert(ResponseBody value) throws IOException {
        return mapper.map(value.string());
    }
}
