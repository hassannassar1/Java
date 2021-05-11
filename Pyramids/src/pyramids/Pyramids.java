/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author hassan
 */
public class Pyramids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader br; 
        br = new BufferedReader(new FileReader("pyramids.csv"));
        String line = br.readLine();
        if (line != null){
            System.out.println(line);
        }
        do
        {
            line = br.readLine();
            if (line != null){
            String [] attributes = line.split(",");
            for (String attr:attributes){
                System.out.print(attr+" ");
            }System.out.println(" ");
        }
            
        }while(line!=null);
    }
    
}
