package com.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {
    @TableField("id")
    private Long id;

    @TableField("name")
    private String username;

    @TableField("password")
    private String password;
}
