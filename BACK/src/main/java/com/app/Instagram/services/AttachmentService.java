package com.app.Instagram.services;

import com.app.Instagram.entities.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachement(String fileId) throws Exception;
}
