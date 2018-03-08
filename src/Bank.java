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

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Bank 
{
	private ArrayList<BankAccount> bankAccounts;
	
	Bank()
	{
		this.bankAccounts = new ArrayList<BankAccount>();
	}
	
	public void update()
	{
		for (BankAccount account: bankAccounts)
		{
			if (account instanceof SavingsAccount)
			{
				((SavingsAccount) account).addInterest();
			}
			else if (account instanceof CurrentAccount)
			{
				if(account.getAccountBalance() < 0)
				{
					System.out.println("ERROR: You are in overdraft.");
				}
			}
		}
	}
	
	public void openAccount(int userChoice, String userName, double initialAmount)
	{
		switch (userChoice)
		{
			case 0:
				BankAccount regular = new BankAccount(initialAmount, userName);
				bankAccounts.add(regular);
				JOptionPane.showMessageDialog(null, 
						   "Your Account was Created Successfully!!\n\n"
					       + "Account ID: "+ regular.getAccountId() +"\n"
					       + "Password: " + regular.getPassword() +"\n",
					       "Create a New Account", JOptionPane.PLAIN_MESSAGE);
				System.out.println(regular.getAccountId() + "\n" + regular.getPassword());
				break;
				
			case 1:
				SavingsAccount savings = new SavingsAccount(initialAmount, userName);
				bankAccounts.add(savings);
				JOptionPane.showMessageDialog(null, 
						   "Your Account was Created Successfully!!\n\n"
					       + "Account ID: "+ savings.getAccountId() +"\n"
					       + "Password: " + savings.getPassword() +"\n",
					       "Create a New Account", JOptionPane.PLAIN_MESSAGE);
				System.out.println(savings.getAccountId() + "\n" + savings.getPassword());
				break;
				
			case 2:
				CurrentAccount current = new CurrentAccount(initialAmount, userName);
				bankAccounts.add(current);
				JOptionPane.showMessageDialog(null, 
						   "Your Account was Created Successfully!!\n\n"
					       + "Account ID: "+ current.getAccountId() +"\n"
					       + "Password: " + current.getPassword() +"\n",
					       "Create a New Account", JOptionPane.PLAIN_MESSAGE);
				System.out.println(current.getAccountId() + "\n" + current.getPassword());
				break;
		}
	}
	
	public void closeAccount()
	{
		Scanner input = new Scanner(System.in);
		boolean found = false;
		String userName;
		String userId;
		
		System.out.println("Enter your name: ");
		userName = input.nextLine();
		
		System.out.println("Enter your account ID: ");
		userId = input.nextLine();
		
		for (int i = 0; i < bankAccounts.size(); i++)
		{
			if (userId.equals(bankAccounts.get(i).getAccountId()) && 
			    userName.equals(bankAccounts.get(i).getName()))
			{
					bankAccounts.remove(i).getName();
					bankAccounts.remove(i).getAccountId();
					System.out.println("Your account was removed from the system.");
					found = true;
			}
		}
		
		if (found == false)
		{
			System.out.println("That account doesn't exist.");
		}
	}
	
	public boolean findAccount(String id, String password)
	{
		boolean found = false;
		
		for (int i = 0; i < bankAccounts.size(); i++)
		{
			if (id.equals(bankAccounts.get(i).getAccountId()) && 
			   password.equals(bankAccounts.get(i).getPassword()))
			{
				return found = true;
			}
		}
		
		return found;
	}
	
	public void depositChecked(String id, String password, double amount)
	{
		for (int i = 0; i < bankAccounts.size(); i++)
		{
			if (bankAccounts.get(i).getAccountId().equals(id) && 
			   password.equals(bankAccounts.get(i).getPassword()))
			{
				bankAccounts.get(i).deposit(amount);
			}
		}
	}
	
	public void withdrawChecked(String id, String password, double amount)
	{
		for (int i = 0; i < bankAccounts.size(); i++)
		{
			if (bankAccounts.get(i).getAccountId().equals(id) && 
			    password.equals(bankAccounts.get(i).getPassword()))
			{
				bankAccounts.get(i).withdraw(amount);
			}
		}
	}
	
	public double displayBalance(String id, String password)
	{
		double balance = 0.0;
		
		for (int i = 0; i < bankAccounts.size(); i++)
		{
			if (bankAccounts.get(i).getAccountId().equals(id) && 
			    password.equals(bankAccounts.get(i).getPassword()))
			{
				balance = bankAccounts.get(i).getAccountBalance();
			}
		}
		
		return balance;
	}
	
	public Date displayDate(String id, String password)
	{
		Date date = new Date();
		
		for (int i = 0; i < bankAccounts.size(); i++)
		{
			if (bankAccounts.get(i).getAccountId().equals(id) && 
				password.equals(bankAccounts.get(i).getPassword()))
			{
				date = bankAccounts.get(i).getDateCreated();
			}
		}
		
		return date;
	}
	
	public String displayTypeOfAccount(String id, String password)
	{
		for (BankAccount account: bankAccounts)
		{
			if (account.getAccountId().equals(id) && 
			   (account.getPassword().equals(password)))
			{
				if (account instanceof CurrentAccount)
				{
					return "Current";
				}
				else if (account instanceof SavingsAccount)
				{
					return "Saving";
				}
				else
				{
					return "Basic";
				}
			}
		}
		
		return null;
	}
	
	public double displayInterest(String id, String password)
	{
		double interest = 0.0;
		
		for (int i = 0; i < bankAccounts.size(); i++)
		{
			if (bankAccounts.get(i).getAccountId().equals(id) && 
			    password.equals(bankAccounts.get(i).getPassword()))
			{
					interest = bankAccounts.get(i).getMonthlyInterestRate();
			}
		}
		
		return interest;
	}
}


