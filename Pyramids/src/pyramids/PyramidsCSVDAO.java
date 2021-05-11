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
    Pyramid py;
    
    public PyramidsCSVDAO (){
        pyramids = new ArrayList<Pyramid>();
    }
    public List<Pyramid> readPyramidsFromCSV (String fileName){
        int i=1;
        double mean=0;
        try{
            BufferedReader br = new Thread(){public void run(){
            new BufferedReader(new FileReader(fileName));}}.start();
            
           // br = 
            String line = br.readLine();
             
            do{
                line = br.readLine();
                if (line != null){
                String [] attributes = line.split(",");
                if (attributes[7]==null){
                    attributes[7] = String.valueOf(mean);//String.valueOf(py.getHeight());
            }
                py = new Pyramid(Double.parseDouble(attributes[7]),attributes[0],attributes[4],attributes[2]);
                pyramids.add(py);
                i++;
                mean = (mean+py.getHeight())/i;
             }
            
             }while(line!=null);
                
        }catch(Exception e){
        
            }
    return pyramids; 
    }
    /*public Pyramid createPyramid(String []meta){
        return new Pyramid(meta)
    } */
    
}
