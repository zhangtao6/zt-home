package com.zhangtao.zt.home.web.ui.controller;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.utils.MapperUtils;
import com.zhangtao.zt.home.web.ui.api.UserApi;
import com.zhangtao.zt.home.web.ui.constant.SystemConstants;
import com.zhangtao.zt.home.web.ui.dto.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/14 10:25
 */
@Controller
public class SignController {

    /**
     * 跳转登录注册页
     * @return
     */
    @RequestMapping(value = "sign", method = RequestMethod.GET)
    public String sign() {
        return "sign";
    }

    /**
     * 登录验证
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request) {
        TbUser login = UserApi.login(tbUser);

        if (login != null) {
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY, login);
            return "redirect:/index";
        }
        else {
            BaseResult baseResult = BaseResult.fail("用户名或者密码错误");
            model.addAttribute("baseResultLogin", baseResult);
            return "sign";
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(TbUser tbUser, Model model, HttpServletRequest request) {
        String result = UserApi.register(tbUser);
        TbUser register = null;
        BaseResult baseResult = null;
        try {
            baseResult = MapperUtils.json2pojo(result, BaseResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (baseResult.getStatus() == 500) {
            model.addAttribute("baseResultRegister", baseResult);
            return "sign";
        }else{
            try {
                register = MapperUtils.json2pojoByTree(result, "data", TbUser.class);
                request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY, register);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "redirect:/index";
        }
    }
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

}
