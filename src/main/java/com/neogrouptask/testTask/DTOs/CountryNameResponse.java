package com.neogrouptask.testTask.DTOs;

public class CountryNameResponse {

    public CountryNameResponse(String countryName, String error) {
        this.countryName = countryName;
        this.error = error;
    }

    private String countryName;
    private String error;

    public String getCountryName() {
        return this.countryName;
    }

    public String getError() {
        return error;
    }
}
