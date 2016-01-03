/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.web.controllers;

import aka.pirana.springsecurity.entities.User;
import aka.pirana.springsecurity.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author aka
 */
@Controller
@RequestMapping("/rest/users/")
public class UserResource {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> findAll()
	{
            System.out.println("aka.pirana.springsecurity.web.controllers.UserResource.findAll()");
		return userService.findAll();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User findUser(@PathVariable("id") int id) {
            System.out.println("aka.pirana.springsecurity.web.controllers.UserResource.findUser()");
		return userService.findUserById(id);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> createUser(@RequestBody User user) {
            System.out.println("aka.pirana.springsecurity.web.controllers.UserResource.createUser()");
		User savedUser = userService.create(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> updateUser(@RequestBody User user) {
            System.out.println("aka.pirana.springsecurity.web.controllers.UserResource.updateUser()");
		User savedUser = userService.update(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
            System.out.println("aka.pirana.springsecurity.web.controllers.UserResource.deleteUser()");
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
