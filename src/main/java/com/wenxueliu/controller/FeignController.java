package com.wenxueliu.controller;

import com.wenxueliu.service.rest.FeignService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liuwenxue on 12/03/2019.
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    // 服务消费者对位提供的服务
    @GetMapping(value = "/search/github")
    //public String searchGithubRepoByStr(@RequestParam("str") String queryStr) {
    public ResponseEntity<byte[]> searchGithubRepoByStr(
            @RequestParam("str")
            @ApiParam(name="搜索字符",value="字符串",required=true)
                    String queryStr) {
        return feignService.searchRepo(queryStr);
    }

    // 服务消费者对位提供的服务
    @GetMapping("/consumer/feign")
    public String findByIdByEurekaServer() {
        return feignService.helloFeign();
    }
}
