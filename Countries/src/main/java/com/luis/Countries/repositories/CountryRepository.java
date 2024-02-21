package com.luis.Countries.repositories;

import com.luis.Countries.model.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {


    Page<Country> findByRegionAndKeyWord(String region, Integer keyWord, Pageable pageable);
}
