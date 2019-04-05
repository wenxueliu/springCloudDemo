package com.wenxueliu.service.impl;

import com.wenxueliu.service.rest.FeignService;
import org.springframework.http.ResponseEntity;

/**
 * Created by liuwenxue on 19/03/2019.
 */
public class FeignServiceFallback implements FeignService {
    @Override
    public ResponseEntity<byte[]> searchRepo(String queryStr) {
        return null;
    }

    @Override
    public String helloFeign() {
        return "timeout error";
    }
}
