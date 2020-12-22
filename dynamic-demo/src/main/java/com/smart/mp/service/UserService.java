package com.smart.mp.service;

import com.smart.mp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 分页查询数据
     * @param page
     * @param size
     * @return
     */
    List<User> getUserList(int page,int size);
}
