package com.neogrouptask.testTask.Repository;

import com.neogrouptask.testTask.Repositories.CountryCodeRepository;
import com.neogrouptask.testTask.Repositories.CountryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountryCodeRepositoryTests {

    @Autowired
    private CountryCodeRepository countryCodeRepository;

    @Test
    void IsCountryCodeTableFilled() {

        int savedCountryCodeCount = countryCodeRepository.getCodesCount();

        Assertions.assertTrue(savedCountryCodeCount > 0);
    }
}
