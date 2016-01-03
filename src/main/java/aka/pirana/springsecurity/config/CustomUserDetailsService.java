/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.config;

import aka.pirana.springsecurity.entities.User;
import aka.pirana.springsecurity.services.UserService;
import aka.pirana.springsecurity.web.config.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author aka
 */
@Component
public class CustomUserDetailsService   implements UserDetailsService{

    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User user = userService.findUserByEmail(email);
                    System.out.println("aka.pirana.springsecurity.config.CustomUserDetailsService.loadUserByUsername()");
            if(user == null){
                throw new UsernameNotFoundException("user with credentials"+email+"Not found");
            }
            return new SecurityUser(user);
    }
}
