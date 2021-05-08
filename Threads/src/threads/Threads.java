/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import static java.lang.Thread.sleep;

/**
 *
 * @author hassan
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        MyThread th1 = new MyThread("Thread Object 1");
        th1.start();
        MyThread th2 = new MyThread("Thread Object 2");
        th2.start();
        int sum = 0;
        for (int i=0;i<10;i++){
            System.out.println("In iteration number "+i+" In Main");
            sum +=i;
            sleep(10);
        }
        System.out.println("Sum in Main : "+sum);
    }
    
}
