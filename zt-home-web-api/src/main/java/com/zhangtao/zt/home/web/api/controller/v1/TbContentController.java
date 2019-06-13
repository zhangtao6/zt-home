package com.zhangtao.zt.home.web.api.controller.v1;

import com.zhangtao.zt.home.domain.TbContent;
import com.zhangtao.zt.home.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/12 21:21
 */
@RestController
@RequestMapping(value = "${api.path.v1}/content")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @RequestMapping(value = "")
    public List<TbContent> list() {
        return tbContentService.selectAll();
    }

    @RequestMapping(value = "{content_index}", method = RequestMethod.GET)
    public TbContent detail(@PathVariable(value = "content_index") Integer id) {
        return tbContentService.selectTbContentById(id);
    }
}
