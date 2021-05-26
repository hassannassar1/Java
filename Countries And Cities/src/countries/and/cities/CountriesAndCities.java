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
            Scanner sc = new Scanner(System.in);
            String code = sc.next();
            System.out.println(map.get(code));
            
  List <String> order = map.get(code).stream().sorted().collect(Collectors.toList());
            
            List<Integer> pop_list = new ArrayList<Integer>();
            countries.forEach(c -> {
            //System.out.println(c.get_population());
            pop_list.add(c.get_population());
        });
            System.out.println("Average "+countries.stream().mapToInt(Country::get_population).average());
            System.out.println("Max "+countries.stream().mapToInt(Country::get_population).max());
            
            
           
           
            System.out.println(cities.get(1).get_population());
        
    }
    
}
