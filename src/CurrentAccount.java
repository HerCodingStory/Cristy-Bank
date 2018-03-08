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

public class CurrentAccount extends BankAccount
{
	private double overdraftLimit;
	
	public CurrentAccount(double amount, String name)
	{
		super(amount, name);
		this.overdraftLimit = 0;
	}

	public double getOverdraftLimit() 
	{
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) 
	{
		this.overdraftLimit = overdraftLimit;
	}
	
	public void withdraw(double amountToWithdraw)
	{
		if (amountToWithdraw >= (getAccountBalance() + overdraftLimit))
		{
			System.out.println("We are sorry, You have exceeded your overdraft limit.");
		}
		else if (amountToWithdraw <= 0)
		{
			System.out.println("Amount entered is incorrect. Please use positive"
					+ " numbers.");
		}
		else
		{
			setAccountBalance(getAccountBalance() - amountToWithdraw);
		}
	}
}
