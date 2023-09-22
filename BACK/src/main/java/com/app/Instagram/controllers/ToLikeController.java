package com.app.Instagram.controllers;

import com.app.Instagram.services.ToLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ToLikeController {

    @Autowired
    ToLikeService likecrud;


    @PostMapping("/api/like/{userid}/{postid}")
    public void addOrremovelike(@PathVariable Long userid,@PathVariable Long postid){
        likecrud.addOrRemoveLike(userid,postid);
    }
}
