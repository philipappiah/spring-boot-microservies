package com.philipappiah.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.philipappiah.user.entity.UserEntity;
import com.philipappiah.user.model.response.ActionResponse;
import com.philipappiah.user.repository.UserRespository;
import com.philipappiah.user.vo.Department;
import com.philipappiah.user.vo.UserDepartment;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private RestTemplate restTemplate;

    public UserEntity saveUser(UserEntity userEntity) {

        return userRespository.save(userEntity);
        
    }

    public List<UserEntity> getUsers() {
        
        return userRespository.findAll();
    }

    public UserEntity findUserById(Long userId) {
        return userRespository.findByUserId(userId);
    }

    public UserEntity updatedUser(Long userId, UserEntity user) throws Exception {
        UserEntity returnedUser = userRespository.findByUserId(userId);

        if(returnedUser == null){
            throw new Exception("User Not Found");
        }

        if(user.getFirstName() != null) returnedUser.setFirstName(user.getFirstName());
        if(user.getLastName() != null) returnedUser.setLastName(user.getLastName());
        if(user.getDepartmentId() != null) returnedUser.setDepartmentId(user.getDepartmentId());


        return userRespository.save(returnedUser);
    }

    public ActionResponse deleteUser(Long userId) {
        ActionResponse actionResponse = new ActionResponse();

        UserEntity returnedUser = userRespository.findByUserId(userId);

        if(returnedUser == null){
          actionResponse.setMessage("No user found with such Id");
          return actionResponse;
        }

        userRespository.delete(returnedUser);
        actionResponse.setMessage("User successfully deleted!");

        return actionResponse;


    }

    public UserDepartment getUserWithDepartment(Long userId) {
        UserDepartment userDepartment = new UserDepartment();
        UserEntity user = userRespository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        
        userDepartment.setUser(user);
        userDepartment.setDepartment(department);
        return userDepartment;
    }
    
}
