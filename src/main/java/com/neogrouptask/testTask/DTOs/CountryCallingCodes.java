package com.neogrouptask.testTask.DTOs;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class CountryCallingCodes {
    private String countryName;
    private String callingCode;

    public CountryCallingCodes(String countryName, String callingCode) {
        super();
        this.countryName = countryName;
        this.callingCode = callingCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCallingCode(String callingCode) {
        this.callingCode = callingCode;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public ArrayList<String> getCallingCodeList() {
        ArrayList<String> result = new ArrayList<>();

        // "39 (123, 234) 379"]
        String[] parts = this.callingCode.split("\\s*\\)\\s*"); // ["39 (123, 234", "379"]

        for (String part : parts) {
            if (part.contains("(")) { // "39 (123, 234"
                String mainCode = part.substring(0, part.indexOf(" ("));
                String subCodes = part.replaceFirst(mainCode, "");
                subCodes = subCodes.replace(" (", "");

                result.addAll(List.of(subCodes.split("(\\s*,\\s*)")));

                result.replaceAll(s -> mainCode + s);
            } else { // 379
                result.addAll(List.of(part.split("\\s* \\s*")));
            }
        }

        return result;
    }
}
