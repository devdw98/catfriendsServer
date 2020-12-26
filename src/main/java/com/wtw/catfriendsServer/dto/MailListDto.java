package com.wtw.catfriendsServer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MailListDto {
    private List<UserMailDto> mailList;

    @JsonCreator
    public MailListDto(
            @JsonProperty("mailList") List<UserMailDto> mailList
    ){
        this.mailList = mailList;
    }
}
