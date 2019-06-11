package com.zhangtao.zt.home.web.admin.service;

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
     * 删除用户
     * @param idArray
     */
    void deleteMulti(String[] idArray);

    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @param tbComment
     * @return
     */
    PageInfo<TbComment> page(int start, int length, int draw, TbComment tbComment, String startTime, String endTime);

    /**
     * 查询总量
     * @param params
     * @return
     */
    /*int count(Map<String, Object> params);*/

}
