//package com.example.demo.domain;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "QUEST_INFO")
//@Getter
//@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class QuestInfo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "QUEST_INFO_ID")
//    private Long id;
//
//    @Column(name = "CONTENT")
//    private String content; //내용
//
//    @Column(name = "GOAL")
//    private Long goal; //목표치
//
//    @ManyToOne
//    @JoinColumn(name = "QUEST_ID")
//    @JsonBackReference
//    private Quest quest;
//
//}
