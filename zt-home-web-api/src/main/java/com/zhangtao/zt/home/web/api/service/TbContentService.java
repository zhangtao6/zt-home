package com.zhangtao.zt.home.web.api.service;

import com.zhangtao.zt.home.domain.TbContent;

import java.util.List;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/7 17:12
 */
public interface TbContentService {

    List<TbContent> selectAll();

    TbContent selectTbContentById(Integer id);

}
