package com.sample.spring.project.springboot.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class CarRental {


    User renter;
    String type;
    String status;
    Date startRentDate;
    Date plannedReturnRentDate;
    Date finishRentDate;
    Double payment;

}
