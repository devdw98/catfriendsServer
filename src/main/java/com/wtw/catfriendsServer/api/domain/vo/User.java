package com.wtw.catfriendsServer.api.domain.vo;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private Long id;
    private String loginInfo; //로그인 정보
    private Integer level; //춘배 레벨
    private Integer hourlySales; //시간 당 매출
    private SimpleDateFormat lastAccessTime; //마지막 접속시간
    private Integer countCatDog; // 냥멍인 수
    private Integer countAnimal; //일반 동물 수
    private Integer money; //총 매출
    private Integer dia; //현금
    private Integer point; //선행포인트
}
