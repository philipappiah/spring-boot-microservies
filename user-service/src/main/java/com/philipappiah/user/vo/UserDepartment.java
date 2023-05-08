package com.philipappiah.user.vo;

import com.philipappiah.user.entity.UserEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartment {

    private UserEntity user;
    private Department department;

    
}
