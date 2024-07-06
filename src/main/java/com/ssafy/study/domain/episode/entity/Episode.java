package com.ssafy.study.domain.episode.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import com.ssafy.study.domain.comment.entity.Comment;
import com.ssafy.study.domain.webtoon.entity.Webtoon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Episode")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id")
    private Long episodeId;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "webtoon_id")
    private Webtoon webtoon;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "view_count")
    private Integer viewCount;


    @OneToMany(mappedBy = "episode")
    private List<Comment> commentList= new ArrayList<>();

    @Builder
    private Episode(Long episodeId, String title, Webtoon webtoon, LocalDateTime createdAt, LocalDateTime updatedAt,
                    Integer viewCount) {
        this.episodeId = episodeId;
        this.title = title;
        this.webtoon = webtoon;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.viewCount = viewCount;
    }

    public Long getEpisodeId() {
        return episodeId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}