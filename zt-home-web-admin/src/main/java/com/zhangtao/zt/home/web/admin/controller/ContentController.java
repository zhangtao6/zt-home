package com.zhangtao.zt.home.web.admin.controller;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.domain.TbContent;
import com.zhangtao.zt.home.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zhangtao
 * @Description: 模块管理
 * @ProjectName zt-home
 * @date 2019/6/7 17:14
 */
@Controller
@RequestMapping(value = "content")
public class ContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Integer id) {
        TbContent tbContent = null;
        //id不为空，从数据库中获取
        if (id != null) {
            tbContent = tbContentService.selectTbContentById(id);
        } else {
            tbContent = new TbContent();
        }
        tbContent.setPicture("");
        return tbContent;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContent> tbContentList = tbContentService.selectAll();
        for (TbContent tb :
                tbContentList) {
            tb.setPicture("/static/upload/" + tb.getPicture());
        }
        BaseResult baseResult = new BaseResult();
        baseResult.setData(tbContentList);
        model.addAttribute("baseResult", baseResult);
        return "content_list";
    }


    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String update(TbContent tbContent, Model model) {
        tbContentService.save(tbContent);
        List<TbContent> tbContentList = tbContentService.selectAll();
        BaseResult baseResult = BaseResult.success("信息保存成功！");
        baseResult.setData(tbContentList);
        model.addAttribute("baseResult", baseResult);
        return "content_list";
    }

}
