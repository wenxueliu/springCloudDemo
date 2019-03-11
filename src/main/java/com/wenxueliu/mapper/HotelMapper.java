package com.wenxueliu.mapper;

import com.wenxueliu.domain.HotelPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liuwenxue on 02/03/2019.
 */
@Mapper
public interface HotelMapper {
    HotelPo selectByCityId(int cityId);
}
