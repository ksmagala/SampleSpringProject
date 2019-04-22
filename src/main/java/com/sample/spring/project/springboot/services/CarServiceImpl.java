package com.sample.spring.project.springboot.services;

import com.sample.spring.project.springboot.domain.Car;
import com.sample.spring.project.springboot.repoitories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getCarsByStatus(String status) {
        return carRepository.findByStatusCar(status);
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car) {

        carRepository.findById(car.getId());
        return carRepository.save(car);
    }

    @Override
    public Boolean deleteCar(String carId) {
        return null;
    }

    @Override
    public Car changeStatusCar(String carId, String status) {

        Optional<Car> tempCar = carRepository.findById(carId);
        tempCar.get().setStatus(status);
        return carRepository.save(tempCar.get());
    }

    @Override
    public Car getCar(String carId) {

        return carRepository.findById(carId).get();
    }
}
