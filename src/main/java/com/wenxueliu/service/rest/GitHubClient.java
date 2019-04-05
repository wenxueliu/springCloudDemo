package com.wenxueliu.service.rest;

import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Created by liuwenxue on 05/04/2019.
 */
public interface GitHubClient {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
}
