package com.zhangtao.zt.home.web.admin.abstracts;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.dto.PageInfo;
import com.zhangtao.zt.home.commons.persistence.BaseEntity;
import com.zhangtao.zt.home.commons.persistence.BaseService;
import com.zhangtao.zt.home.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/10 13:37
 */
public abstract class AbstarctBaseController<T extends BaseEntity, S extends BaseService<T>> {
    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;

    /**
     * 跳转列表页
     * @return
     */
    public abstract String list() ;

    /**
     * 跳转用户表单页
     * @return
     */
    public abstract String form();

    /**
     * 保存用户信息
     *
     * @param tbUser
     * @return
     */
    public abstract String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes);


    /**
     * 删除用户信息
     *
     * @param ids
     * @return
     */
    public abstract BaseResult delete(String ids);
    /**
     * 显示用户详情gv
     *
     *
     *
     * @return
     */
    public abstract String detail(TbUser tbUser);

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    public abstract PageInfo<TbUser> page(TbUser tbUser, HttpServletRequest request);

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public String auth() {
        return "user_auth";
    }

    public abstract TbUser searchAuth(TbUser tbUser);

    public abstract BaseResult exchange(Integer id) ;
}
