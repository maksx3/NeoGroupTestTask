package com.neogrouptask.testTask.Repositories;

import com.neogrouptask.testTask.Entites.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryCodeRepository extends JpaRepository<CountryCode, Long> {

    @Query(value = "SELECT country.name FROM country_code INNER JOIN country ON country_code.country_id = country.id WHERE code like :#{#phone}", nativeQuery = true)
    List<String> findCountryNameByPhone(@Param("phone") String phone);

    @Query(value = "SELECT MAX(LENGTH(code)) FROM country_code", nativeQuery = true)
    int getMaxCodeLength();

    @Query(value = "SELECT COUNT(code) FROM country_code ", nativeQuery = true)
    int getCodesCount();
}
