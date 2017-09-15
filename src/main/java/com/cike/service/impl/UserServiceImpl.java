package com.cike.service.impl;

import com.cike.dao.UserRepository;
import com.cike.entity.User;
import com.cike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 14:30
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findOne(id);
    }
}
