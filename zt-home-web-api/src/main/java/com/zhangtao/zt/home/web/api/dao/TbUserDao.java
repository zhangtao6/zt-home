package com.zhangtao.zt.home.web.api.dao;

import com.zhangtao.zt.home.commons.persistence.BaseDao;
import com.zhangtao.zt.home.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TbUserDao{

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


    /**
     * 更新数据
     * @param tbUser
     */
    void updateTbUser(TbUser tbUser);



}
