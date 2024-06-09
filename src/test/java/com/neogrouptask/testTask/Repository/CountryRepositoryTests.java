package com.neogrouptask.testTask.Repository;

import com.neogrouptask.testTask.Repositories.CountryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountryRepositoryTests {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void IsCountryTableFilled() {

        int savedCountryCount = countryRepository.getCountryCount();

        Assertions.assertTrue(savedCountryCount > 0);
    }
}
