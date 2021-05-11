/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hassan
 */
public class PyramidsCSVDAO {
    private final List<Pyramid> pyramids;
    private Pyramid py;
    private final List<List<String>> Lines;
    
    public PyramidsCSVDAO (){
        pyramids = new ArrayList<>();
        Lines = new LinkedList<>();
    }
    
    public List<Pyramid> readPyramidsFromCSV (String fileName){
        List<List<String>> thepyramids = ReadCSVFile(fileName);
        thepyramids.stream().map(pyramid -> {
            if (pyramid.get(7).isBlank()){
                String []meta= {String.valueOf(py.getHeight()),pyramid.get(0),pyramid.get(4),pyramid.get(2)};
                py = createPyramid(meta);
            }
            else{
                String []meta= {pyramid.get(7),pyramid.get(0),pyramid.get(4),pyramid.get(2)};
                py = createPyramid(meta);}
            return pyramid;            
        }).forEachOrdered(_item -> {
            pyramids.add(py);
        });
        return pyramids;   
    }
 
     public Pyramid createPyramid(String []meta){
        
        return new Pyramid(Double.parseDouble(meta[0]),meta[1],meta[2],meta[3]);
    }
     public List<List<String>> ReadCSVFile(String fileName) {
        try {
            Thread thread;
            thread = new Thread(() -> {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
                    String line = bufferedReader.readLine();
                    while ((line = bufferedReader.readLine()) != null) {
                        PyramidsCSVDAO.this.Lines.add(Arrays.asList(line.split(",")));
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

        