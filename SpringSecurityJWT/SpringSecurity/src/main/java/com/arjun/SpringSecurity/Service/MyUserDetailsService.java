package com.arjun.SpringSecurity.Service;

import com.arjun.SpringSecurity.Model.User;
import com.arjun.SpringSecurity.Model.UserPrincipal;
import com.arjun.SpringSecurity.Repository.UserRepo;
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
