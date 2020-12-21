package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.dto.CatDogDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATDOG")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CatDog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATDOG_ID")
    private Long id;

//    @Column(name = "name")
//    private String name;

    @Column(name = "USER_CATDOG_ID")
    private int userCatdogId;

    @Column(name = "LEVEL")
    private int level;

    @Column(name = "IS_RETENTION")
    private Boolean isRetention;

    @Column(name = "BATCH_LOCATION")
    private int batchLocation;
  //  @Enumerated
  //  private StoreType batchLocation;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public CatDog (User user){
        this.user = user;
    //    this.name = name;
        this.level = 1;
        this.isRetention = false;
        this.batchLocation = -1;
    //    this.batchLocation = StoreType.NONE;
    }

    public CatDogDto toDto(){
        CatDogDto dto = CatDogDto.builder()
        //        .name(getName())
                .level(getLevel())
                .isRetention(getIsRetention())
                .batchLocation(getBatchLocation())
                .build();
        return dto;
    }

    @Builder
    public CatDog(int id, int level, Boolean isRetention, int batchLocation, User user) {
    //    this.name = name;
        this.userCatdogId = id;
        this.level = level;
        this.isRetention = isRetention;
        this.batchLocation = batchLocation;
        this.user = user;
    }

    public void update(CatDogDto req){
        this.level = req.getLevel();
        this.isRetention = req.getIsRetention();
        this.batchLocation = req.getBatchLocation();
    }
}
