/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author hassan
 */
public class Count {
    
    
    public static List<Map.Entry> popularTitles(List<Job> jobs){
        
        List<String> titles = jobs.stream()
                         .map (Job::getTitle)
                         .collect(Collectors.toList());
        
        Map<String, Integer> hm = new HashMap<>();
  
        titles.forEach(i -> {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        });
        
        List<Map.Entry> sorted = hm.entrySet ()
                .stream ()
                .sorted (Map.Entry.comparingByValue ())
                .collect (Collectors.toList ());
        
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
        
        return sorted;
    }
    
    public static List<Map.Entry> popularAreas(List<Job> jobs){
        
        List<String> areas = jobs.stream()
                         .map (Job::getLocation)
                         .collect(Collectors.toList());
        
        Map<String, Integer> hm = new HashMap<>();
  
        areas.forEach(i -> {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        });
        
        List<Map.Entry> sorted = hm.entrySet ()
                .stream ()
                .sorted (Map.Entry.comparingByValue ())
                .collect (Collectors.toList ());
        
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
        
        return sorted;
        
    }
    
    public static List<Map.Entry> popularCompanies(List<Job> jobs){
        
        List<String> companies = jobs.stream()
                         .map (Job::getCompany)
                         .collect(Collectors.toList());
        
        Map<String, Integer> hm = new HashMap<>();
  
        companies.forEach(i -> {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        });
        
        List<Map.Entry> sorted = hm.entrySet ()
                .stream ()
                .sorted (Map.Entry.comparingByValue ())
                .collect (Collectors.toList ());
        
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
        
        return sorted;
        
    }
    
    public static List<Map.Entry> getSkillCount(List<Job> jobs){
        
        List<String> skills = jobs.stream()
                         .map (Job::getSkills)
                         .collect(Collectors.toList());
        
        Object[] o = skills.stream().toArray();
        
        List<String> skills_ = new ArrayList();
        
        for(Object h : o){
           String[] n =h.toString().split(",");
           skills_.addAll(Arrays.asList(n));
        }
        
        Map<String, Integer> hm = new HashMap<>();
        
        skills_.forEach(i -> {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        });
        
        List<Map.Entry> sorted = hm.entrySet ()
                .stream ()
                .sorted (Map.Entry.comparingByValue ())
                .collect (Collectors.toList ());
        
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
        
        return sorted;
    }
 
    
}
