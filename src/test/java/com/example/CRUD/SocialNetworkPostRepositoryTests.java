package com.example.CRUD;

import com.example.CRUD.model.SocialNetworkPost;
import com.example.CRUD.repository.SocialNetworkPostRepository;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class SocialNetworkPostRepositoryTests {

    @Autowired
    private SocialNetworkPostRepository socialNetworkPostRepository;

    @Test
    public void createSocialNetworkPostTest() {
        SocialNetworkPost socialNetworkPost = SocialNetworkPost.builder()
                .author("John Doe")
                .content("My first post")
                .postDate(LocalDate.now())
                .viewCount(1000L)
                .build();

        socialNetworkPostRepository.save(socialNetworkPost);

        Assertions.assertThat(socialNetworkPost.getId()).isGreaterThan(0);
    }

}
