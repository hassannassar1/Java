/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries.and.cities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hassan
 */
public class CountryCSVDAO {
    private final List<Country> countries;
    private Country coun;
    
    public CountryCSVDAO (){
        countries = new ArrayList<>();
    }
    public List<Country> readCountriesFromCSV (String fileName){
        Read read = new Read();
        List<List<String>> thecountries = read.ReadCSVFile(fileName);
        thecountries.stream().map(country -> {
            coun = new Country( country.get(0) ,country.get(1), country.get(2), 
                      Double.parseDouble(country.get(4)), Integer.parseInt(country.get(3))
                    , Double.parseDouble(country.get(5)), Integer.parseInt(country.get(6)) );
            return country;            
        }).forEachOrdered(_item -> {
            countries.add(coun);
        });
        return countries;   
    }
}
