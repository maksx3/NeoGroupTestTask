package com.neogrouptask.testTask.Services;

import com.neogrouptask.testTask.DTOs.CountryCallingCodes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.neogrouptask.testTask.CssSelectors.*;

public class JsoupService {
    public static List<CountryCallingCodes> GetCountryCallingCodes() throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_country_calling_codes#Alphabetical_order").get();
        Elements tableRows = doc.select(AlphabeticalOrderTableCssSelector);

        List<CountryCallingCodes> countryCallingCodesList = new ArrayList<>();

        for (int i = 2; i < tableRows.size(); i++) {
            String countryName = tableRows.get(i).select(CountryNameCssSelector).text();
            String countryCodes = tableRows.get(i).select(CountryCodeCssSelector).text();

            countryCallingCodesList.add(new CountryCallingCodes(countryName, countryCodes));
        }

        return countryCallingCodesList;
    }
}
