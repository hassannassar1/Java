/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

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
        PyramidsCSVDAO dao = new PyramidsCSVDAO();
        List <Pyramid> pyramids= dao.readPyramidsFromCSV("pyramids.csv");
        Map<String,Integer> pm = new HashMap<>() ;
        int i = 1;
        for (Pyramid p : pyramids){
            System.out.println("#"+(i++)+"-"+p.getModern_name()+"-------"+p.getPharaoh());
            pm.putIfAbsent(p.getSite(), 1);
            pm.put(p.getSite(),pm.get(p.getSite()) + 1);
        }
       System.out.println();
       Collections.sort(pyramids, new Sortbyheight());
       System.out.println("\n-------Sorted by Height----------");
       System.out.println("\nNum Height       Name     ");
       i=1;
        for (Pyramid p:pyramids)
            System.out.println("#"+(i++)+"   "+p.getHeight()+"  "+p.getModern_name());
        System.out.println();
       pm.forEach((k, v) -> System.out.println("The Number of pyramids in " + k + " is : " + v));
      
    }
    
    
    
    
}
