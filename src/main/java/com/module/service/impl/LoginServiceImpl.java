package com.module.service.impl;

import com.module.entity.blogUser;
import com.module.mapper.LoginMapper;
import com.module.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public blogUser findUser(String username){
        return loginMapper.findUserByUsername(username);
    }
}
