/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author hassan
 */
public class MyThread extends Thread{
    private String name ;
    public MyThread(String name){
        this.name = name;
    }
    @Override
    public void run(){
        int sum = 0;
        for (int i=0;i<10;i++){
            System.out.println("In iteration number "+i+" In"+this.name);
            sum +=i;
        }
        System.out.println("Sum in "+this.name+" : "+sum);
            
    }
    
}
