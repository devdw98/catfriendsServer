package com.wtw.catfriendsServer.domain.user.pc;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PC_CLICK_TIME")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PcClickTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PC_CLICK_ID")
    private Long id;

    @Column(name = "TIME1")
    private LocalDateTime time1;

    @Column(name = "TIME2")
    private LocalDateTime time2;

    @Column(name = "TIME3")
    private LocalDateTime time3;

    @Column(name = "TIME4")
    private LocalDateTime time4;

    @Column(name = "TIME5")
    private LocalDateTime time5;

    @Column(name = "TIME6")
    private LocalDateTime time6;

    @Column(name = "TIME7")
    private LocalDateTime time7;

    @Column(name = "TIME8")
    private LocalDateTime time8;

    @Column(name = "TIME9")
    private LocalDateTime time9;

    @Column(name = "TIME10")
    private LocalDateTime time10;

    @Column(name = "TIME11")
    private LocalDateTime time11;

    @Column(name = "TIME12")
    private LocalDateTime time12;

    @Column(name = "TIME13")
    private LocalDateTime time13;

    @Column(name = "TIME14")
    private LocalDateTime time14;

    @Column(name = "TIME15")
    private LocalDateTime time15;

    @Column(name = "TIME16")
    private LocalDateTime time16;

    @Column(name = "TIME17")
    private LocalDateTime time17;

    @Column(name = "TIME18")
    private LocalDateTime time18;

    @Column(name = "TIME19")
    private LocalDateTime time19;

    @Column(name = "TIME20")
    private LocalDateTime time20;

    @OneToOne
    @JoinColumn(name = "PC_ID")
    @JsonBackReference
    private ProtectCenter pc;

    @Builder

    public PcClickTime(LocalDateTime time1, LocalDateTime time2, LocalDateTime time3, LocalDateTime time4,
                       LocalDateTime time5, LocalDateTime time6, LocalDateTime time7, LocalDateTime time8,
                       LocalDateTime time9, LocalDateTime time10, LocalDateTime time11, LocalDateTime time12,
                       LocalDateTime time13, LocalDateTime time14, LocalDateTime time15, LocalDateTime time16,
                       LocalDateTime time17, LocalDateTime time18, LocalDateTime time19, LocalDateTime time20,
                       ProtectCenter pc) {
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.time4 = time4;
        this.time5 = time5;
        this.time6 = time6;
        this.time7 = time7;
        this.time8 = time8;
        this.time9 = time9;
        this.time10 = time10;
        this.time11 = time11;
        this.time12 = time12;
        this.time13 = time13;
        this.time14 = time14;
        this.time15 = time15;
        this.time16 = time16;
        this.time17 = time17;
        this.time18 = time18;
        this.time19 = time19;
        this.time20 = time20;
        this.pc = pc;
    }

    public List<LocalDateTime> toList(){
        List<LocalDateTime> list = new ArrayList<>();
        list.add(getTime1());
        list.add(getTime2());
        list.add(getTime3());
        list.add(getTime4());
        list.add(getTime5());
        list.add(getTime6());
        list.add(getTime7());
        list.add(getTime8());
        list.add(getTime9());
        list.add(getTime10());
        list.add(getTime11());
        list.add(getTime12());
        list.add(getTime13());
        list.add(getTime14());
        list.add(getTime15());
        list.add(getTime16());
        list.add(getTime17());
        list.add(getTime18());
        list.add(getTime19());
        list.add(getTime20());
        return list;
    }
}
