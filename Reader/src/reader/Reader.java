/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author hassan
 */
public class Reader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileWriter writer = new FileWriter("Hi.txt",true);
        BufferedWriter buffer = new BufferedWriter(writer);
        
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        
        System.out.println("Enter Data: ");
        String s = br.readLine();
        while (!(s.equalsIgnoreCase("quit"))){
            buffer.write(s);
            buffer.newLine();
            System.out.println("Data is: "+s);
            System.out.println("Input: ");
            s = br.readLine();
        }
        buffer.close();
        br.close();
    }
    
}
