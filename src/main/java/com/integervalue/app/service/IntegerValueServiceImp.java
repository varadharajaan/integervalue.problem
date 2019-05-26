package com.integervalue.app.service;


import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integervalue.app.controller.IntegerValueController;
import com.integervalue.app.dao.IntegerValueDao;
import com.integervalue.app.dto.IntegerValueDTO;
import com.integervalue.app.model.IntegerValue;
import com.integervalue.app.util.ShaHashing;

@Service
@Transactional
public class IntegerValueServiceImp implements IntegerValueService {

	@Autowired
	IntegerValueDao integerValueDao;
	
	private static final Logger logger = LogManager.getLogger(IntegerValueServiceImp.class);
	
	@Override
	public IntegerValue createValue(int value) {
		synchronized (IntegerValue.class) {
			logger.debug("making block synchronixed for object-->"+this.toString());
			IntegerValue integerValue = new IntegerValue();
			integerValue.setValue(value);
			return integerValueDao.save(integerValue);
		}
	}

	@Override
	public IntegerValue incrementValue(IntegerValueDTO value) {
		
		IntegerValue integerValue = integerValueDao.findBy(value.getId());
		
		if(null== integerValue) {
			logger.debug("entity object not found with given value");
			return null;
		}
		synchronized (IntegerValue.class) {
			logger.debug("making block synchronixed for object-->"+this.toString());
			int currentValue = integerValue.getValue();
			currentValue= currentValue+value.getValue();
			integerValue.setValue(currentValue);
			return integerValueDao.save(integerValue);
		}
	}

	@Override
	public IntegerValue decrementValue(IntegerValueDTO value) {
		
		IntegerValue integerValue = integerValueDao.findBy(value.getId());
		
		if(null== integerValue) {
			logger.debug("entity object not found with given value");
			return null;
		}
		synchronized (IntegerValue.class) {
			logger.debug("making block synchronixed for object-->"+this.toString());
			int currentValue = integerValue.getValue();
			currentValue= currentValue-value.getValue();
			integerValue.setValue(currentValue);
			return integerValueDao.save(integerValue);
		}
		
	}

	@Override
	public IntegerValue getCurrentValue(UUID id) {
		synchronized (IntegerValue.class) {
			logger.debug("making block synchronixed for object-->"+this.toString());
		IntegerValue integerValue = integerValueDao.findBy(id);
		
		if(null== integerValue) {
			logger.debug("entity object not found with given value");
			return null;
		}
		return integerValue;
		}
	}

	
	
	

}
