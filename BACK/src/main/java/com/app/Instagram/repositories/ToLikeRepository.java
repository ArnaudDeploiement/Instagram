package com.app.Instagram.repositories;

import com.app.Instagram.entities.ToLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToLikeRepository extends JpaRepository<ToLike,Long> {


    ToLike findByUser_IdAndPost_Id(Long userid, Long postid);
}
