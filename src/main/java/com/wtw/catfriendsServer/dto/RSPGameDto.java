package com.wtw.catfriendsServer.dto;

import com.wtw.catfriendsServer.domain.user.RSPGame;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RSPGameDto {
    private int winCount;
    private int nyanNyaTicket;
    private int nyanCoin;

    public RSPGame toEntity(){
        RSPGame entity = RSPGame.builder()
                .winCount(winCount)
                .nyanNyaTicket(nyanNyaTicket)
                .nyanCoin(nyanCoin)
                .build();
        return entity;
    }
}
