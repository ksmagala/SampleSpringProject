package com.sample.spring.project.springboot.services;

import com.sample.spring.project.springboot.domain.Car;
import com.sample.spring.project.springboot.exceptions.CarDoesNotExistException;
import com.sample.spring.project.springboot.exceptions.EmptyParameterException;
import com.sample.spring.project.springboot.repoitories.CarRepository;
import com.sample.spring.project.springboot.utils.CarStatus;
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
        if (!status.isEmpty() && status != null) {
            return carRepository.findByStatusCar(status);
        } else
            throw new EmptyParameterException("Status is empty");
    }

    @Override
    public Car addCar(Car car) {
        if (car != null) {
            return carRepository.save(car);
        } else
            throw new EmptyParameterException("Car parameter is empty");
    }

    @Override
    public Car updateCar(Car car) {
        if (car.getId() != null && car != null) {
            carRepository.findById(car.getId())
                    .orElseThrow(() -> new CarDoesNotExistException("Car " + car.getId() + " does not exist"));
            return carRepository.save(car);
        } else
            throw new EmptyParameterException("Car parameter is empty");
    }

    @Override
    public Boolean deleteCar(String carId) {
        if (!carId.isEmpty() && carId != null) {
            Car tempCar = carRepository.findById(carId)
                    .orElseThrow(() -> new CarDoesNotExistException("Car " + carId + " does not exist"));
            tempCar.setStatus(CarStatus.REMOVED.name());
            carRepository.save(tempCar);
            return true;
        } else
            throw new EmptyParameterException("Car parameter is empty");
    }

    @Override
    public Car changeStatusCar(String carId, String status) {
        if (!carId.isEmpty() && carId != null) {
            Optional<Car> tempCar = Optional.of(carRepository.findById(carId)
                    .orElseThrow(() -> new CarDoesNotExistException("Car " + carId + " does not exist")));
            tempCar.get().setStatus(status);
            return carRepository.save(tempCar.get());
        } else
            throw new EmptyParameterException("Car parameter is empty");
    }

    @Override
    public Car getCar(String carId) {
        if (!carId.isEmpty() && carId != null) {
            Optional<Car> tempCar = Optional.of(carRepository.findById(carId)
                    .orElseThrow(() -> new CarDoesNotExistException("Car " + carId + " does not exist")));
            return tempCar.get();
        } else
            throw new EmptyParameterException("Car parameter is empty");
    }

    @Override
    public Boolean reserveCar(String carId) {
        if (!carId.isEmpty() && carId != null) {
            Car tempCar = carRepository.findById(carId)
                    .orElseThrow(() -> new CarDoesNotExistException("Car " + carId + " does not exist"));
            tempCar.setStatus(CarStatus.RESERVED.name());
            carRepository.save(tempCar);
            return true;
        } else
            throw new EmptyParameterException("Car parameter is empty");
    }

    @Override
    public Boolean freeCar(String carId) {
        if (!carId.isEmpty() && carId != null) {
            Car tempCar = carRepository.findById(carId)
                    .orElseThrow(() -> new CarDoesNotExistException("Car " + carId + " does not exist"));
            tempCar.setStatus(CarStatus.FREE.name());
            carRepository.save(tempCar);
            return true;
        } else
            throw new EmptyParameterException("Car parameter is empty");
    }
}
