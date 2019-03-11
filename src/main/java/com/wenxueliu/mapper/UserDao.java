package com.wenxueliu.mapper;

import com.wenxueliu.domain.UserPo;

/**
 * Created by liuwenxue on 02/03/2019.
 */
public interface UserDao {
    /**
     * 查询
     * @param userId
     * @return
     */
    UserPo findUserById (int userId);
    /**
     * 增加
     * @param user
     */
    void addUser(UserPo user);
    /**
     * 删除
     * @param userId
     */
    void deleteUser(int userId);
    /**
     * 更新
     * @param user
     */
    void updateUser(UserPo user);
}
