package com.org.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.org.bank.model.Account;
import com.org.bank.utils.DatabaseConnection;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void createAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		String sql="Insert into account(accholder,acctype,balance,address,phno) values (?,?,?,?,?)";
		try(Connection conn=DatabaseConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
			 stmt.setString(1,account.getAccholder());
			 stmt.setString(2,account.getAcctype());
			 stmt.setDouble(3,account.getBalance());
			 stmt.setString(4,account.getAddress());
			 stmt.setString(5,account.getPhno());
			 int affectedRows=stmt.executeUpdate();
			 if(affectedRows>0) {
				 ResultSet generatedKeys=stmt.getGeneratedKeys();
				 if(generatedKeys.next()) {
					 int accountId=generatedKeys.getInt(1);
					 if(account.getAcctype().equals("Savings")) {
						 String sqlsavingAccount="Insert into SavingsAccount(accid,interest_rate)values(?,?)";
						 PreparedStatement stmtSaving=conn.prepareStatement(sqlsavingAccount);
						 stmtSaving.setInt(1,accountId);
						 stmtSaving.setDouble(2,0.4);
						 stmtSaving.executeUpdate();
					 }
					 else if(account.getAcctype().equals("Current")){
						 String sqlCurrentAccount="insert into CurrentAccount(accid,overdraft_limit)values(?,?)";
						 PreparedStatement stmtCurrent=conn.prepareStatement(sqlCurrentAccount);
						 stmtCurrent.setInt(1,accountId);
						 stmtCurrent.setDouble(2,5000.00);
						 stmtCurrent.executeUpdate();
					 }
				 }
			 }
		}
		System.out.println("Account created successfully...");
	}

	@Override
	public Account viewAccount(int accountId) throws Exception {
		// TODO Auto-generated method stub
		String sql="Select * from account where accid= ? ";
		Account account=null;
		try (Connection conn=DatabaseConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql)){

			stmt.setInt(1, accountId);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				account=new Account(rs.getInt("accid"),rs.getString("accholder"),rs.getString("acctype"),rs.getDouble("balance"),rs.getString("address"),rs.getString("phno"));
			}
			if(account!=null) {
				System.out.println("Account details retrieved successfully...");
			}
			else {
				System.out.println("Account not found....");
			}
		}
			return account;
	}

	@Override
	public void updateAccountInfo(int accountId, String newAddress, String newContact) throws Exception {
		// TODO Auto-generated method stub
		String sql="Update account set address= ?,phno=? where accid=?";
		try (Connection conn=DatabaseConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, newAddress);
			stmt.setString(2, newContact);
			stmt.setInt(3, accountId);
			int rowsAffected=stmt.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Account information Updated Successfully...");
			}
			else {
				System.out.println("Account not found or update failed");
			}
		}
		
	}

	@Override
	public void getBalance(int accountId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
