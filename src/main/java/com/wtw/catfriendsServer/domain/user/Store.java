package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.dto.StoreDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Store")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long id;

    @Column(name = "TYPE")
    @Enumerated
    private StoreType type;

    @Column(name = "IS_Open")
    private Boolean isOpen;

    @Column(name = "REMODELING_LV")
    private Integer remodelingLv;

    @Column(name = "CLICK_TIME")
    private LocalDateTime clickTime;

    @Column(name = "CONTENT_1_LV")
    private Integer lv1;

    @Column(name = "CONTENT_2_LV")
    private Integer lv2;

    @Column(name = "CONTENT_3_LV")
    private Integer lv3;

    @Column(name = "CONTENT_4_LV")
    private Integer lv4;

    @Column(name = "CONTENT_1_PROFIT")
    private Float pr1;

    @Column(name = "CONTENT_2_PROFIT")
    private Float pr2;

    @Column(name = "CONTENT_3_PROFIT")
    private Float pr3;

    @Column(name = "CONTENT_4_PROFIT")
    private Float pr4;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USER_ID")
    private User user;

    public Store(StoreType type, Boolean isOpen, User user) {
        this.type = type;
        this.isOpen = isOpen;
        this.user = user;
        remodelingLv = 0;
        lv1 = 1;
        lv2 = 1;
        lv3 = 1;
        lv4 = 1;
        pr1 = 1f;
        pr2 = 1f;
        pr3 = 1f;
        pr4 = 1f;
        clickTime = LocalDateTime.now();
    }

    public void update(StoreDto dto, StoreType type){
        int index = type.ordinal()-1;
        this.isOpen = dto.getIsStoreOpen().get(index);
        this.remodelingLv = dto.getRemodelingLv().get(index);
        this.clickTime = dto.getStoreClickTime().get(index);
        switch (type){
            case CAFE:
                this.lv1 = dto.getCafeFurnitureLv().get(0);
                this.lv2 = dto.getCafeFurnitureLv().get(1);
                this.lv3 = dto.getCafeFurnitureLv().get(2);
                this.lv4 = dto.getCafeFurnitureLv().get(3);
                this.pr1 = dto.getCafeFurnitureProfit().get(0);
                this.pr2 = dto.getCafeFurnitureProfit().get(1);
                this.pr3 = dto.getCafeFurnitureProfit().get(2);
                this.pr4 = dto.getCafeFurnitureProfit().get(3);
                break;
            case CHICKEN:
                this.lv1 = dto.getChickenFurnitureLv().get(0);
                this.lv2 = dto.getChickenFurnitureLv().get(1);
                this.lv3 = dto.getChickenFurnitureLv().get(2);
                this.lv4 = dto.getChickenFurnitureLv().get(3);
                this.pr1 = dto.getChickenFurnitureProfit().get(0);
                this.pr2 = dto.getChickenFurnitureProfit().get(1);
                this.pr3 = dto.getChickenFurnitureProfit().get(2);
                this.pr4 = dto.getChickenFurnitureProfit().get(3);
                break;
            case GOPCHANG:
                this.lv1 = dto.getGopchangFurnitureLv().get(0);
                this.lv2 = dto.getGopchangFurnitureLv().get(1);
                this.lv3 = dto.getGopchangFurnitureLv().get(2);
                this.lv4 = dto.getGopchangFurnitureLv().get(3);
                this.pr1 = dto.getGopchangFurnitureProfit().get(0);
                this.pr2 = dto.getGopchangFurnitureProfit().get(1);
                this.pr3 = dto.getGopchangFurnitureProfit().get(2);
                this.pr4 = dto.getGopchangFurnitureProfit().get(3);
                break;
            case HEALTH:
                this.lv1 = dto.getHealthFurnitureLv().get(0);
                this.lv2 = dto.getHealthFurnitureLv().get(1);
                this.lv3 = dto.getHealthFurnitureLv().get(2);
                this.lv4 = dto.getHealthFurnitureLv().get(3);
                this.pr1 = dto.getHealthFurnitureProfit().get(0);
                this.pr2 = dto.getHealthFurnitureProfit().get(1);
                this.pr3 = dto.getHealthFurnitureProfit().get(2);
                this.pr4 = dto.getHealthFurnitureProfit().get(3);
                break;
            case THEATER:
                this.lv1 = dto.getTheaterFurnitureLv().get(0);
                this.lv2 = dto.getTheaterFurnitureLv().get(1);
                this.lv3 = dto.getTheaterFurnitureLv().get(2);
                this.lv4 = dto.getTheaterFurnitureLv().get(3);
                this.pr1 = dto.getTheaterFurnitureProfit().get(0);
                this.pr2 = dto.getTheaterFurnitureProfit().get(1);
                this.pr3 = dto.getTheaterFurnitureProfit().get(2);
                this.pr4 = dto.getTheaterFurnitureProfit().get(3);
                break;
        }

    }
}
