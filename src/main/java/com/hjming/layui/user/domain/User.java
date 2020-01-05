package com.hjming.layui.user.domain;

import lombok.*;

/**
 * @author hjming
 * @version 1.0
 * @date 2020/1/4 17:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String email;
    private String address;
    private Integer sex;
    private String phone;
}
