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
public class cutter {
    private String s;
    private int []a;
    
    cutter(String o){
     this.s = o; 
    }
    
    public int[] cut(){
      String cutten[];
      cutten = this.s.split("\\.");
      this.a = new int[cutten.length]; 
      try{
      for (int i=0;i<cutten.length;i++)
        this.a[i]=Integer.parseInt(cutten[i]);}
      catch(Exception e){
          System.out.println(e);
      }
      
      return this.a;
    }
    
}
