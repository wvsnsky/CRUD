package com.example.CRUD.mapper;

import com.example.CRUD.dto.SocialNetworkPostDTO;
import com.example.CRUD.model.SocialNetworkPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public abstract class SocialNetworkPostMapper implements EntityMapper<SocialNetworkPostDTO, SocialNetworkPost> {

    public abstract SocialNetworkPostDTO toDto(SocialNetworkPost socialNetworkPost);

    public abstract SocialNetworkPost toEntity(SocialNetworkPostDTO socialNetworkPostDTO);

    public SocialNetworkPost fromId(Long id) {
        if (id == null) {
            return null;
        }
        SocialNetworkPost socialNetworkPost = new SocialNetworkPost();
        socialNetworkPost.setId(id);
        return socialNetworkPost;
    }
}
