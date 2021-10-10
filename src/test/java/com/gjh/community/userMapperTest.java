package com.gjh.community;

import com.gjh.community.dao.DiscussPostDao;
import com.gjh.community.dao.UserDao;
import com.gjh.community.entity.DiscussPost;
import com.gjh.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class userMapperTest {

    @Resource
    private UserDao userDao;

    @Resource
    private DiscussPostDao discussPostDao;

    @Test
    public void select(){
        User user = userDao.selectById(2);
        System.out.println(user);
        User user1 = userDao.selectByName("123");
        System.out.println(user1);
        User user2 = userDao.selectByEmail("123@123.com");
        System.out.println(user2);
    }

    @Test
    public void inser(){
        User user = new User();
        user.setUsername("中");
        user.setPassword("123");
        user.setSalt("abc");
        user.setEmail("中@123.com");
        user.setHeaderUrl("https://pic1.zhimg.com/80/v2-c9b14661c24cbac07e6a1a2c9461dfe5_720w.jpg?source=1940ef5c");
        user.setCreateTime(new Date());
        int i = userDao.insetUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void update(){
        int i = userDao.updateStatus(2,1);
        System.out.println(i);
        int i1 = userDao.updateHeader(2,"https://pic2.zhimg.com/80/v2-25b90770cdcbbd707ac8bbb45502649d_720w.jpg?source=1940ef5c");
        System.out.println(i1);
        int i2 = userDao.updatePassword(2,"1234");
        System.out.println(i2);
    }

    @Test
    public void postTest(){
        List<DiscussPost> discussPosts = discussPostDao.selectDiscussPosts(0, 0, 10);
        System.out.println(discussPosts);
        int i = discussPostDao.selectDiscussPostRows(2);
        System.out.println(i);
    }

}
