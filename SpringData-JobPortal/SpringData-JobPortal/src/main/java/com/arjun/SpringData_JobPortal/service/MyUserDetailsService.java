package com.arjun.SpringData_JobPortal.service;

import com.arjun.SpringData_JobPortal.model.User;
import com.arjun.SpringData_JobPortal.model.UserPrincipal;

import com.arjun.SpringData_JobPortal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);

        if(user==null){
            System.out.println("User 404!");
            throw new UsernameNotFoundException("User 404!");
        }
        return new UserPrincipal(user);
    }
}
