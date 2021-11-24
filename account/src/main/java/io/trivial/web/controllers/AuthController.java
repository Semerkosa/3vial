package io.trivial.web.controllers;

import static org.springframework.http.HttpStatus.OK;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.trivial.constants.SecurityConstant;
import io.trivial.models.binding.UserLoginBindingModel;
import io.trivial.models.binding.UserRegisterBindingModel;
import io.trivial.models.entites.User;
import io.trivial.models.service.UserServiceModel;
import io.trivial.models.view.UserViewModel;
import io.trivial.service.JwtToken;
import io.trivial.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
public class AuthController {
	
	private final ModelMapper modelMapper;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtToken jwtToken;

    @Autowired
    public AuthController(ModelMapper modelMapper, UserService userService,
    		AuthenticationManager authenticationManager, JwtToken jwtToken) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtToken = jwtToken;
    }

	@PostMapping("/user/login")
    public ResponseEntity<UserServiceModel> login(@Valid @RequestBody UserLoginBindingModel user) {
        String email = this.authenticate(user.getEmail(), user.getPassword());
        UserServiceModel returnedUser = this.userService.getUserByEmail(email);
        HttpHeaders headers = this.getHeader(returnedUser);
        headers.set("Access-Control-Expose-Headers", "User-Token");
        return new ResponseEntity<>(returnedUser, headers, OK);
    }
    
    @PostMapping(
            value = "/user/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserViewModel> register(@RequestBody UserRegisterBindingModel inUser) {
        UserServiceModel returnedUser = this.userService.register(this.modelMapper.map(inUser, UserServiceModel.class));
        return new ResponseEntity<UserViewModel>(this.modelMapper.map(returnedUser, UserViewModel.class), HttpStatus.OK);
    }
    
    @GetMapping("/refresh/token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
    	//TODO
    }
    
    private String authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        return email;
    }
    
    private HttpHeaders getHeader(UserServiceModel usm) {
        HttpHeaders headers = new HttpHeaders();
        User user = this.modelMapper.map(usm, User.class);
        String[] tokens = jwtToken.generateJwtTokens(user);
        headers.add(SecurityConstant.USER_TOKEN_KEY, tokens[0]);
        headers.add(SecurityConstant.REFRESH_TOKEN_KEY, tokens[1]);
        return headers;
    }
	
}
