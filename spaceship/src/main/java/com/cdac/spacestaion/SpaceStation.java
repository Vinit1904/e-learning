package com.cdac.spacestaion;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

public class SpaceStation {
    @Id
    private String mikesid;
    private String name;
    private Integer crew;
    @DBRef
    private List<SpaceShip> ships;
	public String getMikesid() {
		return mikesid;
	}
	public void setMikesid(String mikesid) {
		this.mikesid = mikesid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCrew() {
		return crew;
	}
	public void setCrew(Integer crew) {
		this.crew = crew;
	}
	public List<SpaceShip> getShips() {
		return ships;
	}
	public void setShips(List<SpaceShip> ships) {
		this.ships = ships;
	}
	public SpaceStation(String mikesid, String name, Integer crew, List<SpaceShip> ships) {
		super();
		this.mikesid = mikesid;
		this.name = name;
		this.crew = crew;
		this.ships = ships;
	}
    
}