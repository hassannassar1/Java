/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobServices;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author hassan
 */
@XmlRootElement(name= "job" )
@XmlType(propOrder = {"title", "company", "location", "type", "level","expYear","country","skills"})
public class Job implements Serializable {
    
    String title;
    String company;
    String location;
    String type;
    String level;
    String expYears;
    String country;
    String skills;
    
    public Job(String title, String company, String location,
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
    
    
    @XmlElement
    public String getTitle(){
        return this.title;
    }
    
    @XmlElement
    public String getCompany(){
        return this.company;
    }
    
    @XmlElement
    public String getLocation(){
        return this.location;
    }
    
    @XmlElement
    public String getType(){
        return this.type;
    }
    
    @XmlElement
    public String getLevel(){
        return this.level;
    }
    
    @XmlElement
    public String getExpYears(){
        return this.expYears;
    }
    
    
    public String getCountry(){
        return this.country;
    }
    @XmlElement
    public String getSkills(){
        return this.skills;
    }
    
    
    
}
