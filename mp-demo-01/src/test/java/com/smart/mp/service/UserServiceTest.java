package com.smart.mp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.mp.entity.User;
import com.smart.mp.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class UserServiceTest {
    @Resource
    UserMapper userMapper;

    /**
     * 添加
     */
    @Test
    void addUser() {
        User user = new User();
        user.setUsername("zs");
        user.setPassword("123456");
        user.setPhone("110");
        user.setEmail("120@163.com");
        int count = userMapper.insert(user);
        log.info(count + "");
    }

    /**
     * 条件查询
     * QueryWrapper
     * LambdaQueryWrapper
     */
    @Test
    void find() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //查询指定列，‘eq’相当于‘where’
        queryWrapper.select(User.COL_USERNAME, User.COL_EMAIL, User.COL_PHONE)
                .eq(User.COL_UID, 1)
                .eq(User.COL_LOCKED, 0);
        User user = userMapper.selectOne(queryWrapper);
        log.info(user.toString());
    }

    /**
     * 分页
     */
    @Test
    void finds() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //查询指定列，‘eq’相当于‘where’
        queryWrapper.eq(User.COL_UID, 1).eq(User.COL_LOCKED, 0);
        //分页
        Page<User> page = new Page<>(1, 10);
        //查询
        Page<User> userPage = userMapper.selectPage(page, queryWrapper);

        userPage.getRecords().forEach(user -> log.info(user.toString()));
    }

    @Test
    void findList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //查询指定列，‘eq’相当于‘where’
        queryWrapper.eq(User.COL_UID, 1).eq(User.COL_LOCKED, 0);
        //分页
        Page<User> page = new Page<>(1, 10);
        //查询
        Page<User> userPage = userMapper.selectPage(page, queryWrapper);

        userPage.getRecords().forEach(user -> log.info(user.toString()));
    }


    @Test
    void findAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // uid > 20 or phone = "123456"
        queryWrapper.gt(User.COL_UID, 20).or().eq(User.COL_PHONE, "123456");
        // uid 在 20~30 之间: between 20 and 30
        queryWrapper.between(User.COL_UID, 20, 30);
        //uid in (...)
        queryWrapper.in(User.COL_UID, 1, 3, 5, 4, 8);
        //或者 集合、数组
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 3, 5, 4, 6, 7);
        queryWrapper.in(User.COL_UID, list);
        // 模糊查询--like、likeLeft、likeRight、notLike
        queryWrapper.like(User.COL_USERNAME, "%a%");
        // and 嵌套
        queryWrapper.and(qw -> qw.eq(User.COL_USERNAME, "123"));
    }

    /**
     *  if () {
     *     userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getUsername, "admin"));
     *  } else {
     *     throw new Exception();
     *  }
     * @throws Exception
     */
    @Test
    void findA() throws Exception {
        Optional.ofNullable(
                // List<User> users = userMapper.selectList(queryWrapper);
                userMapper.selectList(new QueryWrapper<User>()
                        .lambda().eq(User::getUsername, "admin")))
                .orElseThrow(Exception::new);
    }
}