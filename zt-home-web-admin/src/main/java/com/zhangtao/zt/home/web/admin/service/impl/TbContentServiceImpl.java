package com.zhangtao.zt.home.web.admin.service.impl;

import com.zhangtao.zt.home.domain.TbContent;
import com.zhangtao.zt.home.web.admin.dao.TbContentDao;
import com.zhangtao.zt.home.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/7 17:12
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public TbContent selectTbContentById(Integer id) {
        return tbContentDao.selectTbContentById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(TbContent tbContent) {
        tbContentDao.save(tbContent);
    }
}
