package com.wtw.catfriendsServer.api.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PushNotificationResponse {
    private int status;
    private String message;
}
