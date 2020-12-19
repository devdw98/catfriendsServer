package com.wtw.catfriendsServer.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class StoreDto {
    private List<Integer> remodelingLv;
    private List<Boolean> isStoreOpen;
    private List<Integer> cafeFurnitureLv;
    private List<Integer> chickenFurnitureLv;
    private List<Integer> gopchangFurnitureLv;
    private List<Integer> healthFurnitureLv;
    private List<Integer> theaterFurnitureLv;
    private List<Float> cafeFurnitureProfit;
    private List<Float> chickenFurnitureProfit;
    private List<Float> gopchangFurnitureProfit;
    private List<Float> healthFurnitureProfit;
    private List<Float> theaterFurnitureProfit;
    private List<LocalDateTime> storeClickTime;
}
