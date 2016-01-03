/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.dao;

import aka.pirana.springsecurity.entities.User;
import java.util.List;

/**
 *
 * @author aka
 */
public interface UserDao {

    public List<User> findAll();

    public User create(User user);

    public User findUserById(int id);

    public User login(String email, String password);
}
