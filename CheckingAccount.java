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
public class CheckingAccount extends Account
{
    private final double fee = 0.1;
    
    /**
      Constructs a Checking account.
      @param aName the name of the account
      @param aBalance the balance of the account
    */
    public CheckingAccount(String aName, double aBalance) 
    {
        super(aName, aBalance);
    }
    
    /**
      subtracts fee from the balance of the account.
     * @param cA the CHeckingAccount to subtract fee from
   */
    private void subFee(CheckingAccount cA)
    {
        double newBalance = cA.getBalance() - fee;
        cA.setBalance(newBalance);
    }
    
    /**
      subtracts amount + fee from the balance of the CheckingAccount.
     * @param wAmount the amount to remove from the balance
    */
    public void withdraw(double wAmount)
    {
        this.setBalance(this.getBalance() - wAmount);
        subFee(this);
    }
    
}