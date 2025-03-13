package com.example.assignment.service;

import com.example.assignment.model.User;
import com.example.assignment.repository.UserRepo;
import com.example.assignment.securityconfig.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= repo.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("not found");
        return new UserPrincipal(user);
    }
}
