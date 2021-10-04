package io.trivial.service;

import io.trivial.exception.UserDoesNotExistException;
import io.trivial.exception.UserExistException;
import io.trivial.models.services.UserServiceModel;

public interface UserService {

    UserServiceModel register(UserServiceModel inUser) throws UserExistException;

    UserServiceModel update(UserServiceModel inUser);

    boolean deleteUserById(String id) throws UserDoesNotExistException;

    UserServiceModel getUserById(String id) throws UserDoesNotExistException;

    UserServiceModel getUserByEmail(String email) throws UserDoesNotExistException;

}
