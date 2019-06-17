package com.qfedu.shop.resouce.controller;

import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.util.FileUtil;
import com.qfedu.common.vo.R;
import com.qfedu.shop.resouce.util.OssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 9:36 2019/6/16
 * @ Description：${description}
 */
@RestController
@Api(value = "文件上传",tags = "文件上传功能")
public class ResouceController {

    @Autowired
    private OssUtil ossUtil;


    @PostMapping("/api/resouce/transupload.do")
    @ApiOperation(value = "传统方式上传",notes = "实现传统方式的文件上传功能")
    public R transUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()){
            File dir = FileUtil.createDir(new File(request.getServletContext().getRealPath("/")).getParent(), "shopImg");
            File desFile = new File(dir, FileUtil.reName(file.getOriginalFilename()));
            file.transferTo(desFile);
            return R.setOK("上传成功", ProjectConfig.RESOURCEURL +desFile.getAbsolutePath());
        }else {
            return R.setERROR("请选择上传的图片");
        }
    }

    @PostMapping("/api/resouce/ossupload.do")
    @ApiOperation(value = "oss上传",notes = "oss上传文件")
    public R ossUpload(MultipartFile file,HttpServletRequest request) throws IOException {
        if (!file.isEmpty()){
            String url = ossUtil.uploadByte(FileUtil.reName(file.getOriginalFilename()), file.getBytes());
            return R.setOK("ok",url);
        }else {
            return R.setERROR("请选择上传文件");
        }
    }


}
