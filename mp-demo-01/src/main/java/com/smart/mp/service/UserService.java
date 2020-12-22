package com.smart.mp.service;

import com.smart.mp.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author: Emilia
 * @Since: 2020.11.25 11:23
 */
@Service
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
}
