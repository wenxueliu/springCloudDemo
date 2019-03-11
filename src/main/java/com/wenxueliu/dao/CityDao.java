package com.wenxueliu.dao;

import com.wenxueliu.domain.CityPo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * Created by liuwenxue on 02/03/2019.
 */
@Component
public class CityDao {
    private final SqlSession sqlSession;

    public CityDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public CityPo selectCityById(long id) {
        return this.sqlSession.selectOne("selectCityById", id);
    }
}
