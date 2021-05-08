/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipcutter;

/**
 *
 * @author hassan
 */
public class IPCutter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String ip = "192.168.1.1";
        cutter c = new cutter(ip);
        int a[] = c.cut();
        for(int i:a)
           System.out.println(i);
    }
    
}
