package com.zhangtao.zt.home.web.ui.api;

import com.zhangtao.zt.home.commons.utils.HttpClientUtils;
import com.zhangtao.zt.home.commons.utils.MapperUtils;
import com.zhangtao.zt.home.web.ui.dto.TbContent;

import java.util.List;

/**
 * @author zhangtao
 * @Description: 请求页面内容的api
 * @ProjectName zt-home
 * @date 2019/6/13 19:43
 */
public class ContentApi {

    public static List<TbContent> list() {
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.HOST + API.API_CONTENT_LIST);
        try {
            tbContents = MapperUtils.json2list(result, TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
    public static TbContent topic(int index) {
        TbContent tbContent = null;
        String result = HttpClientUtils.doGet(API.HOST + API.API_CONTENT_LIST + index);
        try {
            tbContent = MapperUtils.json2pojo(result, TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContent;
    }
}
