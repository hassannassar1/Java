/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

import java.util.Scanner;

/**
 *
 * @author hassan
 */
public class Stream {

    /**
     * @param args the command line arguments
     */
    public static boolean isAlphapetic(String s) {
    return s!= null && !s.isBlank() && s.chars()
      .allMatch(Character::isLetter);
}
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(isAlphapetic(s));
    }
    
}
