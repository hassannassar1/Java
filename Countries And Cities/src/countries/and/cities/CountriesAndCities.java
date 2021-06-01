/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries.and.cities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author hassan
 */
public class CountriesAndCities {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CityCSVDAO citydao = new CityCSVDAO();
        List <City> cities= citydao.readCitiesFromCSV("Cities.csv");
        
        CountryCSVDAO countrydao = new CountryCSVDAO();
        List <Country> countries= countrydao.readCountriesFromCSV("Countries.csv");
        
        Process process = new Process();
        
        Map<String,List<City>> map = process.createMap(cities);
        process.order(map);
        List<Integer> pop_list = process.createPopulationList(countries);
        
        process.countryAverage(countries);
        process.countryMax(countries);
        process.everyCountryMax(countries, map);
        process.allCapitalsMax(countries, cities);
        

    }

    
}
