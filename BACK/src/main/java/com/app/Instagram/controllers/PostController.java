package com.app.Instagram.controllers;

import com.app.Instagram.entities.Attachment;
import com.app.Instagram.entities.Post;
import com.app.Instagram.model.ResponseData;
import com.app.Instagram.services.AttachmentService;
import com.app.Instagram.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping
public class PostController {

    @Autowired
    PostService postcrud;
    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/api/post")
    public ResponseData addPost(@RequestParam("file")MultipartFile file,Post post) throws Exception {
        Attachment attachment = null;
        String downloadUrl="";
        attachment = attachmentService.saveAttachment(file);
        downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download").path(attachment.getId()).toUriString();
        postcrud.createPoste(post);
        return new ResponseData(attachment.getFileName(),downloadUrl,file.getContentType(), file.getSize());
    }

    @PostMapping("/api/post/{postid}")
    public void editPost(@PathVariable Long postid, String document, String text) {
        postcrud.editPost(document, text, postid);
    }

    @DeleteMapping("/api/post/{postid}")
    public void deletePost(@PathVariable Long postid) {
        postcrud.deletePost(postid);
    }

    @GetMapping("dl/{fileId}")
    public ResponseEntity<Resource>dowloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachement(fileId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType())).header(HttpHeaders.CONTENT_DISPOSITION,"attachement; filename=\""+ attachment.getFileName()+"\"").body(new ByteArrayResource(attachment.getData()));


    }


}

