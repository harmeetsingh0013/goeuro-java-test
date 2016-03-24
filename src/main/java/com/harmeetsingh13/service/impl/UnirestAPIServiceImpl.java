/**
 * 
 */
package com.harmeetsingh13.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import com.harmeetsingh13.exceptions.NotFound;
import com.harmeetsingh13.service.APIService;
import com.harmeetsingh13.utilities.CitiesDetailList;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public class UnirestAPIServiceImpl implements APIService{

	private final Properties properties = new Properties();
	private String apiUrl;
	
	public UnirestAPIServiceImpl(ObjectMapper mapper) throws NotFound{
		Unirest.setObjectMapper(mapper);
		
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("api.properties");
		try {
			properties.load(inputStream);
			this.apiUrl = properties.getProperty("api.url");
		} catch (IOException e) {
			throw new NotFound("1001", "Property file not found");
		}
	}

	@Override
	public Optional<CitiesDetailList> findCitiesDetailByName(String name) throws NotFound {
		
		Optional<CitiesDetailList> option = Optional.empty();
		try {
			HttpResponse<CitiesDetailList> response = Unirest.get(apiUrl).routeParam("city_name", name).asObject(CitiesDetailList.class);
			if(response.getBody() != null && !response.getBody().isEmpty()){
				option = Optional.of(response.getBody());
			}else{
				throw new NotFound("1002", "Cities not found");
			}
			Unirest.shutdown();
		} catch (UnirestException | IOException ex) {
			NotFound notFound = new NotFound("9001", "Internt connection problem");
			notFound.initCause(ex);
			throw notFound;
		}
		return option;
	}
}
