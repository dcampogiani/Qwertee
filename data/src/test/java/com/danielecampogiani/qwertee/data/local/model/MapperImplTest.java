package com.danielecampogiani.qwertee.data.local.model;

import com.danielecampogiani.qwertee.data.local.model.realm.RealmDayCache;
import com.danielecampogiani.qwertee.data.local.model.realm.RealmSimpleDay;
import com.danielecampogiani.qwertee.data.local.model.realm.RealmTShirt;
import com.danielecampogiani.qwertee.presentation.data.TShirt;

import org.junit.Before;
import org.junit.Test;

import io.realm.RealmList;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class MapperImplTest {

    private MapperImpl subjectUnderTest;

    @Before
    public void setUp() throws Exception {
        subjectUnderTest = new MapperImpl();
    }

    @Test
    public void testMapFromTShirt() throws Exception {

        TShirt input = new TShirt("title", "description", 1, 2);
        RealmTShirt output = subjectUnderTest.map(input);
        assertThat(input.getTitle()).isEqualTo(output.getTitle());
        assertThat(input.getDescription()).isEqualTo(output.getDescription());
        assertThat(input.getId()).isEqualTo(output.getId());
        assertThat(input.getPrice()).isEqualTo(output.getPrice());
    }

    @Test
    public void testMapFromRealmTShirt() throws Exception {
        RealmTShirt input = new RealmTShirt();
        input.setTitle("title");
        input.setDescription("description");
        input.setId(1);
        input.setPrice(2);
        TShirt output = subjectUnderTest.map(input);
        assertThat(input.getTitle()).isEqualTo(output.getTitle());
        assertThat(input.getDescription()).isEqualTo(output.getDescription());
        assertThat(input.getId()).isEqualTo(output.getId());
        assertThat(input.getPrice()).isEqualTo(output.getPrice());
    }

    @Test
    public void testFromSimpleDayToRealmSimpleDay() throws Exception {
        SimpleDay input = new SimpleDay(1, 2, 3);
        RealmSimpleDay result = subjectUnderTest.map(input);
        assertThat(result.getDay()).isEqualTo(input.getDay());
        assertThat(result.getMonth()).isEqualTo(input.getMonth());
        assertThat(result.getYear()).isEqualTo(input.getYear());
    }

    @Test
    public void testFromRealmSimpleDayToSimpleDay() throws Exception {
        RealmSimpleDay input = new RealmSimpleDay();
        input.setDay(1);
        input.setMonth(2);
        input.setYear(3);
        SimpleDay result = subjectUnderTest.map(input);
        assertThat(result.getDay()).isEqualTo(input.getDay());
        assertThat(result.getMonth()).isEqualTo(input.getMonth());
        assertThat(result.getYear()).isEqualTo(input.getYear());

    }

    @Test
    public void testToDayCache() throws Exception {

        TShirt[] dailyDeals = new TShirt[2];
        dailyDeals[0] = new TShirt("title1", "description1", 1, 2);
        dailyDeals[1] = new TShirt("title2", "description2", 3, 4);
        TShirt firstDealExpected = dailyDeals[0];
        TShirt secondDealExpected = dailyDeals[1];
        TShirt[] all = new TShirt[2];
        all[0] = new TShirt("title3", "description1", 3, 5);
        all[1] = new TShirt("title4", "description2", 4, 6);
        TShirt firstAllExpected = all[0];
        TShirt secondAllExpected = all[1];

        SimpleDay day = new SimpleDay(1, 2, 3);

        RealmDayCache dayCache = subjectUnderTest.map(day, dailyDeals, all);

        assertThat(dayCache.getDay().getDay()).isEqualTo(day.getDay());
        assertThat(dayCache.getDay().getMonth()).isEqualTo(day.getMonth());
        assertThat(dayCache.getDay().getYear()).isEqualTo(day.getYear());

        RealmList<RealmTShirt> resultDeals = dayCache.getDailyDeals();
        assertThat(resultDeals).hasSize(2);

        RealmTShirt firstDealResult = resultDeals.get(0);
        assertThat(firstDealResult.getTitle()).isEqualTo(firstDealExpected.getTitle());
        assertThat(firstDealResult.getDescription()).isEqualTo(firstDealExpected.getDescription());
        assertThat(firstDealResult.getId()).isEqualTo(firstDealExpected.getId());
        assertThat(firstDealResult.getPrice()).isEqualTo(firstDealExpected.getPrice());

        RealmTShirt secondDealResult = resultDeals.get(1);
        assertThat(secondDealResult.getTitle()).isEqualTo(secondDealExpected.getTitle());
        assertThat(secondDealResult.getDescription()).isEqualTo(secondDealExpected.getDescription());
        assertThat(secondDealResult.getId()).isEqualTo(secondDealExpected.getId());
        assertThat(secondDealResult.getPrice()).isEqualTo(secondDealExpected.getPrice());

        RealmList<RealmTShirt> resultAll = dayCache.getAll();
        assertThat(resultAll).hasSize(2);

        RealmTShirt firstAllResult = resultAll.get(0);
        assertThat(firstAllResult.getTitle()).isEqualTo(firstAllExpected.getTitle());
        assertThat(firstAllResult.getDescription()).isEqualTo(firstAllExpected.getDescription());
        assertThat(firstAllResult.getId()).isEqualTo(firstAllExpected.getId());
        assertThat(firstAllResult.getPrice()).isEqualTo(firstAllExpected.getPrice());

        RealmTShirt secondAllResult = resultAll.get(1);
        assertThat(secondAllResult.getTitle()).isEqualTo(secondAllExpected.getTitle());
        assertThat(secondAllResult.getDescription()).isEqualTo(secondAllExpected.getDescription());
        assertThat(secondAllResult.getId()).isEqualTo(secondAllExpected.getId());
        assertThat(secondAllResult.getPrice()).isEqualTo(secondAllExpected.getPrice());

    }

    @Test
    public void testFromRealmListToArray() throws Exception {

        RealmTShirt first = new RealmTShirt();
        first.setTitle("title1");
        first.setDescription("description1");
        first.setId(1);
        first.setPrice(2);

        RealmTShirt second = new RealmTShirt();
        second.setTitle("title2");
        second.setDescription("description2");
        second.setId(3);
        second.setPrice(4);

        RealmList<RealmTShirt> input = new RealmList<>(first, second);

        TShirt[] result = subjectUnderTest.map(input);

        assertThat(result).hasSize(2);

        assertThat(result[0].getTitle()).isEqualTo(first.getTitle());
        assertThat(result[0].getDescription()).isEqualTo(first.getDescription());
        assertThat(result[0].getId()).isEqualTo(first.getId());
        assertThat(result[0].getPrice()).isEqualTo(first.getPrice());

        assertThat(result[1].getTitle()).isEqualTo(second.getTitle());
        assertThat(result[1].getDescription()).isEqualTo(second.getDescription());
        assertThat(result[1].getId()).isEqualTo(second.getId());
        assertThat(result[1].getPrice()).isEqualTo(second.getPrice());


    }
}