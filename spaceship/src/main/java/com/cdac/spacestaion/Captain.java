package com.cdac.spacestaion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Captain {
    private String name;
    private Integer level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Captain(String name, Integer level) {
		super();
		this.name = name;
		this.level = level;
	}
    
}