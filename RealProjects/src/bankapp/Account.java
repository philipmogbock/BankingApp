package bankapp;

public abstract class Account implements IBaseRate{
	//fields
	//common properties for savings and checking accounts
	private String name;
	private String sSN; //social security number
	protected String accountNumber;
	private double balance;
	protected double rate;
	private static int index=10000;
	
	
	
	// constructor to initailizes base properties of account 
	//initial deposit is initDeposit
	public Account(String name, String ssN, double initDeposit){
		this.name=name;
		this.sSN=ssN;
		balance=initDeposit;
		this.accountNumber=setAccountNumber();
		//increment the index that we will use for unique 5 digit number
		index++;
		setRate();
		
	}
	
	//setters
	
	
	//set the rate specific to each class within the class
	public abstract void setRate();
	
		
	
	private String setAccountNumber() {
		//last 2 digits of the ssn
		String lastTwoOfSSN= sSN.substring(sSN.length()-2);
		
		//unique 5 digit number....unique singifies the use of a static value 
		int uniqueNum = index;
		
		//random 3 digit number
		String allNums= "123456789";
		char[] num = new char[3];
		
		for(int i=0; i<3; i++) {
			int randomNumIndex= (int) (Math.random()*allNums.length());
			num[i]= allNums.charAt(randomNumIndex);
		}
		String random3DigitNum= new String(num);
		
//		for 3 digit random number you can also do 
//		int randomNumber= (int) (Math.random()*Math.pow(10, 3));
		
		
		return lastTwoOfSSN+uniqueNum+random3DigitNum;			
	}
	
	
	
	//getters
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	
	public void compound() {
		double accruedInterest= balance* (rate/100);
		balance+=accruedInterest;
		System.out.println("Accrued interest $"+ accruedInterest);
		printBalance();
		
	}
	
	//Common methods relating to Transactions
	public void deposit(double amount) {
		balance+=amount;
		System.out.println("Deposited $"+amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance-=amount;
		System.out.println("withdrew $"+amount);
		printBalance();
	}
	
	
	public void transfer(String toWhere, double amount) {
		balance-=amount;
		System.out.println("Transferred $"+amount+ "to "+toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now $"+balance);
	}
	
	
	public void showinfo() {
		System.out.println("Name: "+ name +
				"\nAccount NUmber: "+accountNumber+
				"\nBalance: "+balance+
				"\nRate: "+ rate+
				"\n****************");
		
	}
}
