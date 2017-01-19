/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystemfinal;


import java.awt.Component;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import static javax.swing.GroupLayout.Alignment.*;

/**
 *
 * @author sashrestha
 * CS-203 Fall 2016 Final Project
 * Professor Barry Jones
 */
public class BankingApplication extends JFrame{
    
    /**
     * Setup the GUI and define methods it uses. This method invoked from the
     * event dispatch thread in main.
     * 
     */
    private static void setupAndCreateGUI() {
        
        // creating a new ListOfAccounts object and populating it
        ListOfAccounts acclist = new ListOfAccounts();
        
        SavingsAccount acc1 = new SavingsAccount("Gabrielle", 100.00);
        CheckingAccount acc2 = new CheckingAccount("Jonah", 110.00);
        CheckingAccount acc3 = new CheckingAccount("Nneoma", 998.00);
        SavingsAccount acc4 = new SavingsAccount("Lucas", 99898.87);
        SavingsAccount acc5 = new SavingsAccount("Gordon", 109.00);
        CheckingAccount acc6 = new CheckingAccount("Hallie", 998.00);
        CheckingAccount acc7 = new CheckingAccount("Liza", 998.00);
        SavingsAccount acc8 = new SavingsAccount("Lily", 99898.87);
        CheckingAccount acc9 = new CheckingAccount("Sophia", 109.00);
        CheckingAccount acc10 = new CheckingAccount("Carrie", 998.00);
        
        //add the accounts to acclist
        acclist.addAccount(acc1);
        acclist.addAccount(acc2);
        acclist.addAccount(acc3);
        acclist.addAccount(acc4);
        acclist.addAccount(acc5);
        acclist.addAccount(acc6);
        acclist.addAccount(acc7);
        acclist.addAccount(acc8);
        acclist.addAccount(acc9);
        acclist.addAccount(acc10);
        
        // creates the frame
        JFrame frame = new JFrame("Banking Application");
        
        // main Panel that will hold top and bottom panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.setOpaque(true);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setPreferredSize(new Dimension(550, 450));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // top panel that will hold the actions users can perform on the accounts
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        
        // bottom panel will hold actions for viewing account lists and give feedback to the user
        JPanel btmPanel = new JPanel();
        btmPanel.setLayout(new BorderLayout());
   
        //Parts of the top panel:
        
        //doMsgPane holds the welcome message and instructions for top panel
        JTextArea doMsgPane = new JTextArea("WELCOME!\nFill out your "
                + "information below "
                + "and press a button to complete transaction!");
        
        //doPane holds inout fields and buttons for various actions on the accounts
        JPanel doPane = new JPanel();
        doPane.setBackground(Color.WHITE);
        doPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //field to input name
        JTextField nameField = new JTextField();
        nameField.setColumns(10);
        
        //field to input amount
        JTextField amtField = new JTextField();
        amtField.setColumns(10);
        
        //Labels for input fields
        JLabel nameLabel = new JLabel("Name: ");
        JLabel amtLabel = new JLabel("Amount: ");
        JLabel typeLabel = new JLabel("Account Type: ");

        //radio buttons to select account type
        JRadioButton sRadio = new JRadioButton("Savings");
        JRadioButton cRadio = new JRadioButton("Checking");
        
        //putting radio buttons in a group to ensure only one is active at a time
        ButtonGroup group = new ButtonGroup();
        group.add(sRadio);
        group.add(cRadio);
        
        //Buttons to deposit and withdraw money, and add account 
        JButton depositButton = new JButton("Deposit");
        JButton wdrawButton = new JButton("Withdraw");
        JButton addButton = new JButton("Add Account");
        
        
        
        //LAYOUT for the doPane in top panel
    
        GroupLayout layout = new GroupLayout(doPane);
        doPane.setLayout(layout);

        JTextArea mtField = new JTextArea(" ");
        mtField.setEditable(false);
        
        //layout the components along x-axis
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(amtLabel)
                    .addComponent(depositButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(nameField)
                    .addComponent(amtField)
                    .addComponent(wdrawButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)    
                    .addComponent(typeLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(sRadio)
                            .addComponent(cRadio))
                .addComponent(addButton)))
            .addComponent(mtField)
        );
        
        //link buttons to ensure they stay the same size
        layout.linkSize(SwingConstants.HORIZONTAL, depositButton, wdrawButton);
        layout.linkSize(SwingConstants.HORIZONTAL, nameField, amtField);

        //layout the components along x-axis
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(mtField)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(nameLabel)
                .addComponent(nameField)
                .addComponent(typeLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(amtLabel)
                .addComponent(amtField)
                .addComponent(sRadio)
                .addComponent(cRadio))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(depositButton)    
                .addComponent(wdrawButton)
                .addComponent(addButton))
            .addComponent(mtField)
        );
        
        //set autogenerated gaps within layout
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        
        //Parts of the bottom panel:
        
        //viewMsgPane holds the instructions for bottom panel
        JTextArea viewMsgPane = new JTextArea("You will see confirmations about your"
                + " transactions here.\n"
                + "You can press any button at the bottom to view lists of accounts:");
        
        // panel to hold the display field and buttons
        JPanel viewPanel = new JPanel();
        viewPanel.setBackground(Color.WHITE);
        viewPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //panel to hold area displaying listofaccounts and feedback messages
        JPanel loaPanel = new JPanel();
        loaPanel.setBackground(Color.WHITE);
        
        //Text area to display lists of accounts and feedback messages
        JTextArea loaa = new JTextArea();
        loaa.setEditable(false);
        
        //Scrollpane for loaa when the lists get long
        JScrollPane scrollPane = new JScrollPane(loaa);
        scrollPane.setPreferredSize(new Dimension(450, 100));
        loaPanel.add(scrollPane);
        
        
        // create buttons to select type of account to be listed
        JButton sAButton = new JButton("Savings Accounts");
        JButton cHButton = new JButton("Checking Accounts");
        JButton aLButton = new JButton("All Accounts");

        
        //LAYOUT for viewPanel in bottom panel
        
        GroupLayout layout1 = new GroupLayout(viewPanel);
        viewPanel.setLayout(layout1);
        
        //layout the components along x-axis
        layout1.setHorizontalGroup(layout1.createSequentialGroup()
            .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(loaPanel)
                .addGroup(layout1.createSequentialGroup()
                    .addComponent(sAButton)
                    .addComponent(cHButton)
                    .addComponent(aLButton))
            )
        );
        
        //link buttons to ensure they stay the same size
        layout1.linkSize(SwingConstants.HORIZONTAL, sAButton, cHButton, aLButton);
        
        //layout the components along y-axis
        layout1.setVerticalGroup(layout1.createSequentialGroup()
            .addComponent(loaPanel)
            .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(sAButton)
                .addComponent(cHButton)
                .addComponent(aLButton))
        );
        
        //set autogenerated gaps within layout
        layout1.setAutoCreateGaps(true);
        layout1.setAutoCreateContainerGaps(true);
        
        
        //Methods and attributes to add actionlisteners to interactive fields
        
        JLabel typeSelected = new JLabel(" ");

        //Actionlisteners for radio buttons to select type of account
        sRadio.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                typeSelected.setText("Sa");
            } 
        } );
        
        cRadio.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                typeSelected.setText("Ca");
            } 
        } );
        
        //Actionlistener for deposit button 
        depositButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String name = nameField.getText();
                String type = typeSelected.getText();
                double amt = 0;
                if (!"".equals(amtField.getText())) {
                    amt = Double.parseDouble(amtField.getText());
                }
                if (name == null || amt == 0 || type == null){
                    loaa.setText("Please fill out all the fields.");
                } else {
                    loaa.setText(acclist.depositList(name, type, amt));
                }
            } 
        } );
        
        //Actionlistener for withdraw button 
        wdrawButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String type = typeSelected.getText();
                double amt = 0;
                if (!"".equals(amtField.getText())) {
                    amt = Double.parseDouble(amtField.getText());
                }
                if (name == null || amt == 0 || type == null){
                    loaa.setText("Please fill out all the fields.");
                } else {
                    loaa.setText(acclist.withdrawList(name, type, amt));
                }
            } 
        } );
        
        //Actionlistener for addaccount button 
        addButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String type = typeSelected.getText();
                double amt = 0;
                if (!"".equals(amtField.getText())) {
                    amt = Double.parseDouble(amtField.getText());
                }
                if (name == null || type == null){
                    loaa.setText("Please fill out all the fields.");
                } else {
                    if (type == "Sa"){
                        SavingsAccount acc = new SavingsAccount(name, amt);
                        acclist.addAccount(acc);
                        loaa.setText("New Savings account created for " + name + 
                                " with balance $" + amt);
                    } else {
                        CheckingAccount acc = new CheckingAccount(name, amt);
                        acclist.addAccount(acc);
                        loaa.setText("New Checking account created for " + name + 
                                " with balance $" + amt);
                    }
                }
            } 
        } );

        
        //Actionlistener for displaying savings accounts
        sAButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                loaa.setText(acclist.dispSavAcc());
            } 
        });
        

        //Actionlistener for displaying checking accounts
        cHButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                loaa.setText(acclist.dispCheAcc());
            } 
        });
        
        //Actionlistener for displaying all accounts
        aLButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                loaa.setText(acclist.dispAllAcc());
            } 
        } );
        
        // creates a timer that updates the balances of savings accounts every day 
        // (while the app is running)
        
        Timer timer = new Timer();
        final int millisecondstoDay = 1000*60*60*24;
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                acclist.addIntList();
            }
        }, millisecondstoDay, millisecondstoDay);
        
        //adding components to their parent panels
        mainPanel.add(topPanel);
        mainPanel.add(btmPanel);
        
        topPanel.add(doMsgPane, BorderLayout.NORTH);
        topPanel.add(doPane, BorderLayout.CENTER);
        
        btmPanel.add(viewMsgPane, BorderLayout.NORTH);
        btmPanel.add(viewPanel, BorderLayout.CENTER);
        

        // frame actions
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        // Turning off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                    setupAndCreateGUI();
            }
        });
    }    

}