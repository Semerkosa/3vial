package io.trivial.web.controllers;

import io.trivial.exception.UserDoesNotExistException;
import io.trivial.exception.UserExistException;
import io.trivial.models.binding.UserRegisterBindingModel;
import io.trivial.models.binding.UserUpdateBindingModel;
import io.trivial.models.services.UserServiceModel;
import io.trivial.models.views.UserViewModel;
import io.trivial.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostMapping (
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserViewModel> register(@RequestBody UserRegisterBindingModel inUser) throws UserExistException {
        UserServiceModel returnedUser = this.userService.register(this.modelMapper.map(inUser, UserServiceModel.class));
        return new ResponseEntity<>(this.modelMapper.map(returnedUser, UserViewModel.class), HttpStatus.OK);
    }

    @GetMapping(
            value = "/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserViewModel> getUserByEmail(@PathVariable String email) throws UserDoesNotExistException {
        UserServiceModel foundedUser = this.userService.getUserByEmail(email);
        return new ResponseEntity<>(this.modelMapper.map(foundedUser, UserViewModel.class), HttpStatus.OK);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserViewModel> getUserById(@PathVariable String id) throws UserDoesNotExistException {
        UserServiceModel foundedUser = this.userService.getUserById(id);
        return new ResponseEntity<>(this.modelMapper.map(foundedUser, UserViewModel.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable String id) throws UserDoesNotExistException {
        boolean isDeleted = this.userService.deleteUserById(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }

    @PostMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserViewModel> updateUser(@RequestBody UserUpdateBindingModel inUser) {
        //TODO
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
