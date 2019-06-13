package com.zhangtao.zt.home.web.ui.controller;

import com.zhangtao.zt.home.web.ui.api.ContentApi;
import com.zhangtao.zt.home.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/13 19:49
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        //请求模块数据
        requestContentList(model);
        return "index";
    }

    @RequestMapping(value = "topic/{index}", method = RequestMethod.GET)
    public String topic(@PathVariable(value = "index") Integer index, Model model) {
        requestContentIndex(index, model);
        switch (index) {
            case 1:
                return "personal";
            default:
                return "personal";
        }
    }
    private void requestContentList(Model model) {
        List<TbContent> tbContents = ContentApi.list();
        model.addAttribute("tbContents", tbContents);
    }

    private void requestContentIndex(Integer index, Model model) {
        TbContent tbContent = ContentApi.topic(index);
        model.addAttribute("tbContent", tbContent);
    }
}
