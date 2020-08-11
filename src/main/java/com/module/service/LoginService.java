package com.module.service;

import com.module.entity.blogUser;

public interface LoginService {

    blogUser findUser(String username);
}
