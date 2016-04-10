package com.danielecampogiani.qwertee.presentation.data;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class TShirtTest {

    @Test
    public void testGetTitle() throws Exception {
        TShirt subjectUnderTest = new TShirt("title",null,null,1);
        assertThat(subjectUnderTest.getTitle()).isEqualTo("title");
    }

    @Test
    public void testGetTitleWithNull() throws Exception {
        TShirt subjectUnderTest = new TShirt(null,null,null,1);
        assertThat(subjectUnderTest.getTitle()).isEmpty();
    }

    @Test
    public void testGetDescription() throws Exception {
        TShirt subjectUnderTest = new TShirt(null,"description",null,1);
        assertThat(subjectUnderTest.getDescription()).isEqualTo("description");
    }

    @Test
    public void testGetDescriptionWithNull() throws Exception {
        TShirt subjectUnderTest = new TShirt(null,null,null,1);
        assertThat(subjectUnderTest.getDescription()).isEmpty();
    }

    @Test
    public void testGetId() throws Exception {
        TShirt subjectUnderTest = new TShirt(null,null,"id",1);
        assertThat(subjectUnderTest.getId()).isEqualTo("id");
    }

    @Test
    public void testGetIdWithNull() throws Exception {
        TShirt subjectUnderTest = new TShirt(null,null,null,1);
        assertThat(subjectUnderTest.getId()).isEmpty();
    }

    @Test
    public void testGetPrice() throws Exception {
        TShirt subjectUnderTest = new TShirt(null,null,null,42);
        assertThat(subjectUnderTest.getPrice()).isEqualTo(42);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPrice() throws Exception {
        new TShirt(null,null,null,-1);
    }

    @Test
    public void testEquals() throws Exception {
        TShirt first = new TShirt("title","description","id",42);
        TShirt second = new TShirt("title","description","id",42);
        assertThat(first.equals(second)).isTrue();
    }

    @Test
    public void testNotEquals() throws Exception {
        TShirt first = new TShirt("title1","description1","id1",42);
        TShirt second = new TShirt("title2","description2","id2",42);
        assertThat(first.equals(second)).isFalse();
    }

    @Test
    public void testSameHashCode() throws Exception {
        TShirt first = new TShirt("title","description","id",42);
        TShirt second = new TShirt("title","description","id",42);
        assertThat(first.hashCode()).isEqualTo(second.hashCode());
    }

    @Test
    public void testDifferentHashCode() throws Exception {
        TShirt first = new TShirt("title1","description1","id1",42);
        TShirt second = new TShirt("title2","description2","id2",42);
        assertThat(first.hashCode()).isNotEqualTo(second.hashCode());
    }
}