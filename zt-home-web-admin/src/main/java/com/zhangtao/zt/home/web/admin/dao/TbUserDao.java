package com.zhangtao.zt.home.web.admin.dao;

import com.zhangtao.zt.home.commons.persistence.BaseDao;
import com.zhangtao.zt.home.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * 根据用户名查询
     */
    List<TbUser> selectUserByUsername(@Param(value = "username") String username);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    TbUser selectById(@Param(value = "id") Integer id);
    /**
     * 增加TbUser
     * @param tbUser
     */
    void save(TbUser tbUser);

   /* *//**
     * 根据id进行删除
     * @param isArray
     *//*
    void deleteTbUserById(String[] isArray);*/

    /**
     * 精确查询
     * @param tbUser
     * @return
     */
    TbUser selectSure(TbUser tbUser);

    /**
     * 更新数据
     * @param tbUser
     */
    void updateTbUser(TbUser tbUser);

    /**
     * 分页查询
     * @param param 需要两个参数，start开始位置，length：每页记录数
     * @return
     */
    /*List<TbUser> page(Map<String, Object> param);*/

    /**
     * 返回查询总数
     * @param tbUser
     * @return
     */
    /*int count(TbUser tbUser);*/

    /**
     * 修改权限
     * @param id
     */
    void updateAuth(@Param(value = "id") Integer id, @Param(value = "auth") Integer auth);
}
