package com.zhangtao.zt.home.web.api.service;

import com.zhangtao.zt.home.commons.dto.PageInfo;
import com.zhangtao.zt.home.domain.TbComment;

/**
 * @author zhangtao
 * @Description:
 * @ProjectName zt-home
 * @date 2019/6/9 14:52
 */
public interface TbCommentService {

    TbComment selectTbCommentById(Integer id);


    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @param tbComment
     * @return
     */
    PageInfo<TbComment> page(int start, int length, int draw, TbComment tbComment, String startTime, String endTime);



}
