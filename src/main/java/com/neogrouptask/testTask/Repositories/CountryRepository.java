package com.neogrouptask.testTask.Repositories;

import com.neogrouptask.testTask.Entites.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query(value = "SELECT COUNT(name) FROM country ", nativeQuery = true)
    int getCountryCount();
}
