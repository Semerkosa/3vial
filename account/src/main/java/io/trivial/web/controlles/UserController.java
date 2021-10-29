package io.trivial.web.controlles;

import io.trivial.models.binding.UserRegisterBindingModel;
import io.trivial.models.service.UserServiceModel;
import io.trivial.models.view.UserOrganizationViewModel;
import io.trivial.models.view.UserViewModel;
import io.trivial.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserViewModel> register(@RequestBody UserRegisterBindingModel inUser) {
        UserServiceModel returnedUser = this.userService.register(this.modelMapper.map(inUser, UserServiceModel.class));
        return new ResponseEntity<UserViewModel>(this.modelMapper.map(returnedUser, UserViewModel.class), HttpStatus.OK);
    }

    @GetMapping (
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserViewModel> getUserById(@PathVariable String id) {
        UserServiceModel returnedUser = this.userService.getUserById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "9s78dhfs78tfaysd6ftausdygf6asd67");
        ResponseEntity<UserViewModel> response = 
        		new ResponseEntity<UserViewModel>(this.modelMapper.map(returnedUser, UserViewModel.class), headers, HttpStatus.OK);
        return response;
    }
    
    @GetMapping (
            value = "/account/provider_api_keys",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserOrganizationViewModel> getUserOrganizationByToken(@RequestHeader("User-Token") String token) {
        UserServiceModel returnedUser = this.userService.getUserByEmail("ivan@example.com");
        ResponseEntity<UserOrganizationViewModel> response = 
        		new ResponseEntity<UserOrganizationViewModel>(this.modelMapper.map(returnedUser, UserOrganizationViewModel.class), HttpStatus.OK);
        return response;
    }
    
    //Fake login
    @PostMapping (
            value = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserViewModel> login() {
        UserServiceModel returnedUser = this.userService.getUserByEmail("ivan@example.com");
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "9s78dhfs78tfaysd6ftausdygf6asd67");
        ResponseEntity<UserViewModel> response = 
        		new ResponseEntity<UserViewModel>(this.modelMapper.map(returnedUser, UserViewModel.class), headers, HttpStatus.OK);
        return response;
    }
}