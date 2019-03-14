package com.wenxueliu.controller;

import com.wenxueliu.service.FeignService;
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
    public ResponseEntity<byte[]> searchGithubRepoByStr(@RequestParam("str") String queryStr) {
        return feignService.searchRepo(queryStr);
    }

}
