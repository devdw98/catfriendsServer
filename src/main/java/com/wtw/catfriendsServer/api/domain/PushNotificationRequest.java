package com.wtw.catfriendsServer.api.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PushNotificationRequest {
    private String title;
    private String message;
    private String topic;
    private String token;
}
