package io.trivial.web.controllers;


import io.trivial.models.service.UserServiceModel;
import io.trivial.models.view.KeyOrganisationViewModelList;
import io.trivial.models.view.UserKeyOrganizationViewModel;
import io.trivial.models.view.UserViewModel;
import io.trivial.service.JwtToken;
import io.trivial.service.UserService;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtToken jwtToken;
    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService,
                          AuthenticationManager authenticationManager, JwtToken jwtToken) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtToken = jwtToken;
    }

    @GetMapping(
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(
            value = "/account/provider_api_keys",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserKeyOrganizationViewModel> getUserOrganizationByToken(@RequestHeader("User-Token") String token) {
        String email = jwtToken.getSubject(token);
        UserServiceModel returnedUser = this.userService.getUserByEmail(email);
        ResponseEntity<UserKeyOrganizationViewModel> response =
                new ResponseEntity<UserKeyOrganizationViewModel>(this.modelMapper.map(returnedUser, UserKeyOrganizationViewModel.class), HttpStatus.OK);
        return response;
    }


    @PostMapping(
            value = "/account/provider_api_keys"
    )
    public HttpStatus addSource(
            @RequestHeader("User-Token") String token,
            @RequestBody KeyOrganisationViewModelList keyOrganizationList) {
        String email = jwtToken.getSubject(token);

        userService.addSource(email, keyOrganizationList);

        return HttpStatus.OK;
    }


}