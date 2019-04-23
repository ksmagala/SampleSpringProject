package com.sample.spring.project.springboot.controllers;

import com.sample.spring.project.springboot.domain.CarRental;
import com.sample.spring.project.springboot.domain.User;
import com.sample.spring.project.springboot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/user";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getAllUser() {
        return userService.findAllUsers();
    }

    //@GetMapping("/{id}")
    //public User getUserById(@PathVariable Long id){ return userService.findUserById(id);  }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Boolean login(String login, String password) {
        return userService.login(login, password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Boolean logout() {
        return userService.logout();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public User editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public User deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public User changeUserStatus(String userId, String status) {
        return userService.changeUserStatus(userId, status);
    }

    @RequestMapping(value = "/rentCar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean rentCar(String carId, @RequestBody CarRental carRental){
        return userService.rentACar(carId, carRental);
    }

    @RequestMapping(value = "/returnCar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean rentCar(String userId, String carId){
        return userService.returnRentCar(userId, carId);
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public boolean makePayment(String rentalId){
        return userService.makePayment(rentalId);
    }

}
