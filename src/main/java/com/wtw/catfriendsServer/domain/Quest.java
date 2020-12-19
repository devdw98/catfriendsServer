//package com.example.demo.domain;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "Quest")
//@Getter
//@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class Quest {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "QUEST_ID")
//    private Long id;
//
//    @Column(name = "TYPE")
//    @Enumerated
//    private QuestType type; //퀘스트 타입
//
//    @Column(name = "TITLE")
//    private String title; //보미, 의뢰 타이틀
//
//    @Column(name = "CONTENT")
//    private String content; //보미, 의뢰 내용
//
//    @OneToMany(mappedBy = "quest")
//    @JsonManagedReference
//    List<QuestInfo> infos = new ArrayList<>();
//
//    @OneToMany(mappedBy = "quest")
//    @JsonManagedReference
//    List<RewardInfo> rewards = new ArrayList<>();
//
//}
