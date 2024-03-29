package com.zhangtao.zt.home.web.admin.service.impl;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.dto.PageInfo;
import com.zhangtao.zt.home.commons.validator.BeanValidator;
import com.zhangtao.zt.home.domain.TbUser;
import com.zhangtao.zt.home.web.admin.dao.TbUserDao;
import com.zhangtao.zt.home.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @return
     */
    public TbUser login(String username, String password) {
        List<TbUser> tbUserList = tbUserDao.selectUserByUsername(username);
        if (tbUserList.size() == 0)
            return null;
        TbUser tbUser = tbUserList.get(0);

        //判断是否是超级用户
        if(tbUser.getAuthority() == 0)
            return null;

        if (tbUser != null) {
            // 明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            // 判断加密后的密码和数据库中存放的密码是否匹配，匹配则表示允许登录
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    /**
     * 得到用户列表
     *
     * @return
     */
    public List<TbUser> getTbUserlist() {
        List<TbUser> tbUserList = tbUserDao.selectUserByUsername("");
        return tbUserList;
    }


    /**
     * 保存用户
     *
     * @param tbUser
     */
    @Transactional(readOnly = false)
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        if (validator != null) {
            return BaseResult.fail(validator);
        }else{
            tbUser.setUpdated(new Date());
            //对密码进行加密
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            /**
             * 新增用户
             */
            if (tbUser.getId() == null) {
                //新增用户
                tbUserDao.save(tbUser);
            } else {
                //编辑用户
                tbUserDao.updateTbUser(tbUser);
            }
            /*baseResult.setMessage("保存信息成功！");*/


            return BaseResult.success("保存用户信息成功");
        }


    }

    /**
     * 根据id删除多个用户
     *
     * @param idArray
     */
    @Transactional(readOnly = false)
    public void deleteMulti(String[] idArray) {
        tbUserDao.deleteTbUserById(idArray);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public TbUser getById(Integer id) {
        return tbUserDao.selectById(id);
    }



    /**
     * 实现分页查询
     * @param start
     * @param length
     * @return
     */
    public PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser) {
        int count = tbUserDao.count(tbUser);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", start);
        params.put("length", length);
        params.put("tbUser", tbUser);
        List<TbUser> page = tbUserDao.page(params);
        PageInfo<TbUser> pageInfo = new PageInfo<TbUser>();
        //下面一个属性都不能够少，否则前端就会出错
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(page);
        pageInfo.setError("");
        return pageInfo;
    }

    /**
     * 获取搜索总数
     * @param tbUser
     * @return
     */
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

    /**
     * 用户权限的搜索
     * @param tbUser
     * @return
     */
    @Override
    public TbUser searchAuth(TbUser tbUser) {
        return tbUserDao.selectSure(tbUser);
    }

    /**
     * 权限设置
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void updateAuth(Integer id) {
        TbUser tbUser = tbUserDao.selectById(id);
        Integer authority = tbUser.getAuthority();
        authority = (authority + 1) % 2;
        tbUserDao.updateAuth(id, authority);
    }


}
