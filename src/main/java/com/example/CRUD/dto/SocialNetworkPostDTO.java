package com.example.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SocialNetworkPostDTO {
    private Long id;
    private String author;
    private String content;
    private LocalDate postDate;
    private Long viewCount;
}
