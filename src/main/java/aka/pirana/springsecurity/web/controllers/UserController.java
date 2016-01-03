/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.web.controllers;

import aka.pirana.springsecurity.entities.User;
import aka.pirana.springsecurity.services.UserService;
import aka.pirana.springsecurity.web.config.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

/**
 *
 * @author aka
 */
@Controller
public class UserController {

    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        UserController.userService = userService;
    }

    public static User getCurrentUser() {
        System.out.println("aka.pirana.springsecurity.web.controllers.UserController.getCurrentUser()");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User loginUser = userService.findUserByEmail(email);
            return new SecurityUser(loginUser);
        }

        return null;
    }
}
