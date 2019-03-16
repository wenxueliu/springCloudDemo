package com.wenxueliu.service;

import com.wenxueliu.config.FeignServiceConfig;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuwenxue on 12/03/2019.
 */
@FeignClient(name = "github-client", url = "https://api.github.com", configuration = FeignServiceConfig.class)
public interface FeignService {

    /**
     * content: {"message":"Validation Failed","errors":[{"resource":"Search","field":"q","code":"missing"}],
     * "documentation_url":"https://developer.github.com/v3/search"}
     * @param queryStr
     * @return
     */
    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    //String searchRepo(@RequestParam("q") String queryStr);
    ResponseEntity<byte[]> searchRepo(@RequestParam("q") String queryStr);

    @RequestMapping(value = "/feign", method = RequestMethod.GET)
    public String helloFeign();

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
