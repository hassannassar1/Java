/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xcharts;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author hassan
 */
public class Xcharts {
    public static void main(String[] args) throws IOException{
        
        ReadJson read_json = new ReadJson();
        List<TitanicPassenger> passengers = read_json.getPassengersFromJsonFile();
        
        Graph graph = new Graph();
        graph.graphPassengerAges(passengers);
        graph.graphPassengerClass(passengers);
        graph.graphPassengerSurvived(passengers);
        graph.graphPassengerGender(passengers);
        
    }
    
}
