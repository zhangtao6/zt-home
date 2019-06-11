package com.zhangtao.zt.home.web.admin.controller;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.dto.PageInfo;
import com.zhangtao.zt.home.domain.TbUser;
import com.zhangtao.zt.home.web.admin.abstracts.AbstarctBaseController;
import com.zhangtao.zt.home.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstarctBaseController<TbUser, TbUserService> {

   /* @Autowired
    private TbUserService tbUserService;*/

    @ModelAttribute
    public TbUser getTbUser(Integer id) {
        TbUser tbUser = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            tbUser = service.getById(id);
        } else {
            tbUser = new TbUser();
        }

        return tbUser;
    }

    /**
     * 跳转到用户列表页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        //dataTable自动请求数据了
        /*List<TbUser> tbUserList = tbUserService.getTbUserlist();
        model.addAttribute("tbUserList", tbUserList);*/
        return "user_list";
    }

    /**
     * 跳转用户表单页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    /**
     * 保存用户信息
     *
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbUser);
        System.out.println(baseResult.getStatus());
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            //重定向需要使用RedirectAttributes才能够将数据带过去
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        } else {
            //失败
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }

    }


    /**
     * 删除用户信息
     *
     * @param ids
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
        return baseResult;
    }

    /**
     * 显示用户详情gv
     *
     * @return
     */
    @Override
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(TbUser tbUser) {
        return "user_detail";
    }

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbUser> page(TbUser tbUser, HttpServletRequest request) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        //此处默认返回的是-1
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<TbUser> pageInfo = service.page(start, length, draw, tbUser);

        return pageInfo;
    }

    @Override
    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public String auth() {
        return "user_auth";
    }

    @ResponseBody
    @RequestMapping(value = "searchAuth", method = RequestMethod.GET)
    public TbUser searchAuth(TbUser tbUser) {
        System.out.println(1);
        System.out.println(tbUser);
        return service.searchAuth(tbUser);
    }

    @ResponseBody
    @RequestMapping(value = "exchange", method = RequestMethod.GET)
    public BaseResult exchange(Integer id) {
        System.out.println(id);
        service.updateAuth(id);
        return BaseResult.success("修改成功！");
    }
}
