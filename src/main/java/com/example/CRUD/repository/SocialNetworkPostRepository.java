package com.example.CRUD.repository;

import com.example.CRUD.model.SocialNetworkPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {

    @Query(value = "SELECT * FROM social_network_post order by view_count desc limit 10", nativeQuery = true)
    List<SocialNetworkPost> findPostsWithTopViews();
}
