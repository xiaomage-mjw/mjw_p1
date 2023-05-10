package com.i2f.springboot.repository;

import com.i2f.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 10:55 2022/10/28
 */

public interface UserRepository extends JpaRepository<User, Integer> {
    List<Optional<User>> findBySex(String sex);
}
