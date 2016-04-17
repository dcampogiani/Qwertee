package com.danielecampogiani.qwertee.data.local.model;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class SimpleDayTest {

    @Test
    public void testSameYearAndMonthAndDay() throws Exception {
        SimpleDay first = new SimpleDay(1, 1, 1990);
        SimpleDay second = new SimpleDay(1, 1, 1990);

        assertThat(first.isBefore(second)).isFalse();
        assertThat(first.isAfter(second)).isFalse();
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void testDifferentYear() throws Exception {
        SimpleDay first = new SimpleDay(1, 12, 1990);
        SimpleDay second = new SimpleDay(1, 1, 1991);

        assertThat(first.isBefore(second)).isTrue();
        assertThat(first.isAfter(second)).isFalse();

        assertThat(second.isBefore(first)).isFalse();
        assertThat(second.isAfter(first)).isTrue();

        assertThat(first).isNotEqualTo(second);
    }

    @Test
    public void testSameYearDifferentMonth() throws Exception {
        SimpleDay first = new SimpleDay(31, 1, 1990);
        SimpleDay second = new SimpleDay(1, 2, 1990);

        assertThat(first.isBefore(second)).isTrue();
        assertThat(first.isAfter(second)).isFalse();

        assertThat(second.isBefore(first)).isFalse();
        assertThat(second.isAfter(first)).isTrue();

        assertThat(first).isNotEqualTo(second);

    }

    @Test
    public void testSameYearSomeMonthDifferentDay() throws Exception {
        SimpleDay first = new SimpleDay(1, 1, 1990);
        SimpleDay second = new SimpleDay(2, 1, 1990);

        assertThat(first.isBefore(second)).isTrue();
        assertThat(first.isAfter(second)).isFalse();

        assertThat(second.isBefore(first)).isFalse();
        assertThat(second.isAfter(first)).isTrue();

        assertThat(first).isNotEqualTo(second);

    }
}