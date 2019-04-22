package com.sample.spring.project.springboot.services;

import com.sample.spring.project.springboot.domain.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();
    List<Car> getCarsByStatus(String status);
    Car addCar(Car car);
    Car updateCar(Car car);
    Boolean deleteCar(String carId);
    Car changeStatusCar(String  carId, String status);
    Car getCar(String carId);

}
