/**
 * 
 */
package com.harmeetsingh13.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.harmeetsingh13.configuration.UnirestObjectMapper;
import com.harmeetsingh13.exceptions.NotFound;
import com.harmeetsingh13.service.APIService;
import com.harmeetsingh13.service.impl.UnirestAPIServiceImpl;
import com.harmeetsingh13.utilities.CitiesDetailList;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public class GoEuroApp {

	/**
	 * @param args
	 * @throws NotFound 
	 */
	
	public static void writeCSV(String name, List<String> records) {
		File file = new File(name.replaceAll("\\.", "")+".csv");
		try (PrintWriter writer = new PrintWriter(file)){
			writer.println("_id, name, type, latitude, longitude");
			records.forEach(record -> writer.println(record));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		if(args[0] == null || args[0].isEmpty()){
			System.out.println("Invalid input");
		}
		
		UnirestObjectMapper mapper = new UnirestObjectMapper();
		try{
			APIService service = new UnirestAPIServiceImpl(mapper);
			Optional<CitiesDetailList> optional = service.findCitiesDetailByName(args[0].trim());
			optional.ifPresent(cities -> {
				List<String> records = cities.stream().map(city -> city.toString()).collect(Collectors.toList());
				writeCSV(args[0].trim(), records);
			});
		}catch (NotFound ex){
			System.out.println("Error Code: "+ex.getErrorCode()+ " Message: "+ex.getMessage());
		}
	}

}
