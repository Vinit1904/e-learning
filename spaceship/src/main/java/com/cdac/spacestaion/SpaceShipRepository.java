package com.cdac.spacestaion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SpaceShipRepository extends MongoRepository<SpaceShip, String> {

    @Query("{'type': {$regex: '^F.*'} }")
    public List<SpaceShip> gimmeShipsStartWithF();

    @Query("{'type': {$regex: '^E.*'} }")
    public List<SpaceShip> gimmeShipsStartWithE();

    @Query(value="{'type': {$regex: '^E.*'} }", delete = true)
    public List<SpaceShip> deleteShipsWithE();
}