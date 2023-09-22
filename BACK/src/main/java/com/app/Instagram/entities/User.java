package com.app.Instagram.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @JsonManagedReference(value = "user-posts")
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Post> posts;

    @JsonManagedReference(value = "user-coms")
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Com> coms;

    @JsonManagedReference(value = "user-tolikes")
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<ToLike> toLikes;

    public User(String username, String password, List<Post> posts, List<Com> coms, List<ToLike> toLikes) {
        this.username = username;
        this.password = password;
        this.posts = posts;
        this.coms = coms;
        this.toLikes = toLikes;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Com> getComs() {
        return coms;
    }

    public void setComs(List<Com> coms) {
        this.coms = coms;
    }

    public List<ToLike> getToLikes() {
        return toLikes;
    }

    public void setToLikes(List<ToLike> toLikes) {
        this.toLikes = toLikes;
    }
}
