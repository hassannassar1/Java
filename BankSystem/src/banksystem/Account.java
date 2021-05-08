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
public class Account {
    private float balance;
    public Account(float balance){
        this.balance = balance;
    }
    public float balance()
    {
        return this.balance;
    }
    public void set_balance(float new_balance)
    {
        this.balance = new_balance;
    }
    public void add_money(float money)
    {
        this.balance += money;
    }
}


 class Saving extends Account {
    private double intrest_rate;
    public Saving(float balance,double intrest_rate){
        super(balance);
        this.intrest_rate = intrest_rate;
    }

}
  class Investment extends Account {
    public Investment(float balance){
        super(balance);
    }
  }

