//package com.example.demo.domain;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "USER_QUEST")
//@Getter
//@NoArgsConstructor//(access = AccessLevel.PROTECTED)
//public class UserQuest {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "USER_QUEST_ID")
//    private Long id;
//
//    @Column(name = "QUEST_STATUS")
//    @Enumerated
//    private QuestState status;
//
//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name = "USER_ID")
//    private User user;
//
//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name = "QUEST_ID")
//    private Quest quest;
//}
