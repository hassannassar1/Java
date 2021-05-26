/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LongerString;

/**
 *
 * @author hassan
 */
import java.util.function.BiPredicate;
public class LongerString {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "Welcome";
        String s2="To Java";
        BiPredicate<String, String> pb ;
        
        System.out.println(Strings.findString(s1,s2, (i1, i2) -> Strings.isBetter(i1, i2)));
        System.out.println(Strings.findString(s1,s2, (i1, i2) -> true));
        // Using a method reference
        System.out.println(Strings.findString(s1,s2, Strings::isBetter));
    } 
    
    
}
