package com.wenxueliu.service.rest;

import com.wenxueliu.model.User;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liuwenxue on 16/03/2019.
 *
 * 服务间调用示例
 *
 * 调用服务 provider :
 * POST /user/add   body User
 * POST /user/update body User
 */

//@FeignClient(name = "provider")
public interface UserClient {
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String addUser(User user);

    @RequestMapping(value = "/user/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody User user);
}
