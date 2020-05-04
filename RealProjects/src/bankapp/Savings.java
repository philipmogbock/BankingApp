package bankapp;

public class Savings extends Account {
	
	//fields specific to a savings account
	//saefty deposit box identified by 3 digit id 
	private int safetyDepositBoxID;
	// access the safety deposit box with the 4 digit 4
	private int safetyDepositBoxKey;
	
	
	
	
	public Savings(String name, String ssN, double initDeposit) {
		super(name, ssN, initDeposit);
		accountNumber="1" + getAccountNumber();
		setSafetyDepositBox();

		
	}



//	implement method in the interface that determines class specific interest rate
	@Override
	public void setRate() {
		// savings  interest rate is 0.25 points less than the base rate
		this.rate=getBaseRate()-0.25;
	}
	
	
	
	//methods specific to Savings Account
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID=(int) (Math.random()*Math.pow(10, 3));
		safetyDepositBoxKey=(int) (Math.random()*Math.pow(10, 4));
	}
	
	
	
	public void showinfo() {
		super.showinfo();
		System.out.println("Savings Account Details"
				+ "\nSafety Deposit Box  ID: "+safetyDepositBoxID +
				"\nSafety Deposit Box Key: " +safetyDepositBoxKey);
;
		
	}
	


}
