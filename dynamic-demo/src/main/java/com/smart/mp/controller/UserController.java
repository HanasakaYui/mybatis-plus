package com.smart.mp.controller;

import com.smart.mp.entity.User;
import com.smart.mp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Emilia
 * @Since: 2020.11.26 20:41
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        int count = userService.addUser(user);
        return "添加用户：" + count;
    }

    @GetMapping("/get")
    public String getUsers(int page, int size) {
        List<User> userList = userService.getUserList(page, size);
        userList.forEach(user -> log.info(user.toString()));
        return "查询用户";
    }
}
