package com.wenxueliu.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;
//import org.apache.ibatis.type.Alias;

/**
 * Created by liuwenxue on 02/03/2019.
 */
//@Accessors(chain = true)
//@Data
@Builder
//@Alias(value="UserPo")
public class UserPo {
    @NonNull
    private int id;
    private String name;
    private String password;
    private int age;
    private int deleteFlag;
}
