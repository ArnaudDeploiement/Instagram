package com.app.Instagram.services;

import com.app.Instagram.entities.Attachment;
import com.app.Instagram.repositories.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new Exception("Ficher invalide" + fileName);
            }
            Attachment attachment = new Attachment(fileName,
                    file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);
        } catch (Exception e) {
            throw new Exception("Fichier introuvable " +fileName);
        }
    }

    @Override
    public Attachment getAttachement(String fileId) throws Exception {
        return attachmentRepository.findById(fileId).orElseThrow(()-> new Exception("fichier introuvable" + fileId));
    }


}
