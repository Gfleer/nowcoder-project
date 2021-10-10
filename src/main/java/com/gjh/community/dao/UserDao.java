package com.gjh.community.dao;

import com.gjh.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserDao {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insetUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);
}
