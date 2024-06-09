package com.neogrouptask.testTask.Services;

import com.neogrouptask.testTask.DTOs.CountryCallingCodes;
import com.neogrouptask.testTask.Entites.Country;
import com.neogrouptask.testTask.Entites.CountryCode;
import com.neogrouptask.testTask.Repositories.CountryCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Configurable
public class CountryCodeService {

    @Autowired
    private CountryCodeRepository countryCodeRepository;

    public void SaveCountryCodes(CountryCallingCodes countryCallingCodes, Country country) {
        var separatedCountryCallingCodes = countryCallingCodes.getCallingCodeList();

        for (String callingCode : separatedCountryCallingCodes) {
            CountryCode cc = new CountryCode();
            cc.setCode(callingCode);
            cc.setCountry(country);
            countryCodeRepository.save(cc);
        }
    }

    public String GetCountryByPhone(String phone) {
        int max = Math.min(phone.length(), countryCodeRepository.getMaxCodeLength());
        for (int i = max; i > 0; i--) {
            String croppedPhone = phone.substring(0, i);
            List<String> countries = countryCodeRepository.findCountryNameByPhone(croppedPhone);
            if (!countries.isEmpty()) {
                return String.join(",", countries);
            }
        }
        return null;
    }
}
