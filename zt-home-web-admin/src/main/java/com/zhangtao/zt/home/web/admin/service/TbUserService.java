package com.zhangtao.zt.home.web.admin.service;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.persistence.BaseService;
import com.zhangtao.zt.home.domain.TbUser;

import java.util.List;


public interface TbUserService extends BaseService<TbUser> {


    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    TbUser login(String username, String password) ;

    /**
     * 获取用户列表
     * @return
     */
    List<TbUser> getTbUserlist();

    /**
     * 保存或者更新用户
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

    /**
     * 删除用户
     * @param idArray
     */
   /* void deleteMulti(String[] idArray);*/

    /**
     * 根据id查询
     * @param id
     * @return
     */
    TbUser getById(Integer id);

    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @param tbUser
     * @return
     */
    /*PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser);*/

    /**
     * 查询总量
     * @param tbUser
     * @return
     */
    /*int count(TbUser tbUser);*/

    TbUser searchAuth(TbUser tbUser);

    void updateAuth(Integer id);
}
