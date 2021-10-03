package io.trivial.service.impl;

import io.trivial.enums.PrivilegeEnum;
import io.trivial.enums.RoleEnum;
import io.trivial.exception.UserDoesNotExistException;
import io.trivial.exception.UserExistException;
import io.trivial.models.entites.Privilege;
import io.trivial.models.entites.Role;
import io.trivial.models.entites.User;
import io.trivial.models.services.UserServiceModel;
import io.trivial.repositories.UserRepository;
import io.trivial.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserServiceModel register(UserServiceModel inUser) throws UserExistException {
        if (this.userRepository.findByEmail(inUser.getEmail()).isPresent()){
            throw new UserExistException("User with this email exist!");
        }
        User userForSave = this.modelMapper.map(inUser, User.class);
        userForSave.setPassword(this.bCryptPasswordEncoder.encode(userForSave.getPassword()));
        this.addRolesToUser(userForSave);
        User savedUser = this.saveUserToDb(userForSave);
        return this.modelMapper.map(savedUser, UserServiceModel.class);
    }

    private void addRolesToUser(User userForSave) {
        Collection<Role> roles = new ArrayList<>();
        if (this.userRepository.count() == 0) {
            Role roleAdmin = new Role();
            roleAdmin.setName(RoleEnum.ADMIN.name());
            this.addPrivilegesToRole(roleAdmin);
            roles.add(roleAdmin);
        } else {
            Role roleUser = new Role();
            roleUser.setName(RoleEnum.USER.name());
            this.addPrivilegesToRole(roleUser);
            roles.add(roleUser);
        }
        userForSave.setRoles(roles);
    }

    private void addPrivilegesToRole(Role role) {
        Collection<Privilege> privileges = new ArrayList<>();
        privileges.add(new Privilege(PrivilegeEnum.READ_PRIVILEGE.name()));
        if(role.getName().equals("ADMIN")) {
            privileges.add(new Privilege(PrivilegeEnum.WRITE_PRIVILEGE.name()));
        }
        role.setPrivileges(privileges);
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
    public UserServiceModel getUserById(String id) throws UserDoesNotExistException {
        User foundedUser = this.userRepository.findById(id).orElse(null);
        if (foundedUser == null){
            throw new UserDoesNotExistException("User with this id does not exist!");
        }
        return this.modelMapper.map(foundedUser, UserServiceModel.class);
    }

    @Override
    public UserServiceModel getUserByEmail(String email) {
        return null;
    }

    private User saveUserToDb(User user) {
        return this.userRepository.saveAndFlush(user);
    }

}
