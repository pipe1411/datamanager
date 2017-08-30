package com.wedding.datamanager.services;

import com.wedding.datamanager.domain.Owner;
import com.wedding.datamanager.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by pipe on 8/27/17.
 */

@Component
public interface UserService {
    User saveUser(User user);
    User getUserById(String id);
}
