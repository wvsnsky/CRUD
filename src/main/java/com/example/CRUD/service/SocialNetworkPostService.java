package com.example.CRUD.service;

import com.example.CRUD.dto.SocialNetworkPostDTO;
import com.example.CRUD.mapper.SocialNetworkPostMapper;
import com.example.CRUD.model.SocialNetworkPost;
import com.example.CRUD.repository.SocialNetworkPostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocialNetworkPostService {

    private final SocialNetworkPostRepository socialNetworkPostRepository;

    private final SocialNetworkPostMapper socialNetworkPostMapper;


    @Transactional
    public SocialNetworkPostDTO save(SocialNetworkPostDTO socialNetworkPostDTO) {
        return socialNetworkPostMapper.toDto(socialNetworkPostRepository.save(socialNetworkPostMapper.toEntity(socialNetworkPostDTO)));
    }

    public Optional<SocialNetworkPostDTO> findOne(Long id) {
        return socialNetworkPostRepository.findById(id)
                .map(socialNetworkPostMapper::toDto);
    }

    public List<SocialNetworkPostDTO> findAll() {
        return socialNetworkPostRepository.findAll()
                .stream()
                .map(socialNetworkPostMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<SocialNetworkPostDTO> findPostsWithTopViews() {
        return socialNetworkPostRepository.findPostsWithTopViews()
                .stream()
                .map(socialNetworkPostMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        SocialNetworkPost socialNetworkPost = socialNetworkPostRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found social network post with id: " + id + " to delete"));
        socialNetworkPostRepository.delete(socialNetworkPost);
    }
}
