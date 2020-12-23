package com.wtw.catfriendsServer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class RSPGameDto {
    private int winCount;

    @JsonCreator
    public RSPGameDto(
            @JsonProperty("winCount") int winCount
    ){
        this.winCount = winCount;
    }
}
