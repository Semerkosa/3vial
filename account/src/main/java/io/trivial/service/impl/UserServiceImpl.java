package io.trivial.service.impl;

import io.trivial.models.services.UserServiceModel;
import io.trivial.repositories.UserRepository;
import io.trivial.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userService;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public UserServiceModel register(UserServiceModel inUser) {
        return null;
    }

    @Override
    public UserServiceModel update(UserServiceModel inUser) {
        return null;
    }

    @Override
    public boolean deleteUserById(String id) {
        return false;
    }

    @Override
    public UserServiceModel getUserById(String id) {
        return null;
    }

    @Override
    public UserServiceModel getUserByEmail(String email) {
        return null;
    }
}
