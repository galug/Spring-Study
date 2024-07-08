package com.example.demo.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "username")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Member(String loginId, String password, String nickname, Integer age, LocalDateTime joinDate,
                  LocalDateTime updatedAt) {
        this.loginId = loginId;
        this.password = password;
        this.name = nickname;
        this.age = age;
        this.joinDate = joinDate;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", createdAt=" + joinDate +
                ", updatedAt=" + updatedAt +
                '}';
    }
}