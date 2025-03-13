package com.example.assignment.service;

import com.example.assignment.model.User;
import com.example.assignment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtService service;

    public boolean register(User user) {
        User find=userRepo.findByUsername(user.getUsername());
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
        if(find!=null)
            return false;
        else{
            user.setPassword(encoder.encode(user.getPassword()));
            userRepo.save(user);
        }
        return true;
    }

    public String verify(User user) {
        Authentication authentication=manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return service.generate(user.getUsername());
        return "failure";
    }
}
