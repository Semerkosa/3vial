package io.trivial.service.impl;

import com.google.gson.Gson;
import io.trivial.enums.PrivilegeEnum;
import io.trivial.enums.RoleEnum;
import io.trivial.models.entites.KeyOrganization;
import io.trivial.models.entites.Privilege;
import io.trivial.models.entites.User;
import io.trivial.models.service.UserKeyOrganizationServiceModel;
import io.trivial.models.service.KeyOrganizationServiceModel;
import io.trivial.models.service.UserServiceModel;
import io.trivial.repositories.PrivilegeRepository;
import io.trivial.repositories.RoleRepository;
import io.trivial.repositories.UserRepository;
import io.trivial.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Gson gson;
    private final PrivilegeRepository privilegeRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           Gson gson, PrivilegeRepository privilegeRepository, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.gson = gson;
        this.privilegeRepository = privilegeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = this.userRepository.findUserByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User with this email is not found in the database");
        }
        User user = optionalUser.get();
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }


    @Override
    public UserServiceModel register(UserServiceModel inUser) {
        User userForSave = this.modelMapper.map(inUser, User.class);
        userForSave.setPassword(this.bCryptPasswordEncoder.encode(inUser.getPassword()));
        //userForSave.setKeysOrganization(new ArrayList<KeyOrganization>());
        this.setRoleAndPrivilege(userForSave);
        User savedUser = this.saveUserToDb(userForSave);
        return this.modelMapper.map(savedUser, UserServiceModel.class);
    }

    @Override
    @Transactional
    public UserServiceModel getUserById(String id) {
        User foundedUser = this.userRepository.findById(id).orElse(null);
        //TODO Does the user exist?
        return this.modelMapper.map(foundedUser, UserServiceModel.class);
    }

    @Override
    @Transactional
    public UserServiceModel getUserByEmail(String email) {
        User foundedUser = this.userRepository.findUserByEmail(email).orElse(null);
        //TODO Does the user exist?
        return this.modelMapper.map(foundedUser, UserServiceModel.class);
    }

    @Override
    public UserKeyOrganizationServiceModel addSource(String email, String sourceJson) {

        User foundedUser = this.userRepository.findUserByEmail(email).orElse(null);

        //TODO Add check if the user exists
        System.out.println(sourceJson);
        System.out.println("=====");


        UserKeyOrganizationServiceModel listSources = gson
                .fromJson(sourceJson, UserKeyOrganizationServiceModel.class);
        for(KeyOrganizationServiceModel keyOrg: listSources.getKeysOrganization()) {

        }
        List<KeyOrganization> sourceEntities =
                modelMapper.map(listSources.getKeysOrganization(),
                        new TypeToken<List<KeyOrganization>>() {
                        }.getType());

//        foundedUser.setKeysOrganization(sourceEntities);
//
//        userRepository.save(foundedUser);

        return listSources;
    }

    /* PRIVATE METHODS */

    private User saveUserToDb(User user) {
        return this.userRepository.saveAndFlush(user);
    }

    private void setRoleAndPrivilege(User userForSave) {
        if (this.userRepository.count() == 0) {
            userForSave.setRole(RoleEnum.ADMIN.name());
            userForSave.setPrivilege(PrivilegeEnum.SUPER_ADMIN.name());
        }
    }

    @Deprecated
    private Privilege getFreeUserPrivilege() {
        return this.privilegeRepository
                .findAll()
                .stream()
                .filter(pr -> pr.getName().equals("FREE_USER")).findFirst()
                .orElse(null);
    }
}
