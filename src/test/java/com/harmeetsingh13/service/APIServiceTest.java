/**
 * 
 */
package com.harmeetsingh13.service;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.harmeetsingh13.configuration.UnirestObjectMapper;
import com.harmeetsingh13.exceptions.NotFound;
import com.harmeetsingh13.service.impl.UnirestAPIServiceImpl;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public class APIServiceTest {

	private APIService apiService;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void init() throws NotFound{
		UnirestObjectMapper mapper = new UnirestObjectMapper();
		apiService = new UnirestAPIServiceImpl(mapper);
	}
	
	@Test
	public void testA_CitiesNotFoundException() throws NotFound{
		thrown.expect(NotFound.class);
		thrown.expectMessage("Cities not found");
		thrown.expect(hasProperty("errorCode", is("1002")));
		
		apiService.findCitiesDetailByName("aaabbbccc");
	}
}
