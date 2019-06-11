package com.zhangtao.zt.home.web.admin.controller;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.dto.PageInfo;
import com.zhangtao.zt.home.domain.TbComment;
import com.zhangtao.zt.home.web.admin.service.TbCommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangtao
 * @Description: 评论控制
 * @ProjectName zt-home
 * @date 2019/6/9 14:54
 */

@Controller
@RequestMapping(value = "comment")
public class CommentController {

    @Autowired
    private TbCommentService tbCommentService;

    @ModelAttribute
    public TbComment getTbCommetn(Integer id) {
        TbComment tbComment = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            tbComment = tbCommentService.selectTbCommentById(id);
            //SimpleDateFormat ssf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            //ssf.format(tbComment.getUpdated());
        } else {
            tbComment = new TbComment();
        }

        return tbComment;
    }

    @RequestMapping(value = "list")
    public String list() {
        return "comment_list";
    }

    /**
     * 删除评论
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST )
    public BaseResult delete(String ids) {
        BaseResult baseResult;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbCommentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除评论成功");
        } else {
            baseResult = BaseResult.fail("删除评论失败");
        }
        return baseResult;
    }


    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "comment_detail";
    }
    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbComment> page(TbComment tbComment, HttpServletRequest request) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        String time = request.getParameter("time");
        //初始化开始时间和结束时间
        String startTime = null;
        String endTime =null;
        if (time != null) {
            //对前端传来的时间进行格式化
            String[] split = time.split("\\D+");
            startTime = split[2] + "-" + split[0] + "-" + split[1];
            endTime = split[5] + "-" + split[3] + "-" + split[4];
        }
        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        //此处默认返回的是-1
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        // 封装 Datatables 需要的结果
        PageInfo<TbComment> pageInfo = tbCommentService.page(start, length, draw, tbComment, startTime, endTime);
        return pageInfo;
    }

}
