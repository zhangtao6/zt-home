package com.zhangtao.zt.home.web.admin.service.impl;

import com.zhangtao.zt.home.commons.dto.PageInfo;
import com.zhangtao.zt.home.domain.TbComment;
import com.zhangtao.zt.home.web.admin.dao.TbCommentDao;
import com.zhangtao.zt.home.web.admin.service.TbCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangtao
 * @Description:
 * @ProjectName zt-home
 * @date 2019/6/9 14:53
 */
@Service
@Transactional(readOnly = true)
public class TbCommentServiceImpl implements TbCommentService {

    @Autowired
    private TbCommentDao tbCommentDao;

    @Override
    public TbComment selectTbCommentById(Integer id) {
        return tbCommentDao.selectById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteMulti(String[] idArray) {
        tbCommentDao.deleteMulti(idArray);
    }

    @Override
    public PageInfo<TbComment> page(int start, int length, int draw, TbComment tbComment, String startTime, String endTime) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", start);
        params.put("length", length);
        params.put("tbComment", tbComment);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        int count = tbCommentDao.count(params);
        List<TbComment> page = tbCommentDao.page(params);
        PageInfo<TbComment> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(page);
        pageInfo.setError("");
        return pageInfo;
    }

   /* @Override
    public int count(TbComment tbComment) {
        return tbCommentDao.count(tbComment);
    }*/
}
