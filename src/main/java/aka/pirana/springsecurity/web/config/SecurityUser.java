/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.web.config;

import aka.pirana.springsecurity.entities.Role;
import aka.pirana.springsecurity.entities.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author aka
 */
public class SecurityUser extends User implements UserDetails{

    public SecurityUser (User user){
        System.out.println("aka.pirana.springsecurity.web.config.SecurityUser.<init>()");
        if (user != null){
            this.setId(user.getId());
            this.setName(user.getName());
            this.setEmail(user.getEmail());
            this.setPassword(user.getPassword());
            this.setDob(user.getDob());
            this.setRoles(user.getRoles());
        }
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("aka.pirana.springsecurity.web.config.SecurityUser.getAuthorities()");
        Collection<GrantedAuthority> authorities= new ArrayList<>();
        Set<Role> userRoles = this.getRoles();
        
        if(userRoles!= null){
            for(Role role : userRoles){
                SimpleGrantedAuthority authority =  new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(authority);
            }
        }
        return authorities;
    }
    @Override
    public String getUsername() {
        System.out.println("aka.pirana.springsecurity.web.config.SecurityUser.getUsername()");
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        System.out.println("aka.pirana.springsecurity.web.config.SecurityUser.getPassword()");
        return super.getPassword(); 
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
