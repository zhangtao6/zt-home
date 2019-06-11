package com.zhangtao.zt.home.commons.persistence;

import com.zhangtao.zt.home.commons.dto.PageInfo;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/10 11:56
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 根据id删除多个对象
     * @param idArray
     */
    void deleteMulti(String[] idArray);

    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总量
     * @param entity
     * @return
     */
    int count(T entity);
}
