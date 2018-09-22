package com.sda.repository;

import com.sda.domain.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

class LanguageRepositorySpec {

    private LanguageRepository languageRepository;

    @BeforeEach
    void setUp() {
        languageRepository = new LanguageRepository();
    }

    @Test
    void testFindingAllLanguages() {
        List<Language> languages = languageRepository.findAll();

        assertThat(languages, hasItem(hasProperty("name", equalTo("English"))));
        assertThat(languages, hasItem(hasProperty("name", equalTo("Italian"))));
        assertThat(languages, hasItem(hasProperty("name", equalTo("Japanese"))));
        assertThat(languages, hasItem(hasProperty("name", equalTo("Mandarin"))));
        assertThat(languages, hasItem(hasProperty("name", equalTo("French"))));
        assertThat(languages, hasItem(hasProperty("name", equalTo("German"))));
    }

}