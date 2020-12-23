package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.enums.RequestType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "REQUEST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Request { //의뢰
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQUEST_ID")
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "STORE")
    private int store; //어느 가게의 의뢰인지 requestDict의 숫자

    @Column(name = "SIBLIG_IDX")
    private int sibligIdx; //이게뭘까..

    @Column(name = "SORTING_ORDER")
    private int sortingOrder;

    @Column(name = "STR")
    private String str;

    @Column(name = "TYPE")
    @Enumerated
    private RequestType type;

    @Column(name = "RECEIVED_TIME")
    private LocalDateTime receivedTime;

    @Column(name = "COMPLETE_TIME")
    private LocalDateTime completeTime;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;
}
