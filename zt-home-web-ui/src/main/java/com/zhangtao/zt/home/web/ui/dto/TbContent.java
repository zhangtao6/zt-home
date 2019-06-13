package com.zhangtao.zt.home.web.ui.dto;

import com.zhangtao.zt.home.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * @author zhangtao
 * @Description: 分类管理
 * @ProjectName zt-home
 * @date 2019/6/7 15:05
 */
@Data
public class TbContent extends BaseEntity {
    private String title;
    private String introduction;
    private String picture;
    private String details;
}
