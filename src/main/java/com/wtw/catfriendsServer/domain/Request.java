package com.wtw.catfriendsServer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wtw.catfriendsServer.domain.enums.RequestType;
import com.wtw.catfriendsServer.domain.user.UserRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "request")
    @JsonIgnore
    private List<UserRequest> userRequests;
}
