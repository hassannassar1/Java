/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

/**
 *
 * @author hassan
 */
public class Stock {
    private String name;
    private double current_price;

    Stock(String name,double current_price){
        this.current_price = current_price;
        this.name = name;
    }
    public float get_price(){
        return (float) this.current_price;
    }
    
    public void set_price(float new_price){
        this.current_price = new_price;
    }
}
