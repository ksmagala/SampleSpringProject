package com.sample.spring.project.springboot.services;

import com.sample.spring.project.springboot.domain.CarRental;
import com.sample.spring.project.springboot.domain.User;
import com.sample.spring.project.springboot.repoitories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarService carService;



    public UserServiceImpl(UserRepository userRepository, CarService carService) {
        this.userRepository = userRepository;
        this.carService = carService;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public Boolean login(String login, String password) {
        return null;
    }

    @Override
    public Boolean logout() {
        return null;
    }

    @Override
    public List<CarRental> checkMyRentals() {
        return null;
    }

    @Override
    public boolean rentACar(String carId, CarRental rental) {
        return true;
    }

    @Override
    public boolean returnRentCar(String userId, String carId) {
        return false;
    }
}
