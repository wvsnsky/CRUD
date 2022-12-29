package com.example.CRUD.resource;

import com.example.CRUD.dto.SocialNetworkPostDTO;
import com.example.CRUD.service.SocialNetworkPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SocialNetworkPostResource {

    private static final String ENTITY_NAME = "socialNetworkPost";

    private final SocialNetworkPostService socialNetworkPostService;

    @Value("${application.name}")
    private String applicationName;

    @PostMapping("/social-network-post")
    public ResponseEntity createSocialNetworkPost(@RequestBody SocialNetworkPostDTO socialNetworkPostDTO) {
        return ResponseEntity.ok().body(socialNetworkPostService.save(socialNetworkPostDTO));
    }

    @PutMapping("/social-network-post")
    public ResponseEntity<SocialNetworkPostDTO> updateSocialNetworkPost(@RequestBody SocialNetworkPostDTO socialNetworkPostDTO) {
        log.debug("REST request to update SocialNetworkPost : {}", socialNetworkPostDTO);
        if (socialNetworkPostDTO.getId() == null) {
            throw new RuntimeException("Social network post not found: " + socialNetworkPostDTO);
        }
        SocialNetworkPostDTO result = socialNetworkPostService.save(socialNetworkPostDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, socialNetworkPostDTO.getId().toString()))
                .body(result);
    }

    @GetMapping("/social-network-post")
    public ResponseEntity<List<SocialNetworkPostDTO>> getAllSocialNetworkPosts() {
        log.debug("REST request to get all SocialNetworkPosts");
        List<SocialNetworkPostDTO> socialNetworkPostsList = socialNetworkPostService.findAll();
        return new ResponseEntity<>(socialNetworkPostsList, HttpStatus.OK);
    }

    // an endpoint to expose posts with the highest view count, from the biggest to the lowest, where list size is limited by 10 elements
    // so if there are less than or equal to 10 posts, all of them will be exposed; when more than 10 - only 10 with the biggest views count
    @GetMapping("/social-network-post/top-views")
    public ResponseEntity<List<SocialNetworkPostDTO>> getPostsWithTopViews() {
        log.debug("REST request to get all SocialNetworkPosts");
        List<SocialNetworkPostDTO> socialNetworkPostsWithTopViewsList = socialNetworkPostService.findPostsWithTopViews();
        return new ResponseEntity<>(socialNetworkPostsWithTopViewsList, HttpStatus.OK);
    }

    @GetMapping("/social-network-post/{id}")
    public ResponseEntity<SocialNetworkPostDTO> getSocialNetworkPost(@PathVariable Long id) {
        log.debug("REST request to get SocialNetworkPost with id: ", id);
        Optional<SocialNetworkPostDTO> socialNetworkPostDTO = socialNetworkPostService.findOne(id);
        return ResponseUtil.wrapOrNotFound(socialNetworkPostDTO);
    }

    @DeleteMapping("/social-network-post/{id}")
    public ResponseEntity deleteSocialNetworkPost(@PathVariable Long id) {
        log.debug("REST request to delete SocialNetworkPost with id: ", id);
        try {
            socialNetworkPostService.delete(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException exception) {
            log.debug(exception.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}

