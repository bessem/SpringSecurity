/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.services;

import aka.pirana.springsecurity.dao.JpaUserDaoImpl;
import aka.pirana.springsecurity.entities.User;
import aka.pirana.springsecurity.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aka
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
     */
    public List<User> findAll() {
        //return userDao.findAll();
        return userRepository.findAll();
    }

    public User create(User user) {
        //return userDao.create(user);
        return userRepository.save(user);
    }

    public User findUserById(int id) {
        //return userDao.findUserById(id);
        return userRepository.findOne(id);
    }

    public User login(String email, String password) {
        //return userDao.login(email,password);
        //return userRepository.login(email,password);
        System.out.println("aka.pirana.springsecurity.services.UserService.login()");
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    public User findUserByEmail(String email) {
      /*  JpaUserDaoImpl imp = new JpaUserDaoImpl();
        List<User> usrs = new ArrayList<>();
        User user  = new User();
        usrs = imp.findAll();
        System.out.println("");
        for(User usr : usrs){
            if( usr.getEmail().equals(email)){
                user = usr;
                return user;
            }
        }*/
        return userRepository.findUserByEmail(email);
    }

}
