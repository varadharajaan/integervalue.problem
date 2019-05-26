package com.integervalue.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "IntegerValue", catalog = "Integer_value_db")
public class IntegerValue implements java.io.Serializable {

	private UUID id;
	private int value;
	private Date createAt;
	private Date updatedAt;
	public IntegerValue() {
	}
	
	
	public IntegerValue(UUID id, int value, Date createAt, Date updatedAt) {
		super();
		this.id = id;
		this.value = value;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	@Column(name = "value", nullable = false, length = 50)
	public int getValue() {
		return this.value;
	}
	
	public int setValue(int value) {
		return this.value;
	}

	@Column(name = "CreateAt")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Column(name = "UpdatedAt")
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
