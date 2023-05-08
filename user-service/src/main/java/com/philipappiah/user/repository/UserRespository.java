package com.philipappiah.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philipappiah.user.entity.UserEntity;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, Long> {
 
    UserEntity findByUserId(Long userId);
}
