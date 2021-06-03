/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depebdencies;

import java.io.IOException;

/**
 *
 * @author hassan
 */
public class Dependencies {
    public static void main(String[] args) throws IOException{
        String path = "titanic-passengers.csv";
        CSVRead r = new CSVRead(path);
        System.out.println("/////////////////// TableSaw /////////////////\n");
        r.ReadCSVByTableSaw();       
        System.out.println("/////////////////// Joinery /////////////////\n");
        r.ReadCSVByJoinery();
    }
    
}
