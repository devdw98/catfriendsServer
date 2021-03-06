package com.wtw.catfriendsServer.service;



import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.AnimalDto;
import com.wtw.catfriendsServer.dto.CatDogDto;
import com.wtw.catfriendsServer.dto.UserDto;

import java.time.LocalDateTime;
import java.util.List;

public interface FriendService {
    public void initial(User user);

    public void initialClientData(User user, List<CatDogDto> catdogs, List<AnimalDto> animals,
                                  List<LocalDateTime> clickTimes, List<Integer> usedNumOfAnimals, List<Integer> stepOfSells);


        public List<CatDogDto> getCatDogDtos(User user);

    public List<AnimalDto> getAnimalDtos(User user);

    public void storeCatDogs(UserDto dto, User user);

    public void storeAnimals(UserDto dto, User user);

}
