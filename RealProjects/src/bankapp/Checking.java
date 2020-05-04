package bankapp;

public class Checking extends Account {
	
	//fields specific to a checking account
	private int debitCardNumber; 
	private int debitCardPin;
	
	
	public Checking(String name, String ssN, double initDeposit) {
		super(name, ssN, initDeposit);
		accountNumber="2" + accountNumber;
		setDebitCard();
		

		
		
	}


	@Override
	public void setRate() {
		// checking interest rate is 15% of the base rate
		this.rate=getBaseRate()* 0.15;
	}
	
	
	
	
	//methods specific to Savings Account
	
	private void setDebitCard() {
		debitCardNumber= (int) (Math.random()*Math.pow(10, 12));
		debitCardPin= (int) (Math.random()*Math.pow(10, 4));
	}


	
	public void showinfo() {
		super.showinfo();
		System.out.println("Checking Account Details"
				+ "\nDebit Card Number: "+ debitCardNumber
				+ "\nDebit Card Pin: "+ debitCardPin);
		
	}

}
