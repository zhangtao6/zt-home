package com.zhangtao.zt.home.web.api.service;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.persistence.BaseService;
import com.zhangtao.zt.home.domain.TbUser;

import java.util.List;


public interface TbUserService {


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
     * 根据id查询
     * @param id
     * @return
     */
    TbUser getById(Integer id);




}
