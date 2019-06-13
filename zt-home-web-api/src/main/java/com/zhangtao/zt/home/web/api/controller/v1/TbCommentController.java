package com.zhangtao.zt.home.web.api.controller.v1;

import com.zhangtao.zt.home.domain.TbComment;
import com.zhangtao.zt.home.web.api.service.TbCommentService;
import com.zhangtao.zt.home.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/12 22:14
 */
@RestController
@RequestMapping(value = "${api.path.v1}/comment")
public class TbCommentController {
    @Autowired
    private TbCommentService tbCommentService;

    @RequestMapping(value = "{topic}")
    public List<TbComment> topicComment(@PathVariable(value = "topic") String topic) {
        return null;
    }
}
