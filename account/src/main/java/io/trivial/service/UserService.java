package io.trivial.service;

import io.trivial.models.services.UserServiceModel;

public interface UserService {

    UserServiceModel register(UserServiceModel inUser);

    UserServiceModel update(UserServiceModel inUser);

    boolean deleteUserById(String id);

    UserServiceModel getUserById(String id);

    UserServiceModel getUserByEmail(String email);

}
