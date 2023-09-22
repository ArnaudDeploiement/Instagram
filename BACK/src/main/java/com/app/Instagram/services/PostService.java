package com.app.Instagram.services;

import com.app.Instagram.entities.Post;

import com.app.Instagram.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postcrud;


    public List<Post> findAll() {
        return postcrud.findAll();
    }

    public Post createPoste(Post post) {
        return postcrud.save(post);
    }

    public Post editPost(String document, String text, Long id) {
        Post findpost = postcrud.getReferenceById(id);
        findpost.setDocument(document);
        findpost.setText(text);
        return postcrud.save(findpost);
    }

    public void deletePost(Long id) {
        postcrud.deletePostById(id);
    }

}
