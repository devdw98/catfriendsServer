package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USER_COUPON")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_COUPON_ID")
    private Long id;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "IS_USED")
    private Boolean isUsed;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USER_ID")
    private User user;

    public UserCoupon(String number, User user) {
        this.number = number;
        this.isUsed = false;
        this.user = user;
    }
    public void update(Boolean b){
        this.isUsed = b;
    }
}
