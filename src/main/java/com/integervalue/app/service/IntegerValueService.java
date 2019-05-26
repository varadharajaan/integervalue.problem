package com.integervalue.app.service;

import java.util.UUID;

import com.integervalue.app.dto.IntegerValueDTO;
import com.integervalue.app.model.IntegerValue;

public interface IntegerValueService {
	
	 IntegerValue incrementValue(IntegerValueDTO value);
	 
	 IntegerValue decrementValue (IntegerValueDTO value);
	 
	 IntegerValue getCurrentValue ( UUID id);

	 IntegerValue createValue(int value); 
	
	

}
