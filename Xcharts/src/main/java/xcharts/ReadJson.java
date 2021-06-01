/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcharts;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author hassan
 */
public class ReadJson {
    public List<TitanicPassenger> getPassengersFromJsonFile() throws FileNotFoundException, IOException {
    List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger> ();
    ObjectMapper objectMapper = new ObjectMapper ();
    objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    FileInputStream input = new FileInputStream ("titanic_csv.json");
    //Read JSON file
    allPassengers = objectMapper.readValue (input, new TypeReference<List<TitanicPassenger>> () { });
    return allPassengers;
    }
    
}
