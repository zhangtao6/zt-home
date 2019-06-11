package com.zhangtao.zt.home.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author zhangtao
 * @Description:
 * @ProjectName zt-home
 * @date 2019/6/8 14:11
 */
@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/static/upload/";

    /***
     * 文件上传
     * @param dropFile Dropzone的文件上传
     * @param editorFile WangEditor的文件上传
     * @param request
     * @return
     */
    /*@ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropFile, MultipartFile editorFile,  HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        //前端上传的文件
        MultipartFile myFile = dropFile == null ? editorFile : dropFile;

        String fileName = myFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //String filePath = "F:/IDEA/workspace/zt-home/src/main/webapp/static/upload";
        //不懂    为什么获取的路径是target里面的
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //将文件写入目录
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (dropFile != null) { // dropzone上传
            result.put("fileName", file.getName());
        } else { //wangeditor上传
            //request.getScheme()获取协议（http,https)
            //getServerName获取服务器名
            //getServerPort获取端口号
            String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            result.put("errno", 0);
            result.put("data", new String[]{serverPath + UPLOAD_PATH + file.getName()});
        }
        return result;
    }*/
    /**
     * 文件上传
     *
     * @param dropFile   Dropzone
     * @param editorFiles wangEditor
     * @return
     * */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropFile, MultipartFile[] editorFiles, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        // Dropzone 上传
        if (dropFile != null) {
            result.put("fileName", writeFile(dropFile, request));
        }
        //可以传入多张图片
        // wangEditor 上传
        if (editorFiles != null && editorFiles.length > 0) {
            List<String> fileNames = new ArrayList<>();

            for (MultipartFile editorFile : editorFiles) {
                fileNames.add(writeFile(editorFile, request));
            }

            result.put("errno", 0);
            result.put("data", fileNames);
        }

        return result;
    }

    /**
     * 将图片写入指定目录
     *
     * @param multipartFile
     * @param request
     * @return 返回文件完整路径
     */
    private String writeFile(MultipartFile multipartFile, HttpServletRequest request) {
        // 获取文件后缀
        String fileName = multipartFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        // 判断路径是否存在，不存在则创建文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回文件完整路径
        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return serverPath + UPLOAD_PATH + file.getName();
    }

}
