/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

/**
 *
 * @author hassan
 */
public class Customer {
    private String name;
    private String address; 
    private Account account;
    
    Customer(String name,String address,Account account)
    {
        this.name = name;
        this.address = address;
        this.account=account;
    }
    public float customer_balance()
    {
        return account.balance();
    }
    
    public void information()
    {
        System.out.printf("Name is %s and address is %s\n", this.name,this.address);
    }
}
