package com.luis.Countries.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "name", length = 80, nullable = false)
    public String name;

    @Column(name = "key_word", nullable = false)
    public Integer keyWord;

    @Column(name = "region", length = 80, nullable = false)
    public String region;

    @Column(name = "population", nullable = false)
    public Long population;

}

