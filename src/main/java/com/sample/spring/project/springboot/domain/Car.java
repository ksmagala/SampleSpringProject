package com.sample.spring.project.springboot.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String model;
    private String name;
    private String status;
    private Double price;
    private List<CarRental> carRentalList;
}
