package com.integervalue.app.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

public class IntegerValueDTO {
	@NotNull
	private UUID id;
	@NotNull
	private int value;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	

}
