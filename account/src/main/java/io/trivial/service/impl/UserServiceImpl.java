package io.trivial.service.impl;


import io.trivial.models.entites.KeyOrganization;
import io.trivial.models.entites.User;
import io.trivial.models.service.UserServiceModel;
import io.trivial.repositories.UserRepository;
import io.trivial.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserServiceModel register(UserServiceModel inUser) {
        User userForSave = this.modelMapper.map(inUser, User.class);
        userForSave.setPassword(this.bCryptPasswordEncoder.encode(inUser.getPassword()));
        userForSave.setKeysOrganization(new ArrayList<KeyOrganization>());
        User savedUser = this.saveUserToDb(userForSave);
        return this.modelMapper.map(savedUser, UserServiceModel.class);
    }

    @Override
    public UserServiceModel getUserById(String id) {
        User foundedUser = this.userRepository.findById(id).orElse(null);
        //TODO Does the user exist?
        return this.modelMapper.map(foundedUser, UserServiceModel.class);
    }

    /* PRIVATE METHODS */

    private User saveUserToDb(User user) {
        return this.userRepository.saveAndFlush(user);
    }

}
