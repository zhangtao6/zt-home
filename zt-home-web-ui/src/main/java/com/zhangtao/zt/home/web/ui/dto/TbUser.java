package com.zhangtao.zt.home.web.ui.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zhangtao.zt.home.commons.persistence.BaseEntity;
import com.zhangtao.zt.home.commons.utils.RegexpUtils;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class TbUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    @JsonIgnore
    private Integer authority = 0;

}
