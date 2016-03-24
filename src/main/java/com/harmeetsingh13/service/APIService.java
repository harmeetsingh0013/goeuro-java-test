/**
 * 
 */
package com.harmeetsingh13.service;

import java.util.Optional;

import com.harmeetsingh13.exceptions.NotFound;
import com.harmeetsingh13.utilities.CitiesDetailList;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public interface APIService {

	public Optional<CitiesDetailList> findCitiesDetailByName(String name) throws NotFound;
}
