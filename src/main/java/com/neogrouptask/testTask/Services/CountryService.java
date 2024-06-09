package com.neogrouptask.testTask.Services;

import com.neogrouptask.testTask.DTOs.CountryCallingCodes;
import com.neogrouptask.testTask.Entites.Country;
import com.neogrouptask.testTask.Entites.CountryCode;
import com.neogrouptask.testTask.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class CountryService {

    @Autowired
    private CountryCodeService countryCodeService;

    @Autowired
    private CountryRepository countryRepository;

    public void SaveCountryCallingCodes(List<CountryCallingCodes> countryCallingCodesList) {
        for (CountryCallingCodes countryCallingCodes : countryCallingCodesList) {
            Country country = new Country();
            country.setName(countryCallingCodes.getCountryName());
            countryRepository.save(country);
            countryCodeService.SaveCountryCodes(countryCallingCodes, country);
        }
    }
}
