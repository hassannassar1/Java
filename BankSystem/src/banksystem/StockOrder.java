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
public class StockOrder {
    private float quantity;
    private Stock stock;
    private Account account;
    private final double commission ;
    private final float unit_price ;

    StockOrder(float quantity,Stock stock,Investment account){
        this.quantity = quantity;
        this.stock = stock;
        this.account = account;
        this.commission = .1;
        this.unit_price = quantity*stock.get_price();   
    }
    public void process_order(){
        float all = (float) (this.unit_price+(this.unit_price*commission));
        if (all<=account.balance()){
        account.set_balance(account.balance()-all);
        System.out.println("This process will be commited for "+all+" EGP for a quantity of "+this.quantity);
        System.out.println("Committed...");
        }
        else{
            System.out.println("Not enough money...");
        }
    }
    
}
