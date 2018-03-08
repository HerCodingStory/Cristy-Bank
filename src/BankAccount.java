/*---------------------------------------------------

 Name:  Cristina Villarroel

 Student ID: A32825495

 COP 2800 - Java Programming 

 Spring 2015 - T Th 6:00PM - 9:20PM

 Project # 2

 Plagiarism Statement

 I certify that this assignment is my own work and that I
 have not copied in part or whole or otherwise plagiarized 
 the work of other students and/or persons.*/

import java.util.Date;
import java.util.Random;

class BankAccount 
{
	private String accountId;
	private double accountBalance;
	static private double annualInterestRate;
	private Date dateCreated;
	private String name;
	private String password;
	
	BankAccount() 
	{
		accountId      = randomDigits();
		accountBalance = 0.0;
		dateCreated    = new Date();
		name           = "";
		password       = randomLetters();
	}
	
	BankAccount(double newAccountBalance, String name)
	{
		accountId      = randomDigits();
		accountBalance = newAccountBalance;
		dateCreated    = new Date();
		this.name      = name;
		password       = randomLetters();
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getPassword() 
	{
		return password;
	}

	public double getAccountBalance() 
	{
		return accountBalance;
	}

	public void setAccountBalance(double newAccountBalance) 
	{
		this.accountBalance = newAccountBalance;
	}

	public static double getAnnualInterestRate() 
	{
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double newAnnualInterestRate) 
	{
		BankAccount.annualInterestRate = newAnnualInterestRate;
	}
	
	public String getAccountId() 
	{
		return accountId;
	}

	public Date getDateCreated() 
	{
		return dateCreated;
	}

	double getMonthlyInterestRate()
	{
		return annualInterestRate / 12;
	}

	public void withdraw(double amount)
	{	
		double balanceCheck = this.getAccountBalance();
		
		if (amount > balanceCheck)
		{
			System.out.println("Error: Available Balance is not enought to cover "
								+ "a withdrawal from your account.");
		}
		else if (amount < 0)
		{
			System.out.println("Amount entered is incorrect. Please use positive"
								+ " numbers.");
		}
		else
		{
			accountBalance -= amount;
		}
	}

	public void deposit(double amount)
	{
		if (amount < 0)
		{
			System.out.println("Amount entered is incorrect. Please use positive "
								+ "numbers.");
		}
		else
		{
			accountBalance += amount;
		}
	}
	
	public String randomLetters()
	{
		char[] chars     = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random    = new Random();
	
		for (int i = 0; i < 4; i++)
		{
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		
		return sb.toString();
	}
	
	public String randomDigits()
	{
		Random random    = new Random();
		StringBuilder sb = new StringBuilder ();
		
		for (int i = 0; i < 4; i++)
		{
			sb.append((char)('0' + random.nextInt(10)));
		}
		
		return sb.toString();
	}
}