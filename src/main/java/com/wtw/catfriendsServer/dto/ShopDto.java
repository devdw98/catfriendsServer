package com.wtw.catfriendsServer.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShopDto {
    private List<Boolean> isBuyLP;
    private List<String> ads;
    private List<String> period;
    private List<String> daily;
}
