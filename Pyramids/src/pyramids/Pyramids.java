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
import java.util.List;

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
        PyramidsCSVDAO dao = new PyramidsCSVDAO();
        List <Pyramid> pyramids= dao.readPyramidsFromCSV("pyramids.csv");
        int i = 0;
        for (Pyramid p : pyramids){
            System.out.println("#"+(i++)+p);
        }
       // pyramids.sort(height);
    }
    
    
    
    
}
