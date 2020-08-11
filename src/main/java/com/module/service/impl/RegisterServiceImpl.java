package com.module.service.impl;

import com.module.entity.blogUser;
import com.module.mapper.LoginMapper;
import com.module.mapper.RegisterMapper;
import com.module.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    @Transactional
    public int registerNewUser(blogUser b) {
        blogUser user = loginMapper.findUserByUsername(b.getUsername());
        if (user != null) return 0;
        else return registerMapper.CreateNewUser(b);
    }
}
