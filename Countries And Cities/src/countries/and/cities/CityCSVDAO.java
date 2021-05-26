/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries.and.cities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hassan
 */
public class CityCSVDAO {
    private final List<City> cities;
    private City cite;
    
    public CityCSVDAO (){
        cities = new ArrayList<>();
    }
    public List<City> readCitiesFromCSV (String fileName){
        Read read = new Read();
        List<List<String>> thecities = read.ReadCSVFile(fileName);
        thecities.stream().map(city -> {
            cite = new City( Integer.parseInt(city.get(0)) ,city.get(1), Integer.parseInt(city.get(2)), city.get(3).replaceAll(" ", "") );
            return city;            
        }).forEachOrdered(_item -> {
            cities.add(cite);
        });
        return cities;   
    }
    
    
    
}
