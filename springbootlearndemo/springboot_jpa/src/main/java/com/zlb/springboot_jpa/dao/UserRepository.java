package com.zlb.springboot_jpa.dao;

import com.zlb.springboot_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    void deleteById(Long id);

    @Query(value = "select user_name,password from User",nativeQuery = true)
    List<NameOnly> findName();
}