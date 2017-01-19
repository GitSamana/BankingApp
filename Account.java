/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystemfinal;

import java.util.Comparator;

/**
 *
 * @author sashrestha
 */
/**
 /**
   A bank Account with a name and balance.
*/
public class Account
{
    
 /**
      Constructs an account.
      @param aName the name of the account
      @param aBalance the balance of the account
   */
   public Account(String aName, double aBalance)
   {
      name = aName;
      balance = aBalance;
   }

   /**
      Gets the name of the account.
      @return the name
   */
   public String getName()
   {
      return name;
   }

   /**
      Gets the balance of the account.
      @return the balance
   */
   public double getBalance()
   {
      return balance;
   }


   /**
      Sets the balance of the account.
     * @param newBalance the new amount to set the balance to
   */
   public void setBalance(double newBalance)
   {
      this.balance = newBalance;
   }
   
   /**
      adds deposit to the balance of the account.
     * @param dAmount the new amount to set add to the balance
   */
   public void deposit(double dAmount)
   {
       this.balance += dAmount; 
   }
   
   /**
      subtracts amount from the balance of the account.
     * @param wAmount the amount to add to the balance
   */
   public void withdraw(double wAmount)
   {
       this.balance -= wAmount; 
   } 
   

   private final String name;
   private double balance;
    
}