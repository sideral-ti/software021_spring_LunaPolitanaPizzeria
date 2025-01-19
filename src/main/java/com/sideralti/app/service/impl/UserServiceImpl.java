package com.sideralti.app.service.impl;

import com.sideralti.app.mapper.UserMapper;
import com.sideralti.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private UserRepository userRepository;
    private UserMapper userMapper;




}
