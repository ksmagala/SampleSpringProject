package com.sample.spring.project.springboot.services;

import com.sample.spring.project.springboot.domain.Car;
import com.sample.spring.project.springboot.domain.CarRental;
import com.sample.spring.project.springboot.domain.User;
import com.sample.spring.project.springboot.exceptions.EmptyParameterException;
import com.sample.spring.project.springboot.exceptions.UserDoesNotExistException;
import com.sample.spring.project.springboot.repoitories.CarRepository;
import com.sample.spring.project.springboot.repoitories.UserRepository;
import com.sample.spring.project.springboot.utils.CarStatus;
import com.sample.spring.project.springboot.utils.UserStatus;
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
    public List<User> findAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {

        if (user != null) {
            return userRepository.save(user);
        } else
            throw new EmptyParameterException("User is empty");
    }

    @Override
    public User editUser(User user) {

        if (user != null) {
            return userRepository.save(user);
        } else
            throw new EmptyParameterException("User is empty");
    }

    @Override
    public User deleteUser(User user) {
        if (user != null) {
            User tempUser = userRepository.findById(user.getEmail())
                    .orElseThrow(() -> new UserDoesNotExistException("User: " + user.getEmail() + " doesnt exist"));
            tempUser.setStatus(UserStatus.REMOVED.name());
            return userRepository.save(tempUser);
        } else
            throw new EmptyParameterException("User is empty");
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
    public boolean rentACar(String carId, CarRental rental) {
        if (carId != null && !carId.isEmpty() && rental != null && rental.getRenter() != null && rental.getRenter().getEmail() != null) {
            User tempUser = userRepository.findById(rental.getRenter().getEmail())
                    .orElseThrow(() -> new UserDoesNotExistException("Not exist user: " + rental.getRenter().getEmail()));
            Car car = carService.getCar(carId);
            car.getCarRentalList().stream()
                    .filter(e -> e.getStatus().equals(CarStatus.RESERVED.name())
                            || e.getStatus().equals(CarStatus.RENTED.name()))
                    .findFirst().orElseThrow(() -> new RuntimeException("Car is rented or reserved"));
            rental.setRenter(tempUser);
            car.getCarRentalList().add(rental);
            carService.updateCar(car);
            return true;
        } else
            throw new EmptyParameterException("CarId/rental is empty");
    }

    @Override
    public boolean returnRentCar(String userId, String carId) {
        if(!userId.isEmpty() && userId != null && !carId.isEmpty() && carId != null){
            User tempUser = userRepository.findById(userId)
                    .orElseThrow(()-> new UserDoesNotExistException("Not exist user: " + userId));
            Car car = carService.getCar(carId);
            car.getCarRentalList().stream()
                    .filter(carRental -> carRental.getRenter().getEmail().equals(userId)
                            && carRental.getStatus().equals(CarStatus.RENTED.name()))
                    .findFirst().orElseThrow(() -> new RuntimeException("User was not renting this car"));
            car.setStatus(CarStatus.FREE.name());
            carService.updateCar(car);
            return true;
        } else
            throw new EmptyParameterException("userId/carId is empty");
    }
}
