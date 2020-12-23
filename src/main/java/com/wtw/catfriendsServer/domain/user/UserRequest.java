package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.enums.RequestType;
import com.wtw.catfriendsServer.dto.RequestTimeDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER_REQUEST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest { //의뢰
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_REQUEST_ID")
    private Long id;

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

    @OneToOne
    @JoinColumn(name = "REQUEST_ID")
    private Request request;

    @Builder
    public UserRequest(int sibligIdx, int sortingOrder, String str, RequestType type,
                       LocalDateTime receivedTime, LocalDateTime completeTime, User user, Request request) {
        this.sibligIdx = sibligIdx;
        this.sortingOrder = sortingOrder;
        this.str = str;
        this.type = type;
        this.receivedTime = receivedTime;
        this.completeTime = completeTime;
        this.user = user;
        this.request = request;
    }

    public RequestTimeDto toDto(){
        RequestTimeDto dto = RequestTimeDto.builder()
                .sibligIdx(getSibligIdx())
                .sortingOrder(getSortingOrder())
                .str(getStr())
                .requestType(getType())
                .receivedTime(getReceivedTime())
                .completeTime(getCompleteTime())
                .build();
        return dto;
    }
}
