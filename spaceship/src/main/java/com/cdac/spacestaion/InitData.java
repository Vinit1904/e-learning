package com.cdac.spacestaion;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

	@Autowired
    private SpaceShipRepository spaceShipRepository;

    @PostConstruct
    public void createTestData(){
        spaceShipRepository.deleteAll();
        spaceShipRepository.saveAll(
        		Arrays.asList(
                        new SpaceShip(null, "Falcon", 3, new Captain("Mike", 5)),
                        new SpaceShip(null, "Flying Sourcer", 2, new Captain("Mike", 5) ),
                        new SpaceShip(null, "Fancy Flyer", 2, new Captain("Mike", 5)),
                        new SpaceShip(null, "Blackbird", 33, new Captain("Jens", 3)),
                        new SpaceShip(null, "Huge ship", 12, new Captain("Torben", 4)),
                        new SpaceShip(null, "Eagle", 20, new Captain("Jan", 5)),
                        new SpaceShip(null, "Eager plane", 22, new Captain("Susan", 2)),
                        new SpaceShip(null, "Tweetiebird", 40, new Captain("Helen", 5))
                ));
    }

}
