/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;

/**
 *
 * @author hassan
 */
public class Job {
    
    String title;
    String company;
    String location;
    String type;
    String level;
    String expYears;
    String country;
    String skills;
    
    Job(String title, String company, String location,
        String type, String level, String expYears, 
        String country, String skills){
        
        this.title = title;
        this.company = company;
        this.location = location;
        this.type = type;
        this.level = level;
        this.expYears = expYears;
        this.country = country;
        this.skills = skills;
    }
    public String getTitle(){
        return this.title;
    }
    public String getCompany(){
        return this.company;
    }
    public String getLocation(){
        return this.location;
    }
    public String getType(){
        return this.type;
    }
    public String getLevel(){
        return this.level;
    }
    public String getExpYears(){
        return this.expYears;
    }
    public String getCountry(){
        return this.country;
    }
    public String getSkills(){
        return this.skills;
    }

}
