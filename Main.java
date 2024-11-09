package com.org.bank;

import java.util.Scanner;

import com.org.bank.dao.*;
import com.org.bank.model.Account;

public class Main {
	public static void main(String[] args) throws Exception {
		AccountDAO accountDAO=new AccountDAOImpl();
		TransactionDAO transactionDAO=new transactiondaoimpl();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n****Banking Application Menu****");
			System.out.println("1.Create a New Account");
			System.out.println("2.View Account Details");
			System.out.println("3.Update Account Information");
			System.out.println("4.Deposit Money");
			System.out.println("5.Withdraw Money");
			System.out.println("6.Transfer Money");
			System.out.println("7.View Transaction");
			System.out.println("8.Check Balance");
			System.out.println("9.Exit");
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			sc.nextLine();
			switch(ch) {
			case 1:
				System.out.println("Enter account holder name:");
				String accholder=sc.nextLine();
				System.out.println("Enter the account type(Savings/Current):");
				String acctype=sc.nextLine();
				System.out.println("Enter the initial balance:/");
				double balance=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter address:");
				String address=sc.nextLine();
				System.out.println("Enter the contact number:");
				String phno=sc.nextLine();
				Account newAccount=new Account(0,accholder,acctype,balance,address,phno);
				try {
					accountDAO.createAccount(newAccount);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter accountID to view:");
				int viewAccountId=sc.nextInt();
				Account retrievedAccount=accountDAO.viewAccount(viewAccountId);
				if(retrievedAccount!=null) {
					System.out.println("Account Details:"+retrievedAccount);
				}
				else {
					System.out.println("Account not found.");
				}
				break;
			case 3:
				System.out.println("Enter the account ID to update:");
				int updateAccountId=sc.nextInt();
				sc.nextLine();
				System.out.print("Enter new address:");
				String newAddress=sc.nextLine();
				System.out.println("Enter the new contact number:");
				String newContact=sc.nextLine();
				accountDAO.updateAccountInfo(updateAccountId, newAddress, newContact);
				break;
			case 4:
				System.out.println("Enter the account id to deposit into:");
				int depositAccountId=sc.nextInt();
				System.out.println("Enter the amount to deposit:");
				double depositAmount=sc.nextDouble();
				transactionDAO.deposit(depositAccountId, depositAmount);
				break;
			case 5:
				System.out.println("Enter the account id to withdraw from:");
				int withdrawAccountId=sc.nextInt();
				System.out.println("Enter the amount to withdraw:");
				double withdrawAmount=sc.nextDouble();
				transactionDAO.withdraw(withdrawAccountId, withdrawAmount);
			}
		} 
	}
}
