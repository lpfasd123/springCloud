package com.example.cloud.cloudDemo.dao;

import com.example.cloud.cloudDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by liupengfei on 2017/12/30.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
