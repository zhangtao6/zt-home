package com.zhangtao.zt.home.web.api.dao;

import com.zhangtao.zt.home.domain.TbComment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhangtao
 * @Description:
 * @ProjectName zt-home
 * @date 2019/6/9 14:51
 */
@Repository
public interface TbCommentDao {

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    TbComment selectById(Integer id);


    /**
     * 分页查询
     * @param param 需要两个参数，start开始位置，length：每页记录数
     * @return
     */
    List<TbComment> page(Map<String, Object> param);

    /**
     * 返回查询总数
     * @param params
     *
     * @return
     */
    int count(Map<String, Object> params);
}
