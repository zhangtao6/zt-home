package com.zhangtao.zt.home.web.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/14 14:39
 */
@Data
public class TbContentDto implements Serializable {
    private Integer id;
    private String title;
    private String introduction;
    private String picture;
    private String details;
}
