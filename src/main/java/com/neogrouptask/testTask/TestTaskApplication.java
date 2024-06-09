package com.neogrouptask.testTask;

import com.neogrouptask.testTask.DTOs.CountryCallingCodes;
import org.springframework.beans.factory.annotation.Autowired;
import com.neogrouptask.testTask.Services.CountryService;
import com.neogrouptask.testTask.Services.JsoupService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class TestTaskApplication {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TestTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            List<CountryCallingCodes> countryCallingCodesList = JsoupService.GetCountryCallingCodes();
            countryService.SaveCountryCallingCodes(countryCallingCodesList);
        };
    }

}
