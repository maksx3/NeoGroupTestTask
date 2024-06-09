package com.neogrouptask.testTask.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountryCodeServiceTests {

    @Autowired
    private CountryCodeService countryCodeService;

    @Test
    void findLatviaByPhone() {
        String country = countryCodeService.GetCountryByPhone("37120000000");

        Assertions.assertEquals("Latvia", country);
    }

    @Test
    void findBahamasByPhone() {
        String country = countryCodeService.GetCountryByPhone("12423222931");

        Assertions.assertEquals("Bahamas", country);
    }

    @Test
    void findUnitedStatesCanadaByPhone() {
        String country = countryCodeService.GetCountryByPhone("11165384765");

        Assertions.assertTrue("United States,Canada".equals(country) || "Canada,United States".equals(country));
    }

    @Test
    void findRussiaByPhone() {
        String country = countryCodeService.GetCountryByPhone("71423423412");

        Assertions.assertEquals("Russia", country);
    }

    @Test
    void findKazakhstanByPhone() {
        String country = countryCodeService.GetCountryByPhone("77112227231");

        Assertions.assertEquals("Kazakhstan", country);
    }
}
