package com.wtw.catfriendsServer.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "REQUEST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQUEST_ID")
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "STORE")
    private int store; //어느 가게의 의뢰인지 requestDict의 숫자
}
