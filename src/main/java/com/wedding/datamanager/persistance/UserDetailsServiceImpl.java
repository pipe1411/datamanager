package com.wedding.datamanager.persistance;

import com.wedding.datamanager.domain.Owner;
import com.wedding.datamanager.domain.User;
import com.wedding.datamanager.repositories.UserRepository;
import com.wedding.datamanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pipe on 8/27/17.
 */

@Service
@Transactional
//UserDetailsImpl
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }


    /*@Override
    public User saveUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findOne(id);
    }*/
}
