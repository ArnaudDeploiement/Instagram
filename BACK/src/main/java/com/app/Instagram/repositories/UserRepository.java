package com.app.Instagram.repositories;

import com.app.Instagram.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);
}
