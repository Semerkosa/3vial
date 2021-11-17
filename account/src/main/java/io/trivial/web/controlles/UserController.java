package io.trivial.web.controlles;

import io.trivial.models.binding.UserRegisterBindingModel;
import io.trivial.models.entites.User;
import io.trivial.models.service.UserServiceModel;
import io.trivial.models.view.UserKeyOrganizationViewModel;
import io.trivial.models.view.UserViewModel;
import io.trivial.repositories.UserRepository;
import io.trivial.service.UserService;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/user")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService,
    		UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.userRepository = userRepository;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping (
            value = "/account/provider_api_keys",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserKeyOrganizationViewModel> getUserOrganizationByToken(@RequestHeader("User-Token") String token) {
        UserServiceModel returnedUser = this.userService.getUserByEmail("ivan@example.com");
        ResponseEntity<UserKeyOrganizationViewModel> response =
        		new ResponseEntity<UserKeyOrganizationViewModel>(this.modelMapper.map(returnedUser, UserKeyOrganizationViewModel.class), HttpStatus.OK);
        return response;
    }

    @GetMapping("/refresh/token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
    	String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refreshToken = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refreshToken);
				String email = decodedJWT.getSubject();
				User user = this.userRepository.findUserByEmail(email).orElse(null); //TODO
				String accessToken = JWT.create()
						.withSubject(user.getEmail())
						.withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 100))
						.withIssuer(request.getRequestURI().toString())
						.withClaim("roles", user.getAuthorities()
								.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
						.sign(algorithm);
				Map<String, String> error = new HashMap<>();
				error.put("refresh-tken", refreshToken);
				error.put("access-roken", accessToken);
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), error);
			} catch (Exception e) {
				response.setHeader("error", e.getMessage());
				response.setStatus(HttpStatus.FORBIDDEN.value());
//				response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name());
				Map<String, String> error = new HashMap<>();
				error.put("error-message", e.getMessage());
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), error);
			}
		} else {
			throw new RuntimeException("Refresh token is missing!");
		}
    }
    
    //Fake login
//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping (
//            value = "/login",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<UserViewModel> login() {
//        UserServiceModel returnedUser = this.userService.getUserByEmail("ivan@example.com");
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("User-Token", "9s78dhfs78tfaysd6ftausdygf6asd67");
//        headers.set("Access-Control-Expose-Headers", "User-Token");
//        ResponseEntity<UserViewModel> response =
//        		new ResponseEntity<UserViewModel>(this.modelMapper.map(returnedUser, UserViewModel.class), headers, HttpStatus.OK);
//        return response;
//    }
}