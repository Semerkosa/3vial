package io.trivial.service.impl;

import io.trivial.enums.PrivilegeEnum;
import io.trivial.enums.RoleEnum;
import io.trivial.models.entites.Privilege;
import io.trivial.models.entites.Role;
import io.trivial.models.entites.User;
import io.trivial.models.services.UserServiceModel;
import io.trivial.repositories.UserRepository;
import io.trivial.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserServiceModel register(UserServiceModel inUser) {
        System.out.println("Register method!");
        User userForSave = this.modelMapper.map(inUser, User.class);
        this.addRolesToUser(userForSave);
        return null;
    }

    private void addRolesToUser(User userForSave) {
        if (this.userRepository.count() == 0) {
            Role roleAdmin = new Role();
            roleAdmin.setName(RoleEnum.ADMIN.name());
            this.addPrivilegesToRole(roleAdmin);
        } else {
            Role roleUser = new Role();
        }
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
    public UserServiceModel getUserById(String id) {
        return null;
    }

    @Override
    public UserServiceModel getUserByEmail(String email) {
        return null;
    }
}
