package com.cdac.spacestaion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


public class SpaceShip {
    @Id
    private String id;
    private String type;
    private Integer engines;
    private Captain captain;
    
    
	public SpaceShip(String id, String type, Integer engines, Captain captain) {
		super();
		this.id = id;
		this.type = type;
		this.engines = engines;
		this.captain = captain;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getEngines() {
		return engines;
	}
	public void setEngines(Integer engines) {
		this.engines = engines;
	}
	public Captain getCaptain() {
		return captain;
	}
	public void setCaptain(Captain captain) {
		this.captain = captain;
	}
    
    
}
