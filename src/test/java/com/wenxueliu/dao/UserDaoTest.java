package com.wenxueliu.dao;

import com.wenxueliu.domain.UserPo;
import com.wenxueliu.mapper.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by liuwenxue on 02/03/2019.
 */
public class UserDaoTest {
        /*
    private void findUserById(){
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        UserPo user = userMapper.findUserById(1);
        System.out.println(user);
        Assert.assertNotNull("没找到数据", user);

        //增加一条新记录
        UserPo user = new UserPo();
        user.setName("majing");
        user.setPassword("19880101");
        user.setAge(29);
        userMapper.addUser(user);

        //更新该记录
        user.setName("new_majing");
        userMapper.updateUser(user);


        //查询该记录
        int id = user.getId();
        user = null;
        user = userMapper.findUserById(id);
        System.out.println("更新后记录为："+user);

        //删除记录
        System.out.println("尝试删除该记录...");
        userMapper.deleteUser(id);

        user = userMapper.findUserById(id);
        if(user==null){
            System.out.println("该记录已删除！");
        }else{
            System.out.println("该记录未被成功删除！");
        }
    }
        */

    // Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
        /*
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
        */
}
