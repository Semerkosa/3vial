package io.trivial.service;

import io.trivial.models.view.KeyOrganisationViewModelList;
import org.springframework.security.core.userdetails.UserDetailsService;
import io.trivial.models.service.UserKeyOrganizationServiceModel;
import io.trivial.models.service.UserServiceModel;

public interface UserService extends UserDetailsService {

    UserServiceModel register(UserServiceModel inUser);

    UserServiceModel getUserById(String id);

	UserServiceModel getUserByEmail(String email);

	void addSource(String email, KeyOrganisationViewModelList keyOrganizationList);
}
