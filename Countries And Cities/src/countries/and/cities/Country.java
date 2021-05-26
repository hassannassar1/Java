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
public class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
    
    Country( String code ,String name, String continent, double surfaceArea,
                                int population, double gnp, int capital)
    {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
    }
    public int get_population(){
        return this.population;
    }
    public int get_capital(){
       return this.capital;
    }
    
}
