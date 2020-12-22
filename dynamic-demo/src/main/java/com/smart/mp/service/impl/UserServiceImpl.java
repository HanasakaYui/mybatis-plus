package com.smart.mp.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.mp.entity.User;
import com.smart.mp.mapper.UserMapper;
import com.smart.mp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Emilia
 * @Since: 2020.11.26 20:35
 */
@Service
@DS("slave")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    @DS("master")
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> getUserList(int page, int size) {
        return userMapper.selectPage(new Page<>(page, size),null).getRecords();
    }
}
