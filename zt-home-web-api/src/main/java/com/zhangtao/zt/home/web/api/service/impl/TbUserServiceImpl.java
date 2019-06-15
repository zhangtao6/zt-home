package com.zhangtao.zt.home.web.api.service.impl;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.dto.PageInfo;
import com.zhangtao.zt.home.commons.validator.BeanValidator;
import com.zhangtao.zt.home.domain.TbUser;
import com.zhangtao.zt.home.web.api.dao.TbUserDao;
import com.zhangtao.zt.home.web.api.dto.TbUserDto;
import com.zhangtao.zt.home.web.api.service.TbUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @return
     */
    public TbUser login(String username, String password) {
        TbUser tbUser = tbUserDao.selectUserByUsername(username);
        if (tbUser != null) {
            // 明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            // 判断加密后的密码和数据库中存放的密码是否匹配，匹配则表示允许登录
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    /**
     * 注册和保存用户
     *
     * @param tbUser
     */
    @Transactional(readOnly = false)
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        if (validator != null) {
            return BaseResult.fail(validator);
        }else{
            tbUser.setUpdated(new Date());
            //对密码进行加密
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            /**
             * 新增用户
             */
            if (tbUser.getId() == null) {
                TbUser userByUsername = tbUserDao.selectUserByUsername(tbUser.getUsername());

                if(userByUsername == null){ //用户名不存在，可以注册
                    tbUserDao.save(tbUser);
                    TbUserDto tbUserDto = new TbUserDto();
                    BeanUtils.copyProperties(tbUser, tbUserDto);
                    return BaseResult.success("注册成功", tbUserDto);
                }else{ //用户名存在，可以注册
                    return BaseResult.fail("该用户名已存在");
                }

            } else {
                //编辑用户
                tbUserDao.updateTbUser(tbUser);
                TbUserDto tbUserDto = new TbUserDto();
                BeanUtils.copyProperties(tbUser, tbUserDto);
                return BaseResult.success("修改用户信息成功", tbUserDto);
            }
        }


    }

}
