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
public class BankSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create all objects
        Stock stock = new Stock("Base",300.50); // Stock with name "Base" and peice 300.50
        Investment inv = new Investment(500); // Account of type Investment with balance 500
        Customer customer = new Customer("Hassan","Banha",inv); // Customer with name "Hassan"
        StockOrder order = new StockOrder(1,stock,inv); // StockOrder to make an Order
        
        Saving in = new Saving(500000,.15); // Account of type Saving with balance 500
        Customer customer2 = new Customer("Houda","Cairo",in); // Customer with name "Mahmoud"
        //StockOrder orde = new StockOrder(1,stock,in); ##Error it take only Investment object
        
        customer2.information();
        System.out.println("Balance is : "+customer2.customer_balance()+"\n");
        
        customer.information();
        System.out.println("Balance is : "+customer.customer_balance()+"\n");
        
        order.process_order();// Succeded
        System.out.printf("Balance is : %.2f\n\n",customer.customer_balance());
        
        order.process_order();// Not Succeded
        System.out.printf("Balance is : %.2f\n\n",customer.customer_balance());
        
        inv.add_money(1000);
        System.out.println("Balance is : "+customer.customer_balance()+"\n");
    }
    
}
