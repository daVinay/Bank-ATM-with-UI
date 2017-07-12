/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asses2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Vinay
 */

public class atmInterface {
    /** 
     * 
     * initializing all the variables here 
     *
     */
   
        public float balance = 1000;  
        public float withdrawingAmount,DepositingAmount;
        String topOutput, numString, numOut, actionString = "";
        String leftNum = "";
        String rightNum = "";

        public int state;

        JFrame frame;
        JTextArea infoPanel;
        JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndot, btnClear; 
        JButton btnCancel, btnWithdraw, btnDeposit, btnBalanceEnquiy, btnHelp, btnEnter;
        JPanel middlePanel, bottomPanel, middlePanel1, middlePanel2;


        void setupButtons(){
            try{
                frame = new JFrame("Ait Bank");   //setup Frame
                frame.setSize(450, 400);
                infoPanel = new JTextArea(10,1);
                infoPanel.setEditable(false);

                frame.add(infoPanel, BorderLayout.NORTH);

                NameButtons();
                setupPanels();

                btn1.setEnabled(false);  /*number buttons will be disablled so that only functions can be choosen first*/
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btn0.setEnabled(false);
                btndot.setEnabled(false);
                btnClear.setEnabled(false);
                btnEnter.setEnabled(false);

                updateGUI();   /*funtion to update user input*/


                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
           catch(Exception e)
           {
               System.out.println("Caught exception! "+e.toString());
           }

        }



        private void setupPanels(){
            /*
            * All panels set up here
            */

            middlePanel = new JPanel(new GridLayout(1,2));

            bottomPanel = new JPanel(new GridLayout(1,2));

            middlePanel1 = new JPanel(new GridLayout(4,3));

            middlePanel.add(middlePanel1);

            middlePanel1.add(btn1);
            middlePanel1.add(btn2);
            middlePanel1.add(btn3);
            middlePanel1.add(btn4);
            middlePanel1.add(btn5);
            middlePanel1.add(btn6);
            middlePanel1.add(btn7);
            middlePanel1.add(btn8);
            middlePanel1.add(btn9);
            middlePanel1.add(btn0);
            middlePanel1.add(btndot);
            middlePanel1.add(btnClear);

            middlePanel2 = new JPanel(new GridLayout(4,1));

            middlePanel.add(middlePanel2);

            middlePanel2.add(btnWithdraw);
            middlePanel2.add(btnDeposit);
            middlePanel2.add(btnBalanceEnquiy);
            middlePanel2.add(btnHelp);
            bottomPanel.add(btnCancel);
            bottomPanel.add(btnEnter);


            frame.add(middlePanel, BorderLayout.CENTER);
            frame.add(bottomPanel, BorderLayout.SOUTH);
        }


        private void NameButtons(){
            /*
            *
            *All the buttons and Actions are here
            */

            btn1 = new JButton("1");
            btn2 = new JButton("2");
            btn3 = new JButton("3");
            btn4 = new JButton("4");
            btn5 = new JButton("5");
            btn6 = new JButton("6");
            btn7 = new JButton("7");
            btn8 = new JButton("8");
            btn9 = new JButton("9");
            btn0 = new JButton("0");
            btndot = new JButton(".");
            btnClear = new JButton("CLR");

            btnWithdraw = new JButton("Withdraw");
            btnDeposit = new JButton("Deposit");
            btnBalanceEnquiy = new JButton("Balance Enquiry");
            btnHelp = new JButton("Help");

            btnCancel = new JButton("Cancel");
            btnEnter = new JButton("Enter");


            btn1.addActionListener(new buttonActions(1, this));
            btn2.addActionListener(new buttonActions(2, this));
            btn3.addActionListener(new buttonActions(3, this));
            btn4.addActionListener(new buttonActions(4, this));
            btn5.addActionListener(new buttonActions(5, this));
            btn6.addActionListener(new buttonActions(6, this));
            btn7.addActionListener(new buttonActions(7, this));
            btn8.addActionListener(new buttonActions(8, this));
            btn9.addActionListener(new buttonActions(9, this));
            btn0.addActionListener(new buttonActions(0, this));

            /**********Cancel Button **********/
            btnCancel.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                  System.exit(0);  /*cold cut the programme*/
                } 
            });

            //**********CLEAR Button**********
            btnClear.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    btn1.setEnabled(false);  /*will set numbers unclickable again*/
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btn0.setEnabled(false);
                    btndot.setEnabled(false);
                    btnWithdraw.setEnabled(true);
                    btnDeposit.setEnabled(true);
                    btnBalanceEnquiy.setEnabled(true);
                    btnHelp.setEnabled(true);
                    btnEnter.setEnabled(false);

                    actionString =""; 
                    leftNum = "";
                    rightNum= "";
                   /* System.out.println("reached button clear");  //testing the code run */

                    updateGUI();
                } 
            });


            //**********Withdraw button**********
            btnWithdraw.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    btn1.setEnabled(true);  /*set number buttons on enabled*/
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                    btn4.setEnabled(true);
                    btn5.setEnabled(true);
                    btn6.setEnabled(true);
                    btn7.setEnabled(true);
                    btn8.setEnabled(true);
                    btn9.setEnabled(true);
                    btn0.setEnabled(true);
                    btndot.setEnabled(true);
                    btnClear.setEnabled(true);
                    btnEnter.setEnabled(true);
                    btnDeposit.setEnabled(false);
                    btnBalanceEnquiy.setEnabled(false);
                    btnHelp.setEnabled(false);

                    actionString = "How much would you like to withdraw? ";  /*Ask for input from user*/

                    state =1;  /*this will determine what "Enter" will perform*/

                    updateGUI();  //update the interface
                } 
            });


            //********** Deposit button **********
            btnDeposit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                  btn1.setEnabled(true);
                  btn2.setEnabled(true); /*set number buttons on enabled*/
                  btn3.setEnabled(true);
                  btn4.setEnabled(true);
                  btn5.setEnabled(true);
                  btn6.setEnabled(true);
                  btn7.setEnabled(true);
                  btn8.setEnabled(true);
                  btn9.setEnabled(true);
                  btn0.setEnabled(true);
                  btndot.setEnabled(true);
                  btnClear.setEnabled(true);
                  btnEnter.setEnabled(true);
                  btnWithdraw.setEnabled(false);
                  btnBalanceEnquiy.setEnabled(false);
                  btnBalanceEnquiy.setEnabled(false);
                  btnHelp.setEnabled(false);

                  actionString = "How much would you like to Deposit?"; /*Ask for input from user*/

                  state = 2;  /*this will determine what "Enter" will perform*/


                  updateGUI();  //update the interface



                } 
            });


            //********** Balance Enquiry Button **********
            btnBalanceEnquiy.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionString =  "Your saving account balance is: "+balance+"\nPress Cancel to exit or select from options."; 
                    //infoPanel.setText(infoPanel.getText()+"\n "+actionString);
                    btnClear.setEnabled(true);
                    btnEnter.setEnabled(false);
                    updateGUI();    

                } 
            });

            //***********Help Button ************
            btnHelp.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    actionString = "this is a help and I'm here to help you :-)\nPress Cancel to exit or select from options."; /*easiest to do. Can put lots of instruction but have limited time, sorry. */
                    //infoPanel.setText(infoPanel.getText()+"\n "+actionString);
                    updateGUI();
                    btnClear.setEnabled(true);
                } 
            });

            //*********** Enter Button **********
            btnEnter.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    if(!rightNum.isEmpty()){   /*if there is a number entered do the following*/

                        System.out.println("reached enter"); /*testing*/ 
                        System.out.println("state is: "+state); /*testing*/

                        if(state==1){  /*if user want to withdrawal*/
                           withdrawingAmount = Float.parseFloat(numOut);  /*convert the string to float*/

                           if(withdrawingAmount > balance )        /*withdrawing money can't be more than balance*/
                            {
                                actionString = "You can't withdraw more than your account balance of "+balance
                                        + "\nPlease enter the amount again: ";
                                leftNum = "";
                                rightNum = "";

                                updateGUI();  /*update interface*/
                            }
                           
                           else if((withdrawingAmount%10!=0 ) || (withdrawingAmount == 10) || (withdrawingAmount == 30)){     /*can't withdraw 10, 30 and anything that is not in multiple of 10*/
                                actionString = "This ATM can only dispense 20, 50 and 100 notes.\nPlease enter the amount again: ";
                                leftNum = "";
                                rightNum = "";
                                updateGUI();
                            }  
                           
                            else {  /*if all conditions are false then withdrawal can be made*/
                                balance -=  withdrawingAmount;  /*set the new balance after withdrawal*/
                                actionString =  "Your new saving account balance after withdrawal is: "+balance;
                                leftNum = "";
                                rightNum = "";
                                btnWithdraw.setEnabled(true);  /*enalble other options*/
                                btnDeposit.setEnabled(true);
                                btnBalanceEnquiy.setEnabled(true);
                                btnHelp.setEnabled(true);
                                updateGUI();  /*update GUI*/

                                btn1.setEnabled(false);  /*will set numbers unclickable again*/
                                btn2.setEnabled(false);
                                btn3.setEnabled(false);
                                btn4.setEnabled(false);
                                btn5.setEnabled(false);
                                btn6.setEnabled(false);
                                btn7.setEnabled(false);
                                btn8.setEnabled(false);
                                btn9.setEnabled(false);
                                btn0.setEnabled(false);
                                btndot.setEnabled(false);
                                btnEnter.setEnabled(false);
                            }

                       }
                       else if (state==2){  /*if user wants to deposit*/
                           DepositingAmount = Float.parseFloat(numOut);  /*convert the string to float*/
                           balance +=  DepositingAmount;  /*set new balance*/
                           actionString =  "Your new saving account balance after Deposit is: "+balance;
                           leftNum = "";
                           rightNum = "";
                           btnWithdraw.setEnabled(true); /*enable other options*/
                           btnDeposit.setEnabled(true);
                           btnBalanceEnquiy.setEnabled(true);
                           btnHelp.setEnabled(true);
                           updateGUI(); /*update interface*/

                           btn1.setEnabled(false);  /*will set numbers unclickable again*/
                           btn2.setEnabled(false);
                           btn3.setEnabled(false);
                           btn4.setEnabled(false);
                           btn5.setEnabled(false);
                           btn6.setEnabled(false);
                           btn7.setEnabled(false);
                           btn8.setEnabled(false);
                           btn9.setEnabled(false);
                           btn0.setEnabled(false);
                           btndot.setEnabled(false);
                           btnEnter.setEnabled(false);
                       }
                   }
                    else{  /*if no number is entered*/
                        actionString ="Nothing entered as yet!";
                        updateGUI();
                    }
                }  
            });
        }


        public void updateGUI(){ /*Function to update the interface*/

            topOutput = "\n\tWelcome to your saving Accout\n"
                   + " =============================================================";
             numString =   "Account Number:\t550299\n"
                     + "Account type:\t\tSaving\n"                /*these lines are permanent and only balance changes here*/
                     + "Account Intrest:\t\tDaily\n"
                     + "Current Balance:\t"+balance+"\n";

            /*I can also leave numString/topOut blank and pass the value from where function is called, like how I have done with actionString*/

            numOut= leftNum+""+rightNum;  /*this will change as per user input*/



            System.out.println("reached update gui");  /*testing*/


            infoPanel.setText(topOutput+"\n"+numString+"\n"+actionString+"\n"+numOut); /*this is going to update according to user input and function*/

        }

   
}

