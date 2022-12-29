package com.example.CRUD.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "social_network_post")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialNetworkPost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "author")
    private String author;

    @Column(name = "content")
    private String content;

    @Column(name = "post_date")
    private LocalDate postDate;

    @Column(name = "view_count")
    private Long viewCount;
}
