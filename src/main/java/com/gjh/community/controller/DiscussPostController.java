package com.gjh.community.controller;

import com.gjh.community.entity.DiscussPost;
import com.gjh.community.entity.Page;
import com.gjh.community.entity.User;
import com.gjh.community.service.DiscussPostService;
import com.gjh.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DiscussPostController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String selectDiscussPosts(Model model, Page page){
        page.setPath("/index");
        page.setRows(discussPostService.selectDiscussPostRows(0));
        List<DiscussPost> discussPosts = discussPostService.selectDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> res = new ArrayList<>();
        if (discussPosts != null && discussPosts.size() != 0){
            for (DiscussPost discussPost : discussPosts){
                Map<String,Object> map = new HashMap<>();
                User user = userService.selectById(discussPost.getUserId());
                map.put("post",discussPost);
                map.put("user",user);
                res.add(map);
            }
        }
        model.addAttribute("discussPosts",res);
        return "index-test";
    }
}
