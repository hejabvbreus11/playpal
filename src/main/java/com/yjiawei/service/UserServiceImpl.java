package com.yjiawei.service;

import com.yjiawei.entity.BaseUser;
import com.yjiawei.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BaseUser> getAllUsers() {
        List<BaseUser> users = userRepository.findAll();
        if (CollectionUtils.isEmpty(users)) return new ArrayList<BaseUser>();
        return users;
    }
}
