/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries.and.cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.Entry.comparingByValue;
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
        
        Map<String,List<String>> map = new HashMap<>() ;
        cities.forEach(c -> {
            String s = c.get_countryCode();
            if (map.get(s) == null) {
                map.put(s, new ArrayList<String>());
                map.get(s).add(c.get_name());
            }
            else
            {
                map.get(s).add(c.get_name());
            }

        });
        
            System.out.println(map.get("AFG"));
           
            System.out.println(map.get("AFG").stream().sorted().collect(Collectors.toList()));

        
    }
    
}
