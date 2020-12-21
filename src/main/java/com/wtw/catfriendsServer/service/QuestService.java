package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.QuestDto;

import java.util.Map;

public interface QuestService {
    public void initial(User user);
    public void initialClientData(User user, int questLv, Boolean isQuestConversationEnd, QuestDto dto);
    public Map<String, Object> getQuestInfoDto(User user);
    public void storeQuestInfo(QuestDto dto, User user);
}
