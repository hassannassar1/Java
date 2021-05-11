/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hassan
 */
public class ReadThread extends Thread{
    private String file ;
    public ReadThread(String file){
        this.file = file;
    }
    @Override
    public void run(){
        BufferedReader br; 
        try {
            br = new BufferedReader(new FileReader("pyramids.csv"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadThread.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}

    
