package com.yjiawei.repository;

import com.yjiawei.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<BaseUser,Integer> {
    List<BaseUser> findAll();
}
