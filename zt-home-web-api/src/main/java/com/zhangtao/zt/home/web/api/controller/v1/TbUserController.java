package com.zhangtao.zt.home.web.api.controller.v1;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.domain.TbUser;
import com.zhangtao.zt.home.web.api.dto.TbUserDto;
import com.zhangtao.zt.home.web.api.service.TbUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/14 10:44
 */
@RestController
@RequestMapping(value = "${api.path.v1}/user")
public class TbUserController {

    @Autowired
    TbUserService tbUserService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser) {
        TbUser user = tbUserService.login(tbUser.getUsername(), tbUser.getPassword());
        // 登录失败
        if (user == null) {
            return BaseResult.fail("账号或密码错误");
        }// 登录成功
        else {
            TbUserDto dto = new TbUserDto();
            BeanUtils.copyProperties(user, dto);
            return BaseResult.success("成功", dto);
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public BaseResult register(TbUser tbUser) {
        return tbUserService.save(tbUser);
    }
}
