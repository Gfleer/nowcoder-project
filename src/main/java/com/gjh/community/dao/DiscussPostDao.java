package com.gjh.community.dao;

import com.gjh.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostDao {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //使用了<if>并且只有一个参数需要使用@Param
    int selectDiscussPostRows(@Param("userId") int userId);
}
