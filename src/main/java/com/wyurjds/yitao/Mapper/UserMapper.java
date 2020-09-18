package com.wyurjds.yitao.Mapper;


import com.wyurjds.yitao.Entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    /**
     * 添加微信用户
     * @return
     */
    int inserUser(Users user);

    /**
     * 查询用户是否已经存在
     * @param user
     * @return
     */
    Users queryUser(Users user);

    //根据用户id查用户
    Users userIdQueryUser(String wxId);

}
