package com.wenxueliu.controller;

import com.wenxueliu.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuwenxue on 12/03/2019.
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    // 服务消费者对位提供的服务
    @GetMapping(value = "/search/github")
    public String searchGithubRepoByStr(@RequestParam("str") String queryStr) {
        return feignService.searchRepo(queryStr);
    }

}
