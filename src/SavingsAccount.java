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

public class SavingsAccount extends BankAccount
{
	private double interest;
	
	public SavingsAccount(double amount, String name)
	{
		super(amount, name);
		this.interest = 0;
	}

	public double getInterest()
	{
		return interest;
	}

	public void setInterest(double interest)
	{
		this.interest = interest;
	}
	
	public void addInterest()
	{
		double inter = interest + (getAccountBalance() * getMonthlyInterestRate());
		deposit(inter);
	}
}
