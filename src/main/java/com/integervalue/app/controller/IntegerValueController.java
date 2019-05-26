package com.integervalue.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.integervalue.app.dto.IntegerValueDTO;
import com.integervalue.app.exception.AuthenticationFailedException;
import com.integervalue.app.model.IntegerValue;
import com.integervalue.app.service.IntegerValueService;

@RestController
public class IntegerValueController {

	@Autowired
	IntegerValueService integerValueService;
	
	private static final Logger logger = LogManager.getLogger(IntegerValueController.class);

	@RequestMapping(value = "/values/create", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<IntegerValue> createValue(@RequestParam("values") int value)
			throws NoSuchAlgorithmException, AuthenticationFailedException {
		IntegerValue integerValue = integerValueService.createValue(value);
		logger.debug("request completed successfully");
		return new ResponseEntity<IntegerValue>(integerValue, HttpStatus.OK);
	}

	@RequestMapping(value = "/values/increment", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<IntegerValue> incrementValue(@RequestParam("values") IntegerValueDTO value)
			throws NoSuchAlgorithmException, AuthenticationFailedException {
		IntegerValue integerValue = integerValueService.incrementValue(value);
		logger.debug("request completed successfully");
		return new ResponseEntity<IntegerValue>(integerValue, HttpStatus.OK);
	}

	@RequestMapping(value = "/values/decrement", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<IntegerValue> decrementValue(@RequestParam("value") IntegerValueDTO value)
			throws NoSuchAlgorithmException, AuthenticationFailedException {
		IntegerValue integerValue = integerValueService.decrementValue(value);
		logger.debug("request completed successfully");
		return new ResponseEntity<IntegerValue>(integerValue, HttpStatus.OK);
	}

	@RequestMapping(value = "/values/currentvalue", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<IntegerValue> getCurrentValue(@RequestParam("value") UUID id)
			throws NoSuchAlgorithmException, AuthenticationFailedException {
		IntegerValue integerValue = integerValueService.getCurrentValue(id);
		logger.debug("request completed successfully");
		return new ResponseEntity<IntegerValue>(integerValue, HttpStatus.OK);
	}
}
