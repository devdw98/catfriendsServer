package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Chunbae")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chunbae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHUNBAE_ID")
    private Long id;

    @Column(name = "LEVEL")
    private int level; //chunbaeLv

    @Column(name = "STAMINA")
    private int stamina; //staminaDrinkAmount

    @Column(name = "MAX_STAMINA", columnDefinition = "int default 200")
    private int maxStamina;

    @Column(name = "CUR_STAMINA", columnDefinition = "int default 200")
    private int curStamina;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID", unique = true)
    @JsonBackReference
    private User user;

    public Chunbae(User user){
        this.level = 1;
        this.stamina = 0;
        this.maxStamina = 200;
        this.curStamina = 200;
        this.user = user;
    }

    public Chunbae(User user, UserDto dto){
        this.level = dto.getChunbaeLv();
        this.stamina = dto.getStaminaDrinkAmount();
        this.maxStamina = dto.getMaxStamina();
        this.curStamina = dto.getCurStamina();
        this.user = user;
    }

    @Builder
    public Chunbae(int level, int stamina, int maxStamina, int curStamina, User user) {
        this.level = level;
        this.stamina = stamina;
        this.maxStamina = maxStamina;
        this.curStamina = curStamina;
        this.user = user;
    }

    public void update(UserDto dto){
        this.level = dto.getChunbaeLv();
        this.stamina = dto.getStaminaDrinkAmount();
        this.maxStamina = dto.getMaxStamina();
        this.curStamina = dto.getCurStamina();
//        this.user = user;
    }
}
