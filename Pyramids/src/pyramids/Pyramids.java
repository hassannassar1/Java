/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hassan
 */
public class Pyramids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*try{
            BufferedReader br; 
            br = new BufferedReader(new FileReader("pyramids.csv"));
            String line = br.readLine();
            do{
                line = br.readLine();
                if (line != null){
                String [] attributes = line.split(",");
                System.out.println("height  "+attributes[7].equals(null));
                
            }}while(line!=null);
            }
             catch(Exception e){
                 System.out.println(e);
            }
       */
        PyramidsCSVDAO dao = new PyramidsCSVDAO();
        List <Pyramid> pyramids= dao.readPyramidsFromCSV("pyramids.csv");
        Map<String,Integer> pm = new HashMap<>() ;
        for (Pyramid p : pyramids){
            System.out.println("#"+p.getModern_name());
            pm.putIfAbsent(p.getSite(), 1);
            pm.put(p.getSite(),pm.get(p.getSite()) + 1);
        }
        System.out.println();
       Collections.sort(pyramids, new Sortbyheight());
       System.out.println("\nSorted by Height");
        for (Pyramid p:pyramids)
            System.out.println(p.getModern_name()+"   "+p.getHeight());
        System.out.println();
       pm.forEach((k, v) -> System.out.println("The Number of pyramids in " + k + " is : " + v));
      
    }
    
    
    
    
}
