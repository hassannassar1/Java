/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LongerString;

import java.util.function.BiPredicate;

public class Strings {
public static Boolean isBetter(String n1, String n2) {
return n1.length() > n2.length();
}
public static String findString(String i,String j, BiPredicate<String,String> p) {
String x = "";
if (p.test(i, j)) {
x=i;
}
else{
    x=j;
}
return x;
}
}