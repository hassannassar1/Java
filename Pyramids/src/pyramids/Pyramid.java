/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.util.Comparator;

/**
 *
 * @author hassan
 */
public class Pyramid {
    private double height;
    private String pharaoh;
    private String modern_name;
    private String site;
    
   public Pyramid(double height,String pharaoh,
                    String site, String modern_name){
       this.height = height;
       this.pharaoh = pharaoh;
       this.modern_name = modern_name;
       this.site = site;
   }
   public double getHeight(){
       return this.height;
   }
   public String getModern_name(){
       return this.modern_name;
   }
   public String getPharaoh(){
       return this.pharaoh;
   }
   public String getSite(){
       return this.site;
   }
   public void setHeight(double height){
       this.height=height;
   }
   public void setModern_name(String modern_name){
       this.modern_name=modern_name;
   }
   public void setPharaoh(String pharaoh){
       this.pharaoh = pharaoh;
   }
   public void setSite(String site){
       this.site=site;
   }
    
}
class Sortbyheight implements Comparator<Pyramid> {
    public int compare(Pyramid p1, Pyramid p2)
    {
        return (int)(p1.getHeight() - p2.getHeight());
    }
}
