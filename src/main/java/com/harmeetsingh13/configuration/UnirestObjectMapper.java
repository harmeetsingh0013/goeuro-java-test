/**
 * 
 */
package com.harmeetsingh13.configuration;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public class UnirestObjectMapper implements ObjectMapper{

	private com.fasterxml.jackson.databind.ObjectMapper jacksonMapper = new com.fasterxml.jackson.databind.ObjectMapper();
	
	@Override
	public <T> T readValue(String value, Class<T> valueType) {
		try {
            return jacksonMapper.readValue(value, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public String writeValue(Object value) {
		try {
            return jacksonMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
	}

}
