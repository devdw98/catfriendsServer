//package com.example.demo.domain;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "USER_QUEST_INFO")
//@Getter
//@NoArgsConstructor//(access = AccessLevel.PROTECTED)
//public class UserQuestInfo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "USER_QUEST_INFO_ID")
//    private Long id;
//
//    @Column(name = "ATTAIN")
//    private Long attain; //달성량
//
//    @Column(name = "IS_COMPLETE")
//    private Boolean isComplete;
//
//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name = "USER_ID")
//    private User user;
//
//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name = "QUEST_INFO_ID")
//    private QuestInfo questInfo;
//}
