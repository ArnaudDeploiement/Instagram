package com.app.Instagram.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String document;

    private String text;

    @JsonBackReference(value = "user-posts")
    @ManyToOne
    private User user;
    @JsonManagedReference(value = "post-com")
    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<Com> coms;

    @JsonManagedReference(value = "post-like")
    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<ToLike> toLikes;

    public Post() {

    }


    public Post(String document, String text, User user, List<Com> coms, List<ToLike> toLikes) {
        this.document = document;
        this.text = text;
        this.user = user;
        this.coms = coms;
        this.toLikes = toLikes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
