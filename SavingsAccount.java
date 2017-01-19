/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystemfinal;

/**
 *
 * @author sashrestha
 */
public class SavingsAccount extends Account
{
   
    private final double interestRate = 0.0001;
    
    /**
      Constructs a Savings account.
      @param aName the name of the account
      @param aBalance the balance of the account
    */
    public SavingsAccount(String aName, double aBalance) 
    {
        super(aName, aBalance);
    }
    
    /**
      adds interest to the balance of the account.
   */
    public void addInterest()
    {
        double interest = this.getBalance() * interestRate;
        double newBalance = this.getBalance() + interest;
        this.setBalance(newBalance);
    }
    
}