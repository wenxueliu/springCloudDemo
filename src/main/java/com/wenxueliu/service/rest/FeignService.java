package com.wenxueliu.service.rest;

import com.wenxueliu.config.FeignServiceConfig;
import com.wenxueliu.service.impl.FeignServiceFallback;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuwenxue on 12/03/2019.
 */
//@FeignClient(name = "github-client", url = "https://api.github.com",
//        configuration = FeignServiceConfig.class,
//        fallback = FeignServiceFallback.class)
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


}
