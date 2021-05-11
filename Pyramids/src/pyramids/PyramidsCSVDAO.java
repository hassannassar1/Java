/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hassan
 */
public class PyramidsCSVDAO {
    private List<Pyramid> pyramids;
    private Pyramid py;
    
    public PyramidsCSVDAO (){
        pyramids = new ArrayList<Pyramid>();
    }
    public List<Pyramid> readPyramidsFromCSV (String fileName){
        int i=1;
        double mean=0;
        try{
            BufferedReader br; 
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            do{
                line = br.readLine();
                if (line != null){
                String [] attributes = line.split(",");
                
                if (attributes[7].isBlank()){
                mean = (mean+py.getHeight())/i;
                String []meta= {String.valueOf(mean),attributes[0],attributes[4],attributes[2]};
                py = createPyramid(meta);
                }
                else{
                    String []meta= {attributes[7],attributes[0],attributes[4],attributes[2]};
                    py = createPyramid(meta);
                    i++;}
                
                pyramids.add(py);}
            }while(line!=null);}
        
             catch(Exception e){
                 System.out.println(e);
            }
             return pyramids;    
        }
    
     public Pyramid createPyramid(String []meta){
        
        return new Pyramid(Double.parseDouble(meta[0]),meta[1],meta[2],meta[3]);
    } 
    
    }

