package com.zhangtao.zt.home.web.admin.controller;

import com.zhangtao.zt.home.domain.TbUser;
import com.zhangtao.zt.home.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;


    /**
     * 跳转登录页面
     *
     * @return
     */
    /*@RequestMapping(value = {"", "login"}, method = RequestMethod.GET)*/
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    /**
     * 登录逻辑
     * @param username
     * @param password
     * @param model
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String Login(@RequestParam(required = true) String username, @RequestParam(required = true)String password, HttpServletRequest httpServletRequest, Model model){
        TbUser tbUser = tbUserService.login(username, password);
        // 登录失败
        if (tbUser == null) {
            model.addAttribute("error", "用户名或密码错误，请重新输入");
            return login();
        }// 登录成功
        else {
            // 将登录信息放入会话
            httpServletRequest.getSession().setAttribute("tbUser", tbUser);
            return "redirect:/main";
        }
    }
}
