package com.wtw.catfriendsServer.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SELL_ANIMAL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SellAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SELL_ANIMAL_ID")
    private Long id;

    @Column(name = "SORTING_ORDER")
    private String sortingOrder;

    @Column(name = "NEXT_SORTING_ORDER")
    private String nextSortingOrder;

    @Column(name = "LEVEL")
    private int leve;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String getText;

}
