package com.zhangtao.zt.home.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zhangtao.zt.home.commons.persistence.BaseEntity;
import com.zhangtao.zt.home.commons.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
public class TbUser extends BaseEntity {
    @Length(min = 6, max = 20, message = "姓名的长度必须介于6 - 20位之间")
    private String username;
    @JsonIgnore
    @Length(min = 6, max = 20, message = "密码的长度必须介于6 - 20位之间")
    private String password;
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;
    private Integer authority = 0;
/*

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "TbUser{" +
                "id=" + getId() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", updated=" + getUpdated() +
                '}';
    }*/
}
