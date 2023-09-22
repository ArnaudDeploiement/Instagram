package com.app.Instagram.repositories;

import com.app.Instagram.entities.Com;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComRepository extends JpaRepository<Com,Long> {



    Com deleteComById(Long id);
}
