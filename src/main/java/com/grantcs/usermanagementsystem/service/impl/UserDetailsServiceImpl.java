package com.grantcs.usermanagementsystem.service.impl;

import com.grantcs.usermanagementsystem.domain.MUser;
import com.grantcs.usermanagementsystem.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        // Get user information
        MUser loginUser = userService.getLoginUser(userName);

        // If the user does not exist
        if (loginUser == null) {
            throw new UsernameNotFoundException("user not found");
        }

        // create authority list
        var authority = new SimpleGrantedAuthority(loginUser.getRole());
        var authorities = new ArrayList<GrantedAuthority>();
        authorities.add(authority);

        // Generate user details
        var userDetails = (UserDetails)
                new User(
                        loginUser.getUserId(),
                        loginUser.getPassword(),
                        authorities
                );
        return userDetails;
    }
}
