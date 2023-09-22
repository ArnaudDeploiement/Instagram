package com.app.Instagram.services;

import com.app.Instagram.entities.User;
import com.app.Instagram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository usercrud;


    public void createUser(User user) {
        usercrud.save(user);
    }

    public List<User> findUserbyUsername(String username) {
      return usercrud.findUserByUsername(username);
    }

    public boolean loginUser(String username, String password) {
        User sUser = usercrud.findUserByUsernameAndPassword(username,password);
        if (sUser == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<User> findAll(){
        return usercrud.findAll();
    }

}
