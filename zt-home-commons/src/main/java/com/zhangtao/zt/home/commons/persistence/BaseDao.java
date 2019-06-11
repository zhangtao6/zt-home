package com.zhangtao.zt.home.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * @author zhangtao
 * @Description: 所有数据访问层的基类
 * @ProjectName zt-home
 * @date 2019/6/10 11:45
 */
public interface BaseDao<T extends BaseEntity> {

    /**
     * 根据id进行删除
     * @param isArray
     */
    void deleteTbUserById(String[] isArray);

    /**
     * 分页查询
     * @param param 需要两个参数，start开始位置，length：每页记录数
     * @return
     */
    List<T> page(Map<String, Object> param);

    /**
     * 返回查询总数
     * @param entity
     * @return
     */
    int count(T entity);
}
