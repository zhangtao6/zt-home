package com.zhangtao.zt.home.web.api.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.io.Serializable;

@Data
public class TbUserDto implements Serializable {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
}
