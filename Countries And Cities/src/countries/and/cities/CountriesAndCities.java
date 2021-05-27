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
        
        Map<String,List<City>> map = new HashMap<>() ;
      
        
        cities.forEach(c -> {
            
            String s = c.get_countryCode();
            if (map.get(s) == null) {
                map.put(s, new ArrayList<City>());
                map.get(s).add(c);
            }
            else
            {
                map.get(s).add(c);
            }
        });
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Country Code : ");
        String code = sc.next();
        map.get(code).forEach(c->System.out.print(c.get_name()+"  "));
        System.out.println();
        List <City> order = map.get(code).stream().sorted(Comparator.comparingInt(City::get_population
                                            )).collect(Collectors.toList());
        
        order.forEach(c->System.out.print(c.get_name()+"  "));
        System.out.println();
        
        
        
        
        
        List<Integer> pop_list = new ArrayList<Integer>();
        countries.forEach(c -> {
        pop_list.add(c.get_population());
    });
        
        
        System.out.println("Average "+countries.stream().mapToInt(Country::get_population).average());
        System.out.println();
        System.out.println("Max "+countries.stream().mapToInt(Country::get_population).max());
        
        
        
        countries.forEach(c->{
            try{
            City o;
            List <City> p = map.get(c.get_code()).stream().collect(Collectors.toList());
            o = p.stream().max(Comparator.comparing(City::get_population)).get();
            System.out.println(o.get_name()+" "+o.get_population()+" "+o.get_countryCode());
                    
            }
            catch (Exception e){
            System.out.println(e);
            }
            
        });
        
        List<Integer> capitalId = countries.stream().
        map(Country::get_capital).collect(Collectors.toList());
        final Optional<City> max = cities.stream().filter(c->capitalId.contains(c.get_id())).max(Comparator.comparingInt(City::get_population));
        System.out.println("max = " + max);

    }

    
}
