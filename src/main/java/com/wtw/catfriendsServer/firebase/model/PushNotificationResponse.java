package com.wtw.catfriendsServer.firebase.model;

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
