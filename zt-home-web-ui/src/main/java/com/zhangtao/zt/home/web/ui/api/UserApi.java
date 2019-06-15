package com.zhangtao.zt.home.web.ui.api;

import com.zhangtao.zt.home.commons.dto.BaseResult;
import com.zhangtao.zt.home.commons.utils.HttpClientUtils;
import com.zhangtao.zt.home.commons.utils.MapperUtils;
import com.zhangtao.zt.home.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;
import sun.net.www.http.HttpClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/14 10:25
 */
public class UserApi {

    public static TbUser login(TbUser tbUser) {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));
        String post = HttpClientUtils.doPost(API.HOST + API.API_USER_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser resultUser = null;
        try {
            resultUser = MapperUtils.json2pojoByTree(post, "data", TbUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultUser;
    }

    public static String register(TbUser tbUser) {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));
        params.add(new BasicNameValuePair("email", tbUser.getEmail()));
        String post = HttpClientUtils.doPost(API.HOST + API.API_USER_REGISTER, params.toArray(new BasicNameValuePair[params.size()]));
        /*BaseResult baseResult = null;
        try {
            baseResult = MapperUtils.json2pojoByTree(post, "data", TbUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseResult;*/
        return post;
    }
}
