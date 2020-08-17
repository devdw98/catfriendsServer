package com.wtw.catfriendsServer.firebase.fcm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NotificationParameter {
    SOUND("default"),
    COLOR("#FFFF00");

    private String value;
}
