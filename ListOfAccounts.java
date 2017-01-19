/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystemfinal;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author sashrestha
 */
public class ListOfAccounts{
    
    ArrayList<Account> accounts = new ArrayList<>();
    
    /**
      Adds account to accounts
     * @param acc the new account to be added
    */
    public void addAccount(Account acc){
        accounts.add(acc);
    }

    /**
      adds Interest to all accounts in list accounts
   */
    public void addIntList(){    
        for (Account sA : accounts) {
            if (sA instanceof SavingsAccount){
                ((SavingsAccount) sA).addInterest();
            }
        }
    }
    
    //String message to report confirmation of transaction
    public String msg;
    private String listy = "";
    private String balStr;
    
    
    /**
      Withdraw amount from the balance of specific account in list.
      * @param name the name of account holder
      * @param type the type of account
      * @param amt the amount to withdraw
   */
    public String withdrawList(String name, String type, double amt){
        msg = "Sorry, no such account type exists by that name!";
        if (type.equals("Sa")){
            for (Account sA : accounts) {
                if ((sA instanceof SavingsAccount)  && (sA.getName().equals(name))){
                    if (amt < ((SavingsAccount) sA).getBalance()){
                        ((SavingsAccount) sA).withdraw(amt);
                        msg = (((SavingsAccount) sA).getName() + 
                                ", your new balance is: $"
                                + ((SavingsAccount) sA).getBalance());
                    } else {
                    msg = (((SavingsAccount) sA).getName()) + ", sorry but you "
                            + "are out of funds!";
                    }
                }
            }
        }
        else if (type.equals("Ca")) {
            for (Account cA : accounts) {
                if ((cA instanceof CheckingAccount)  && (cA.getName().equals(name))){
                    if (amt < ((CheckingAccount) cA).getBalance()){
                        ((CheckingAccount) cA).withdraw(amt);
                        msg = (((CheckingAccount) cA).getName() + 
                                ", your new balance is: $"
                                + ((CheckingAccount) cA).getBalance());
                    } else{
                    msg = (((CheckingAccount) cA).getName()) + ", sorry but you "
                            + "are out of funds!";
                    }
                }
            }
        }
        else {
            msg = "Invalid inputs";
        }
        return msg;
    }
    
    
    /**
      Deposit amount into the balance of specific account in list.
      * @param name the name of account holder
      * @param type the type of account
      * @param amt the amount to deposit
   */
    public String depositList(String name, String type, double amt){
        msg = "Sorry, no such account type exists by that name!";
        if (type.equals("Sa")){
            for (Account sA : accounts) {
                if ((sA instanceof SavingsAccount)  && (sA.getName().equals(name))){
                    ((SavingsAccount) sA).deposit(amt);
                    msg = (((SavingsAccount) sA).getName() + 
                            ", your new balance is: $"
                            + ((SavingsAccount) sA).getBalance());
                } 
            }
        }
        else if (type.equals("Ca")) {
            for (Account cA : accounts) {
                if ((cA instanceof CheckingAccount)  && (cA.getName().equals(name))){
                    ((CheckingAccount) cA).deposit(amt);
                    msg = (((CheckingAccount) cA).getName() + 
                            ", your new balance is: $"
                            + ((CheckingAccount) cA).getBalance());
                }
            }
        } else {
            msg = "Invalid inputs";
        } 
        return msg;
    }


    /**
      method to return all accounts
      @return all the accounts
   */
    
    public String dispAllAcc(){
        String listy = ""; 
        for (Account a : accounts) {
            balStr = Double.toString(a.getBalance());
            listy += "Name: " + a.getName() + " | Balance: $" + balStr + "\n";
 
        }
        return listy;
    }

    /**
      method to return Savings accounts
      @return savings accounts
   */
    public String dispSavAcc(){
        String listy = ""; 
        for (Account sA : accounts) {
            if (sA instanceof SavingsAccount){
                balStr = Double.toString(sA.getBalance());
            listy += "Name: " + sA.getName() + " | Balance: $" + balStr + "\n";
            }
        }
        return listy;
    }


    /**
      method to return Checking accounts
      @return checking accounts
   */
    public String dispCheAcc(){
        String listy = ""; 
        for (Account cA : accounts) {
            if (cA instanceof CheckingAccount){
                balStr = Double.toString(cA.getBalance());
            listy += "Name: " + cA.getName() + " | Balance: $" + balStr + "\n";
            }
        }
        return listy;
    }
  
}