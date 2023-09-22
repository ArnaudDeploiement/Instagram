package com.app.Instagram.services;

import com.app.Instagram.entities.Post;
import com.app.Instagram.entities.ToLike;
import com.app.Instagram.entities.User;
import com.app.Instagram.repositories.PostRepository;
import com.app.Instagram.repositories.ToLikeRepository;
import com.app.Instagram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToLikeService {


    @Autowired
    ToLikeRepository tolikecrud;

    @Autowired
    UserRepository usercrud;

    @Autowired
    PostRepository postcrud;

    public void addOrRemoveLike(Long userid, Long postid) {
        ToLike searchLike = tolikecrud.findByUser_IdAndPost_Id(userid, postid);
        User searchUser = usercrud.getReferenceById(userid);
        Post searchPost = postcrud.getReferenceById(postid);
        if (searchLike == null) {
            ToLike like = new ToLike();
            like.setUser(searchUser);
            like.setPost(searchPost);
            tolikecrud.save(like);
        } else {
            tolikecrud.delete(searchLike);
        }
    }
}
