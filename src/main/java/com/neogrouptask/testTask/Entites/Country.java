package com.neogrouptask.testTask.Entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "country")
    Collection<CountryCode> countryCodes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<CountryCode> getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(Collection<CountryCode> countryCodes) {
        this.countryCodes = countryCodes;
    }

    public void addCountryCodes(ArrayList<CountryCode> countryCodes) {
        this.countryCodes = countryCodes;
    }
}
