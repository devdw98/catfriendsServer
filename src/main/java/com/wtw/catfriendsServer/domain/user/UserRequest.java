package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.Request;
import com.wtw.catfriendsServer.domain.enums.RequestType;
import com.wtw.catfriendsServer.dto.RequestTimeDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private RequestType type; //time의 type

    @Column(name = "STATUS")
    private RequestType status; //dict의 타입

    @Column(name = "RECEIVED_TIME")
    private LocalDateTime receivedTime;

    @Column(name = "COMPLETE_TIME")
    private LocalDateTime completeTime;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "REQUEST_ID")
    private Request request;

    @Builder
    public UserRequest(int sibligIdx, int sortingOrder, String str, RequestType type, RequestType status,
                       LocalDateTime receivedTime, LocalDateTime completeTime, User user, Request request) {
        this.sibligIdx = sibligIdx;
        this.sortingOrder = sortingOrder;
        this.str = str;
        this.type = type;
        this.status = status;
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

    public void update(RequestTimeDto dto, RequestType status){
        this.sibligIdx = dto.getSibligIdx();
        this.sortingOrder = dto.getSortingOrder();
        this.str = dto.getStr();
        this.type = dto.getRequestType();
        this.status = status;
        this.receivedTime = dto.getReceivedTime();
        this.completeTime = dto.getCompleteTime();
    }
}
