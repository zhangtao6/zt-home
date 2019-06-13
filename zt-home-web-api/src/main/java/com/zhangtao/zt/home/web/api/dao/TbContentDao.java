package com.zhangtao.zt.home.web.api.dao;

import com.zhangtao.zt.home.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/7 17:12
 */
@Repository
public interface TbContentDao {

    /**
     * 查询所有模块
     * @return
     */
    List<TbContent> selectAll();

    TbContent selectTbContentById(Integer id);

}
