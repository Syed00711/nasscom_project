package com.microcare.nasscom_project.security;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microcare.nasscom_project.model.Login;
import com.microcare.nasscom_project.repository.LoginRepository;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository userRepository;


    public MyUserDetailsService() {
        super();
    }

    // API

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {


        try {
            final Login user = userRepository.findById(username).get();
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + username);
            }

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, getAuthorities());
        } catch ( Exception e) {
            throw new RuntimeException(e);
        }
    }
    private Collection<GrantedAuthority> getAuthorities() {
        return getGrantedAuthorities(Arrays.asList("USER"));
    }


    private List<GrantedAuthority> getGrantedAuthorities( List<String> privileges) {
         List<GrantedAuthority> authorities = new ArrayList<>();
        for ( String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
   

}