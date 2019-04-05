package com.wenxueliu.controller;

import com.wenxueliu.service.rest.FileUploadClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liuwenxue on 17/03/2019.
 */
@RestController
@Api(value="文件上传")
@RequestMapping("/feign")
public class FeignUploadController {

    @Autowired
    private FileUploadClient fileUploadClient;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "文件上传", notes = "请选择文件上传" )
    public String imageUpload(@ApiParam(value="文件上传",required = true)  MultipartFile file ) throws Exception{
        return fileUploadClient.fileUpload(file);
    }
}
