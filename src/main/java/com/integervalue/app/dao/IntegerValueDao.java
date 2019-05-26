package com.integervalue.app.dao;

import java.util.UUID;

import com.integervalue.app.model.IntegerValue;

public interface IntegerValueDao {

	IntegerValue findBy(UUID id);
	IntegerValue save(IntegerValue integerValue);
	
}
