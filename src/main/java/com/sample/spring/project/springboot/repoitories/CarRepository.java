package com.sample.spring.project.springboot.repoitories;

import com.sample.spring.project.springboot.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findByStatusCar(String status);
}
