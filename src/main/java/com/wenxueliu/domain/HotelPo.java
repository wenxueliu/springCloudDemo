package com.wenxueliu.domain;

import lombok.Builder;
import lombok.Data;
//import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Created by liuwenxue on 02/03/2019.
 */
@Builder
//@Alias(value="UserPo")
public class HotelPo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String state;

    private String country;
}
