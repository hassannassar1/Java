/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries.and.cities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hassan
 */
public class Read {
    private final List<List<String>> Lines;
    Read(){
        Lines = new LinkedList<>();
    }
    public List<List<String>> ReadCSVFile(String fileName) {
        try {
            Thread thread;
            thread = new Thread(() -> {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
                    String line ;
                    while ((line = bufferedReader.readLine()) != null) {
                        this.Lines.add(Arrays.asList(line.split(",")));
                    }
                }catch (IOException e) {
                    System.out.println(e);
                }
            });
            thread.start();
            thread.join();
        } catch (InterruptedException e) {System.out.println(e);
        }
        return this.Lines;
    }
    
}
