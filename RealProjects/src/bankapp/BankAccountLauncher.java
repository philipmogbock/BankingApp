/**
 * Author Philip Mogbock
 * This is a basic Bank Account App
 * It demonstrates my understanding of key object oriented programming concepts
 * Within this this app I demonstrate my understanding of:
 * Interfaces see the IBaseRate Class
 * Abstract classes and methods as well as Inheritance. These are demonstrated in the Account super class and the Savings and Checking subclasses
 * Polymorphism  when casting to different datatypes
 * Use of collections with Lists and arraylists 
 * Finally I also demonstrated my knowledge of file input/output by creating a function to read in a CSV file and assign the contents to different variable
 * 
 * 
 */


package bankapp;

import java.util.LinkedList;
import java.util.List;


public class BankAccountLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Account> accounts = new LinkedList<>();
		
		
		List<String[]> newAccountHolders = CSV.read("original.csv");
		
		for (String[] accountHolder:newAccountHolders) {
			String name= accountHolder[0];
			String sSN= accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
//			System.out.println("Name:"+accountHolder[0]+ "	sSN:"+accountHolder[1]+ "	Account Type:"+accountHolder[2]+"	Deposit: $"+ accountHolder[3]);
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			}
			
			else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
			
		}
		
		for(Account account: accounts) {
			System.out.println("*****************************************");
			account.showinfo();
			System.out.println();
		}
	}

}
