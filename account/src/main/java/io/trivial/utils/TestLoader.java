package io.trivial.utils;

import io.trivial.exception.UserDoesNotExistException;
import io.trivial.exception.UserExistException;
import io.trivial.models.entites.Role;
import io.trivial.models.services.AddressServiceModel;
import io.trivial.models.services.RoleServiceModel;
import io.trivial.models.services.UserServiceModel;
import io.trivial.repositories.UserRepository;
import io.trivial.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestLoader implements CommandLineRunner {

    private final UserService userService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TestLoader(UserService userService, UserRepository userRepository, ModelMapper modelMapper) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.userRepository.count() == 0)
            this.createAndSaveUser();
        this.getUserById("7c391033-b062-4ff1-833c-888870dbd7e5");
    }

    private void getUserById(String id) throws UserDoesNotExistException {
        UserServiceModel u = this.userService.getUserById(id);
        List<RoleServiceModel> roles = u.getRoles().stream()
                        .map(e -> this.modelMapper.map(e, RoleServiceModel.class))
                                .collect(Collectors.toList());
        System.out.println(u.getEmail());
    }

    private void createAndSaveUser() throws UserExistException {
        UserServiceModel user = new UserServiceModel();
        user.setEmail("ivan@example.com");
        user.setPassword("12345678");
        /* Address */
        AddressServiceModel address = new AddressServiceModel();
        address.setCity("Sofia");
        address.setCountry("Bulgaria");
        address.setStreet("Vitoshka");
        address.setStreetNumber("100");
        address.setPostCode("1000");
        user.setAddress(address);
        this.userService.register(user);
    }
}
