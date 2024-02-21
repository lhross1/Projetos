package com.luis.Countries.services;

import com.luis.Countries.model.entity.Country;
import com.luis.Countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServices {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> findAll(){
        return countryRepository.findAll();
    }
    public Page<Country> findByRegionAndKeyWord(String region, Integer keyWord, Pageable pageable) {
        return countryRepository.findByRegionAndKeyWord(region, keyWord, pageable);
    }




}
