package com.zhangtao.zt.home.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangtao
 * @Description: 所有实体类的基类
 * @ProjectName zt-home
 * @date 2019/6/4 22:27
 */
public abstract class BaseEntity implements Serializable {
    private Integer id;
    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
