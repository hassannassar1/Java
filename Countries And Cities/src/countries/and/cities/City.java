/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries.and.cities;

/**
 *
 * @author hassan
 */
public class City {
    
    private int id;
    private String name;
    final private int population;
    private String countryCode;
    
    City( int id ,String name, int population, String countryCode)
    {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }
    public int get_id(){
     return this.id;
    }
    public String get_name(){
        return this.name;
    }
    public String get_countryCode(){
        return this.countryCode;
    }
    public int get_population(){
     return this.population;
    }
    
    
    
}
