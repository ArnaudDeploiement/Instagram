package com.app.Instagram.controllers;

import com.app.Instagram.entities.Attachment;
import com.app.Instagram.entities.Post;
import com.app.Instagram.entities.User;
import com.app.Instagram.model.ResponseData;
import com.app.Instagram.services.AttachmentService;
import com.app.Instagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService usercrud;
    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/api/user")
    public ResponseData createUser(@RequestParam("file") MultipartFile file, User user ) throws Exception {
        Attachment attachment = null;
        String downloadUrl="";
        attachment = attachmentService.saveAttachment(file);
        downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download").path(attachment.getId()).toUriString();
        usercrud.createUser(user);
        return new ResponseData(attachment.getFileName(),downloadUrl,file.getContentType(), file.getSize());
    }

    @GetMapping("/api/user/{username}")
    public List<User> findByUsername(String username) {
        return usercrud.findUserbyUsername(username);
    }

    @GetMapping("/api/user")
    public List<User> findAll() {
        return usercrud.findAll();
    }
}
