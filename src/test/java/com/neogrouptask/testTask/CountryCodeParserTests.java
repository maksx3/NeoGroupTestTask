package com.neogrouptask.testTask;

import com.neogrouptask.testTask.DTOs.CountryCallingCodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CountryCodeParserTests {
    @Test
    void simpleCountryCodeParsing() {
        CountryCallingCodes code = new CountryCallingCodes("", "371");
        List<String> codes = code.getCallingCodeList();

        List<String> expectedCodes = new ArrayList<>();
        expectedCodes.add("371");

        Assertions.assertEquals(expectedCodes, codes);
    }

    @Test
    void twoMainCountryCodeParsing() {
        CountryCallingCodes code = new CountryCallingCodes("", "882 883");
        List<String> codes = code.getCallingCodeList();

        List<String> expectedCodes = new ArrayList<>();
        expectedCodes.add("882");
        expectedCodes.add("883");

        Assertions.assertEquals(expectedCodes, codes);
    }

    @Test
    void countryCodeWithOneSubcodeParsing() {
        CountryCallingCodes code = new CountryCallingCodes("", "7 (840)");
        List<String> codes = code.getCallingCodeList();

        List<String> expectedCodes = new ArrayList<>();
        expectedCodes.add("7840");

        Assertions.assertEquals(expectedCodes, codes);
    }

    @Test
    void countryCodeWithTwoSubcodeParsing() {
        CountryCallingCodes code = new CountryCallingCodes("", "7 (840, 940)");
        List<String> codes = code.getCallingCodeList();

        List<String> expectedCodes = new ArrayList<>();
        expectedCodes.add("7840");
        expectedCodes.add("7940");

        Assertions.assertEquals(expectedCodes, codes);
    }

    @Test
    void countryCodeWithOneSubcodeAndTwoMainCodesParsing() {
        CountryCallingCodes code = new CountryCallingCodes("", "39 (06698) 379");
        List<String> codes = code.getCallingCodeList();

        List<String> expectedCodes = new ArrayList<>();
        expectedCodes.add("3906698");
        expectedCodes.add("379");

        Assertions.assertEquals(expectedCodes, codes);
    }

    @Test
    void countryCodeWithTwoSubcodeAndTwoMainCodesParsing() {
        CountryCallingCodes code = new CountryCallingCodes("", "7 (6, 7) 997");
        List<String> codes = code.getCallingCodeList();

        List<String> expectedCodes = new ArrayList<>();
        expectedCodes.add("76");
        expectedCodes.add("77");
        expectedCodes.add("997");

        Assertions.assertEquals(expectedCodes, codes);
    }
}
