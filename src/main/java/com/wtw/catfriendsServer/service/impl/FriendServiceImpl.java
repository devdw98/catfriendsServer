package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.domain.user.Animal;
import com.wtw.catfriendsServer.domain.user.CatDog;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.AnimalDto;
import com.wtw.catfriendsServer.dto.CatDogDto;
import com.wtw.catfriendsServer.dto.UserDto;
import com.wtw.catfriendsServer.repository.AnimalRepository;
import com.wtw.catfriendsServer.repository.CatDogRepository;
import com.wtw.catfriendsServer.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {
    private final CatDogRepository catDogRepository;
    private final AnimalRepository animalRepository;

    @Override
    public void initial(User user){
   /*     catDogRepository.save(new CatDog(user, "나비"));
        catDogRepository.save(new CatDog(user,"김영철"));
        catDogRepository.save(new CatDog(user,"반휘혈"));
        catDogRepository.save(new CatDog(user,"최민수"));
        catDogRepository.save(new CatDog(user,"나남훈"));
        catDogRepository.save(new CatDog(user,"강이지"));
        catDogRepository.save(new CatDog(user,"쌍둥이 고양이 형"));
        catDogRepository.save(new CatDog(user,"쌍둥이 고양이 동생"));
        catDogRepository.save(new CatDog(user,"이수민"));
        catDogRepository.save(new CatDog(user,"박진형"));
        catDogRepository.save(new CatDog(user,"남궁필두"));*/

    //    animalRepository.save(new Animal(user, StoreType.CAFE));
    //    animalRepository.save(new Animal(user, StoreType.CHICKEN));
    //    animalRepository.save(new Animal(user, StoreType.GOPCHANG));
    }

    @Override
    public void initialClientData(User user, List<CatDogDto> catdogs, List<AnimalDto> animals) {
        CatDog catdog = null;
        Animal animal = null;
        int i = 0;
        for(CatDogDto d : catdogs){
            System.out.println(d.getBatchLocation());
            catdog = CatDog.builder()
                    .id(i)
                    .level(d.getLevel())
                    .isRetention(d.getIsRetention())
                    .batchLocation(d.getBatchLocation())
                    .user(user)
                    .build();
            catDogRepository.save(catdog);
            i++;
        }
        i = 0;
        for(AnimalDto d : animals){
            animal = Animal.builder()
                    .id(i)
                    .level(d.getLevel())
                    .sortingOrder(d.getSortingOrder())
                    .isRetention(d.getIsRetention())
                    .type(d.getType())
                    .build();
            animalRepository.save(animal);
            i++;
        }
    }

    @Override
    public List<CatDogDto> getCatDogDtos(User user) {
        List<CatDogDto> result = new ArrayList<>();
        List<CatDog> catDogs = catDogRepository.findAllByUser(user);
        for(CatDog c : catDogs){
            result.add(c.toDto());
        }
        return result;
    }

    @Override
    public List<AnimalDto> getAnimalDtos(User user) {
        List<AnimalDto> result = new ArrayList<>();
        List<Animal> animals = animalRepository.findAllByUser(user);
        for(Animal c : animals){
            result.add(c.toDto());
        }
        return result;
    }

    @Override
    public void storeCatDogs(UserDto dto, User user) {
        int i = 0;
        List<CatDogDto> catdogDtos = dto.getCatdog();
        List<CatDog> catdogs = user.getCatDogs();
        for(CatDogDto catDogDto : catdogDtos){
            if(catdogs.get(i).getUserCatdogId() == i){
                catdogs.get(i).update(catDogDto);
                i++;
            }
        }

    }

    @Override
    public void storeAnimals(UserDto dto, User user) {
        int i = 0;
        List<AnimalDto> animalDtos = dto.getAnimal();
        List<Animal> animals = user.getAnimals();
        for(AnimalDto animalDto : animalDtos){
            if(animals.get(i).getUserAnimalId() == i){
                animals.get(i).update(animalDto);
                i++;
            }
        }
    }
}
