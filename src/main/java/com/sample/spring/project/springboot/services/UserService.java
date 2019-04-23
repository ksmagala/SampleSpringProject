package com.sample.spring.project.springboot.services;

import com.sample.spring.project.springboot.domain.CarRental;
import com.sample.spring.project.springboot.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User saveUser(User user);
    User editUser(User user);
    User deleteUser(User user);

    Boolean login(String login, String password);
    Boolean logout();

    boolean rentACar(String carId, CarRental rental);
    boolean returnRentCar(String userId, String carId);

}
