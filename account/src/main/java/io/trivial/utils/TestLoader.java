package io.trivial.utils;

import io.trivial.models.services.AddressServiceModel;
import io.trivial.models.services.UserServiceModel;
import io.trivial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestLoader implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public TestLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.createAndSaveUser();
    }

    private void createAndSaveUser() {
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
