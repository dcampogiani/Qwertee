package com.danielecampogiani.qwertee.data.local.model;

import com.danielecampogiani.qwertee.presentation.data.TShirt;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class MapperImplTest {

    private MapperImpl subjectUnderTest;

    @Before
    public void setUp() throws Exception {
        subjectUnderTest = new MapperImpl();
    }

    @Test
    public void testMapFromTShirt() throws Exception {

        TShirt input = new TShirt("title","description",1,2);
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
}