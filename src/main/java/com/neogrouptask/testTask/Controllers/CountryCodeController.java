package com.neogrouptask.testTask.Controllers;

import com.neogrouptask.testTask.DTOs.CountryNameResponse;
import com.neogrouptask.testTask.Services.CountryCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryCodeController {

    @Autowired
    private CountryCodeService countryService;

    @GetMapping("/GetCountryByPhone")
    public CountryNameResponse index(@RequestParam String phone) {
        String country = countryService.GetCountryByPhone(phone);
        return new CountryNameResponse(country, country == null ? "Country not found" : null);
    }
}
