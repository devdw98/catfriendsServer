package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.enums.Language;
import com.wtw.catfriendsServer.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Setting")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SETTING_ID")
    private Long id;

    /* 배경음 음량 - default : 50.0*/
    @Column(name = "SOUND_BG", nullable = false, columnDefinition = "float default 50")
    private float soundBg;

    /* 효과음 음량 - default : 50.0*/
    @Column(name = "SOUND_EF", nullable = false, columnDefinition = "float default 50")
    private float soundEf;

    /* 진동 - default : false (off) */
    @Column(name = "VIBRATION", nullable = false)
    private Boolean vibration;

    /* 언어 - default : KOR */
    @Column(name = "LANGUAGE", nullable = false)
    private Language language; //게임 언어 설정

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public Setting (User user){
        this.soundBg = 50;
        this.soundEf = 50;
        this.vibration = false;
        this.language = Language.KOR;
        this.user = user;
    }

    @Builder
    public Setting(float soundBg, float soundEf, Boolean vibration, Language language, User user) {
        this.soundBg = soundBg;
        this.soundEf = soundEf;
        this.vibration = vibration;
        this.language = language;
        this.user = user;
    }

    public void update(UserDto dto){
        this.soundBg = dto.getSoundBgFloat();
        this.soundEf = dto.getSoundEffectFloat();
        this.vibration = dto.getVibration();
        this.language = dto.getLanguage();
    }
}
