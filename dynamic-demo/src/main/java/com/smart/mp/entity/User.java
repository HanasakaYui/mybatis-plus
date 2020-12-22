package com.smart.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @author Emilia
 */
@Data
@TableName(value = "`user`")
public class User {
    /**
     * 用户Id
     */
    @TableId(value = "uid", type = IdType.INPUT)
    private Integer uid;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 手机
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 性别 1 表示男 0 表示女
     */
    @TableField(value = "sex")
    private Boolean sex;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 备注
     */
    @TableField(value = "mark")
    private String mark;

    /**
     * 最后一次登录时间
     */
    @TableField(value = "last_login")
    private Date lastLogin;

    /**
     * 登录ip
     */
    @TableField(value = "login_ip")
    private String loginIp;

    /**
     * 头像图片路径
     */
    @TableField(value = "head")
    private String head;

    /**
     * 注册时间
     */
    @TableField(value = "reg_time")
    private Date regTime;

    /**
     * 账号是否被锁定 1 表示未锁定 0 表示锁定
     */
    @TableField(value = "locked")
    private Boolean locked;

    public static final String COL_UID = "uid";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_PHONE = "phone";

    public static final String COL_SEX = "sex";

    public static final String COL_EMAIL = "email";

    public static final String COL_MARK = "mark";

    public static final String COL_LAST_LOGIN = "last_login";

    public static final String COL_LOGIN_IP = "login_ip";

    public static final String COL_HEAD = "head";

    public static final String COL_REG_TIME = "reg_time";

    public static final String COL_LOCKED = "locked";

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public void test(String str){
        System.out.println(str);
    }
}