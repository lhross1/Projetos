package com.luis.Countries.controller;

import com.luis.Countries.model.dto.CountryDTO;
import com.luis.Countries.model.dto.PaginatedResponseDTO;
import com.luis.Countries.model.entity.Country;
import com.luis.Countries.services.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CountryController {
    @Autowired
    CountryServices countryServices;

    @GetMapping
    public ResponseEntity<List<Country>> findAll(){
        return ResponseEntity.ok(countryServices.findAll());

    }

    @GetMapping("/regionAndKeyWord")
    public ResponseEntity<PaginatedResponseDTO> findByRegionAndKeyWord(
            @RequestParam("region") String region, @RequestParam("keyWord") Integer keyWord, Pageable pageable){
      try{
          Page<Country> byRegionAndKeyWord = countryServices.findByRegionAndKeyWord(region, keyWord, pageable);
          List<CountryDTO> countryDTO = byRegionAndKeyWord.getContent().stream().map(t -> CountryDTO.builder()
                  .name(t.getName())
                  .region(t.getRegion())
                  .population(t.getPopulation())
                  .build()
          ).collect(Collectors.toList());

          PaginatedResponseDTO paginatedResponseDTO = PaginatedResponseDTO.builder()
                  .page(byRegionAndKeyWord.getNumber())
                  .perPage(byRegionAndKeyWord.getSize())
                  .total(byRegionAndKeyWord.getTotalElements())
                  .totalPages(byRegionAndKeyWord.getTotalPages())
                  .data(countryDTO)
                  .build();

          return ResponseEntity.ok(paginatedResponseDTO);

      } catch (Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
      }
    }





}
