package com.wenxueliu.service.rest;

import com.wenxueliu.config.FeignMultipartSupportConfig;
import feign.Response;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liuwenxue on 17/03/2019.
 */
//@FeignClient(value = "provider", configuration = FeignMultipartSupportConfig.class)
public interface FileUploadClient {

    /***
     * 1.produces,consumes必填
     * 2.注意区分@RequestPart和RequestParam，不要将
     * @RequestPart(value = "file") 写成@RequestParam(value = "file")
     * @param file
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile/server",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  String fileUpload(@RequestPart(value = "file") MultipartFile file);

    /**
     *
     * feign请求结果是一个图片流，怎么接收
     * 生成图片验证码
     * @param imagekey
     * @return
     */
    @RequestMapping(value = "createImagesCode")
    public Response createImageCode(@RequestParam("imagekey") String imagekey);

}
