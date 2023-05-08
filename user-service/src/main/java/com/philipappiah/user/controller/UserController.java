package com.philipappiah.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philipappiah.user.entity.UserEntity;
import com.philipappiah.user.model.response.ActionResponse;
import com.philipappiah.user.service.UserService;
import com.philipappiah.user.vo.UserDepartment;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity userEntity){

        return userService.saveUser(userEntity);
    }

    @GetMapping
    public List<UserEntity> getUsers(){

        return userService.getUsers();
        
    }


    @GetMapping(path = "/{id}")
    public UserEntity findUserById(@PathVariable("id") Long userId){
        return userService.findUserById(userId);
    }

    @PutMapping(path = "/{id}")
    public UserEntity updatedUser(@PathVariable("id") Long userId, @RequestBody UserEntity user) throws Exception{

        return userService.updatedUser(userId, user);
    }

    @GetMapping(path = "department/{id}")
    public UserDepartment getUserWithDepartment(@PathVariable("id") Long userId){

        return userService.getUserWithDepartment(userId);
    }

    @DeleteMapping(path = "/{id}")
    public ActionResponse deleteUser(@PathVariable("id") Long userId){
        
        return userService.deleteUser(userId);

    }

    
}
