package io.trivial.utils;

import io.trivial.enums.PrivilegeEnum;
import io.trivial.enums.RoleEnum;
import io.trivial.models.entites.Privilege;
import io.trivial.models.entites.Role;
import io.trivial.repositories.PrivilegeRepository;
import io.trivial.repositories.RoleRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class Loader implements CommandLineRunner {

    private final PrivilegeRepository privilegeRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public Loader(PrivilegeRepository privilegeRepository, RoleRepository roleRepository) {
        this.privilegeRepository = privilegeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //TODO
    }
}
