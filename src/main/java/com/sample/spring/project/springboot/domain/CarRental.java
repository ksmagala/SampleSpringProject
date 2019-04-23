package com.sample.spring.project.springboot.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Embeddable
public class CarRental {

    @OneToOne
    User renter;
    String type;
    String status;
    Date startRentDate;
    Date plannedReturnRentDate;
    Date finishRentDate;
    Double payment;

}
