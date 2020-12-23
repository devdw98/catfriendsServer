package com.wtw.catfriendsServer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class RSPGameDto {
    private int winCount;
    private int test;
//    private int nyanNyaTicket;
//    private int nyanCoin;

}
