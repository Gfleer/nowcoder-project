package com.gjh.community.service;

import com.gjh.community.dao.DiscussPostDao;
import com.gjh.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiscussPostService {

    @Resource
    private DiscussPostDao discussPostDao;

    public List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit){
        return discussPostDao.selectDiscussPosts(userId,offset,limit);
    }

    public int selectDiscussPostRows(int userId){
        return discussPostDao.selectDiscussPostRows(userId);
    }


}
