package com.app.Instagram.services;

import com.app.Instagram.entities.Com;
import com.app.Instagram.repositories.ComRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComService {

    @Autowired
    ComRepository comcrud;


    public void addCom(Com com){
        comcrud.save(com);
    }

    public void deleteCom(Long id){
        comcrud.deleteComById(id);
    }

}
