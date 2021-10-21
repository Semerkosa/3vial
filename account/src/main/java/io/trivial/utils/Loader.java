package io.trivial.utils;

import io.trivial.enums.PrivilegeEnum;
import io.trivial.enums.RoleEnum;
import io.trivial.models.entites.Privilege;
import io.trivial.models.entites.Role;
import io.trivial.models.service.AddressServiceModel;
import io.trivial.models.service.UserServiceModel;
import io.trivial.repositories.PrivilegeRepository;
import io.trivial.repositories.RoleRepository;
import io.trivial.repositories.UserRepository;
import io.trivial.service.UserService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class Loader implements CommandLineRunner {

    private final PrivilegeRepository privilegeRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public Loader(PrivilegeRepository privilegeRepository, RoleRepository roleRepository,
    		UserRepository userRepository, UserService userService) {
        this.privilegeRepository = privilegeRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
		this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.userRepository.count() == 0) {
        	UserServiceModel user = new UserServiceModel();
        	user.setEmail("ivan@example.com");
        	user.setPassword("123456");
        	AddressServiceModel address = new AddressServiceModel();
        	address.setCity("Sofia");
        	address.setCountry("Bulgaria");
        	address.setPostCode("1000");
        	address.setStreet("Vitoshka");
        	address.setStreetNumber("100");
        	user.setAddress(address);
        	this.userService.register(user);
        }
    }
}
