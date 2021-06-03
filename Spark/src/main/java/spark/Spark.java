/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;



/**
 *
 * @author hassan
 */
public class Spark {
    public static void main(String[]args){
        
        YoutubeCount yc = new YoutubeCount();
        //System.out.println("------------- Title Word Count -------------");
        //yc.getTitleWordCount();
        System.out.println("------------- Tag Word Count -------------");
        yc.getTagWordCount();
      
    }
    
}
