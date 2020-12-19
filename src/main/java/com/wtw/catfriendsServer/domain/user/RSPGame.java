package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.dto.RSPGameDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Game_RSP")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RSPGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RSP_ID")
    private Long id;

    @Column(name = "WIN_COUNT")
    private int winCount;

    @Column(name = "TICKET")
    private int nyanNyaTicket;

    @Column(name = "COIN")
    private int nyanCoin;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public RSPGame(User user){
        this.winCount = 0;
        this.nyanNyaTicket = 0;
        this.nyanCoin = 0;
        this.user = user;
    }
    public RSPGameDto toDto(){
        RSPGameDto dto = RSPGameDto.builder()
                .winCount(getWinCount())
                .nyanNyaTicket(getNyanNyaTicket())
                .nyanCoin(getNyanCoin())
                .build();
        return dto;
    }

    @Builder
    public RSPGame(int winCount, int nyanNyaTicket, int nyanCoin, User user) {
        this.winCount = winCount;
        this.nyanNyaTicket = nyanNyaTicket;
        this.nyanCoin = nyanCoin;
        this.user = user;
    }

    public void update(RSPGameDto dto){
        this.winCount = dto.getWinCount();
        this.nyanCoin = dto.getNyanCoin();
        this.nyanNyaTicket = dto.getNyanNyaTicket();
    }
}
