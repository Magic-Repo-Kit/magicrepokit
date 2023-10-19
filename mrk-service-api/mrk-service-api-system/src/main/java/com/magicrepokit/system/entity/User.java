package com.magicrepokit.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.magicrepokit.mp.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 */

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "mrk_system_user",autoResultMap = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity  {

    /**
     * 用户编号
     */
    private String code;

    /**
     * 用户平台[0:web,1:app]
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Integer> userType;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String name;

    /**
     * 真名
     */
    private String realName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 岗位id
     */
    private String postId;

    /**
     * 状态:[0:未激活 1:激活 2:禁用]
     */
    private Integer status;
}