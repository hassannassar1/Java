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
  public void run() {
    BufferedReader br = null;
     try {
            br = new BufferedReader(new FileReader(this.file));
            String buffer =null;
            while((buffer=br.readLine())!=null){
                
            }

        }catch (IOException e) {
                e.printStackTrace();
            }
        finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


  }
}

    
