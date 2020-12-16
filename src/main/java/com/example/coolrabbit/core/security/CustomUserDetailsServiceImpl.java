package com.example.coolrabbit.core.security;

import com.example.coolrabbit.entity.User;
import com.example.coolrabbit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author geekcattle
 */
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userService.findByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("userName" + userName +"not found");
        }

        return new CustomUser(user.getId(),  user.getEmail(),    user.getPassword(),   user.getAuthorities());
    }
}
