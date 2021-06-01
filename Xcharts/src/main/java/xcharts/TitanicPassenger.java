/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcharts;

/**
 *
 * @author hassan
 */
public class TitanicPassenger {
    private String pclass;
    private String survived;
    private String name;
    private String sex;  
    private float age;
    private String sipsb;
    private String parch;
    private String ticket;
    private float fare;
    private String cabin;
    private String embarked;
    private String boat;
    private String body;
    private String home_dist;
    
    TitanicPassenger(){
        
    }
    public float getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public String getPclass(){
        return this.pclass;
    }
    public String getSurvived(){
        return this.survived;
    }
    public String getSex(){
        return this.sex;
    }
}
