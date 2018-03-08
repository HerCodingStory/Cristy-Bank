    /*---------------------------------------------------

 Name:  Cristina Villarroel

 Student ID: A32825495

 COP 2800 - Java Programming 

 Spring 2015 - T Th 6:00PM - 9:20PM

 Project # 2

 Plagiarism Statement

 I certify that this assignment is my own work and that I
 have not copied in part or whole or otherwise plagiarized 
 the work of other students and/or persons. */

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

public class TestBankAccount 
{
	public static void main(String[] args) 
	{
		BankAccount account    = new BankAccount(0.0, "");
		SavingsAccount savings = new SavingsAccount(0.0, "");
		CurrentAccount current = new CurrentAccount(0.0, "");
		Bank bank              = new Bank();
		SimpleDateFormat date  = new SimpleDateFormat("MM/dd/yyyy");
		DecimalFormat balance  = new DecimalFormat("##,###.##");
		boolean error          = false;
		boolean close          = true; 
		
		account.setAnnualInterestRate(4.5);
		
		do
		{
			List<String> optionList = new ArrayList<String>();
			optionList.add("1- Create a New Account");
			optionList.add("2- Deposit");
			optionList.add("3- Withdraw");
			optionList.add("4- Display Balance");
			optionList.add("5- Exit");
			
			Object[] options = optionList.toArray();
			
			Object action    = JOptionPane.showInputDialog(null, 
						                  "Please Choose an Action:\n", 
						                  "Cristy's Bank", 
						                  JOptionPane.PLAIN_MESSAGE, 
						                  null, options, options[0]);
                        
			
			int menuOption   = optionList.indexOf(action);
			
			if (menuOption == 0) // Create a New Account
			{
				String userName;
				String amount;
				double initialAmount;
				
				List<String> typesOfAccount = new ArrayList<String>();
				typesOfAccount.add("1- Basic");
				typesOfAccount.add("2- Savings");
				typesOfAccount.add("3- Current");
				
				Object[] options2 = typesOfAccount.toArray();
				
				userName          = (String) JOptionPane.showInputDialog(null, 
								             "Please Enter Your Name:\n", 
					                         "Create a New Account", 
					                         JOptionPane.PLAIN_MESSAGE, 
					                         null, null, null);

				do
				{
					amount        = (String) JOptionPane.showInputDialog(null, 
					                		 "Please Enter Initial Amount of Dollars($):\n", 
                                             "Create a New Account", 
                                             JOptionPane.PLAIN_MESSAGE, 
                                             null, null, null);
					
					initialAmount = Double.parseDouble(amount);
					
					if (initialAmount < 0)
					{
						JOptionPane.showMessageDialog(null, 
								   "Amount entered is incorrect. "
				                   + "Please use positive numbers.", "ERROR", 
                                   JOptionPane.ERROR_MESSAGE);
					}
					
				} while (initialAmount < 0);
				
				Object value2     = JOptionPane.showInputDialog(null, 
                                               "What Type of Account You Wish to Open:\n", 
                                               "Create a New Account", 
                                               JOptionPane.PLAIN_MESSAGE, 
                                               null, options2, options2[0]);
				
				int accountType   = typesOfAccount.indexOf(value2);
				
				// Types of Account
				if (accountType == 0) // Basic
				{
					bank.openAccount(accountType, userName, initialAmount);
				}
				else if (accountType == 1) // Savings
				{
					bank.openAccount(accountType, userName, initialAmount);
				}
				else if (accountType == 2) // Current
				{
					bank.openAccount(accountType, userName, initialAmount);
				}
			}
			
			else if (menuOption == 1) // Deposit
			{
				String amount;
				String userAccountId;
				String userPassword;
				double depositAmount;
				error = false;
				
				userAccountId = (String) JOptionPane.showInputDialog(null, 
						                 "Please Enter Your Account ID:\n", 
						                 "Deposit", 
						                 JOptionPane.PLAIN_MESSAGE, 
						                 null, null, null);
				
				userPassword = (String) JOptionPane.showInputDialog(null, 
										"Please Enter Your Password:\n", 
										"Deposit", 
										JOptionPane.PLAIN_MESSAGE, 
										null, null, null);
				
				if (!bank.findAccount(userAccountId, userPassword)) // Check Account
				{
					JOptionPane.showMessageDialog(null, "That account doesn't exist. "
							   + "Please create a account first.", "ERROR", 
							   JOptionPane.ERROR_MESSAGE);
					
					error = true;
				}
				
				while (error == false)
				{
					amount        = (String) JOptionPane.showInputDialog(null, 
	                                         "Please Enter the Amount to Deposit($):\n", 
	                                         "Deposit", 
	                                         JOptionPane.PLAIN_MESSAGE, 
	                                         null, null, null);
					
					depositAmount = Double.parseDouble(amount);
					
					if (0 > depositAmount)
					{
						JOptionPane.showMessageDialog(null, 
								   "Amount entered is incorrect. "
								   + "Please use positive numbers.", "ERROR", 
				                   JOptionPane.ERROR_MESSAGE);
						
						error = false;
					}
					else
					{
						bank.depositChecked(userAccountId, userPassword, depositAmount);
						JOptionPane.showMessageDialog(null, 
								   "      Transaction is Completed!!\n",
							       "Deposit", JOptionPane.PLAIN_MESSAGE);
						error = true;
					}
				}
			}
			
			else if (menuOption == 2) // Withdraw
			{
				String amount;
				String userAccountId;
				String userPassword;
				double withdrawAmount;
				error = false;
				
				userAccountId = (String) JOptionPane.showInputDialog(null, 
						                 "Please Enter Your Account ID:\n", 
                                         "Withdraw", 
                                         JOptionPane.PLAIN_MESSAGE, 
                                         null, null, null);
				
				userPassword = (String) JOptionPane.showInputDialog(null, 
	                                    "Please Enter Your Password:\n", 
                                        "Withdraw", 
                                        JOptionPane.PLAIN_MESSAGE, 
                                        null, null, null);
				
				if (!bank.findAccount(userAccountId, userPassword)) // Check Account
				{
					JOptionPane.showMessageDialog(null, "That account doesn't exist. "
							   + "Please create a account first.", "ERROR", 
							   JOptionPane.ERROR_MESSAGE);
					
					error = true;
				}
				
				while (error == false)
				{
					amount         = (String) JOptionPane.showInputDialog(null, 
                                     		  "Please Enter the Amount to Withdraw($):\n", 
                                     		  "Withdraw", 
                                     		  JOptionPane.PLAIN_MESSAGE, 
                                     		  null, null, null);
				
					withdrawAmount = Double.parseDouble(amount);
					
					if (withdrawAmount < 0)
					{
						JOptionPane.showMessageDialog(null, 
								   "Amount entered is incorrect. "
				                   + "Please use positive numbers", "ERROR", 
				                   JOptionPane.ERROR_MESSAGE);
						
						error = false;
					}
					else if (withdrawAmount > bank.displayBalance(userAccountId, 
							 userPassword))
					{
						JOptionPane.showMessageDialog(null, "Available Balance is "
				                   + "not enought to cover a withdrawal "
				                   + "from your account.", "ERROR", 
				                   JOptionPane.ERROR_MESSAGE);
						
						error = true;
					}
					else
					{
						bank.withdrawChecked(userAccountId, userPassword, 
								             withdrawAmount);
						JOptionPane.showMessageDialog(null, 
								   "      Transaction is Completed!!\n",
							       "Withdraw", JOptionPane.PLAIN_MESSAGE);
						error = true;
					}
				}
			}
			
			else if (menuOption == 3) // Display Balance
			{
				String userAccountId;
				String userPassword;
				error = false;
				
				userAccountId = (String) JOptionPane.showInputDialog(null, 
						                 "Please Enter Your Account ID:\n", 
                                         "Display Balance", 
                                         JOptionPane.PLAIN_MESSAGE, 
                                         null, null, null);
				
				userPassword = (String) JOptionPane.showInputDialog(null, 
	                                    "Please Enter Your Password:\n", 
                                        "Display Balance", 
                                        JOptionPane.PLAIN_MESSAGE, 
                                        null, null, null);
				
				if (!bank.findAccount(userAccountId, userPassword)) // Check Account
				{
					JOptionPane.showMessageDialog(null, "That account doesn't exist. "
							   + "Please create a account first.", "ERROR", 
							   JOptionPane.ERROR_MESSAGE);
					
					error = true;
				}
				
				if (error == false) // Print Account Overview
				{
					JOptionPane.showMessageDialog(null, "Account Overview: \n\n"
							   + "Type of Account: "+ bank.displayTypeOfAccount(userAccountId,
							   userPassword) + "\n"
							   + "Balance: $" + balance.format(bank.displayBalance(userAccountId, 
							   userPassword)) + "\n"
							   + "Interest Rate: "+ bank.displayInterest(userAccountId, 
							   userPassword) + "% \n"
							   + "Date Created: " + 
							   date.format(bank.displayDate(userAccountId, userPassword)) +"\n",
							   "Display Balance", JOptionPane.PLAIN_MESSAGE);
				}
			}
			
			else // Exit
			{
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, 
						                      "Do you Want to Exit?", 
						                      "Exit", dialogButton);
				
				if (dialogResult == JOptionPane.YES_OPTION)
				{
					close = false;
				}
			}
                            
			
		} while(close != false);
	}
}