package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.dto.NyanNyaLandDto;
import com.wtw.catfriendsServer.dto.RSPGameDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "NYANNYALAND")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NyanNyaLand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NYANNYALAND_ID")
    private Long id;

    @Column(name = "TICKET")
    private int nyanNyaTicket;

    @Column(name = "COIN")
    private int nyanCoin;

    @Column(name = "NYANPAE")
    private int nyangPae;

    @Column(name = "JOKBO")
    private int jokbo;

    @Column(name = "WIN_COUNT")
    private int winCount;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public NyanNyaLand(User user){
        this.winCount = 0;
        this.nyanNyaTicket = 0;
        this.nyanCoin = 0;
        this.user = user;
    }
    public RSPGameDto toRspGameDto(){
        RSPGameDto dto = RSPGameDto.builder()
                .winCount(getWinCount())
                .build();
        return dto;
    }

    public NyanNyaLandDto toNyanNyaDto(){
        NyanNyaLandDto dto = NyanNyaLandDto.builder()
                .coin(getNyanCoin())
                .ticket(getNyanNyaTicket())
                .Nyangpae(getNyangPae())
                .jokbo(getJokbo())
                .build();
        return dto;
    }

    @Builder
    public NyanNyaLand(int winCount, int nyanNyaTicket, int nyanCoin, int nyangPae, int jokbo, User user) {
        this.winCount = winCount;
        this.nyanNyaTicket = nyanNyaTicket;
        this.nyanCoin = nyanCoin;
        this.nyangPae = nyangPae;
        this.jokbo = jokbo;
        this.user = user;
    }

    public void update(RSPGameDto gameDto, NyanNyaLandDto landDto){
        this.winCount = gameDto.getWinCount();
        this.nyanCoin = landDto.getCoin();
        this.nyanNyaTicket = landDto.getTicket();
        this.nyangPae = landDto.getNyangpae();
        this.jokbo = landDto.getJokbo();
    }
}
