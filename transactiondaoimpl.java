package com.org.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.bank.utils.DatabaseConnection;

public class transactiondaoimpl implements TransactionDAO{

	@Override
	public void deposit(int accountId, double amount) throws Exception {
		// TODO Auto-generated method stub
		try (Connection conn=DatabaseConnection.getConnection()){
			String updateBalanceQuery="Update account set balance=balance+? where accid=?";
			String insertTransactionQuery="insert into transaction(accid,transtype,amount)values(?,'Deposit',?)";
			executeTransaction(conn,accountId,amount,updateBalanceQuery,insertTransactionQuery);
			System.out.println("Deposit of $ "+amount+" to account"+accountId+" completed....");
		}
		
	}
	
	private double getCurrentBalance(Connection conn,int accountId) throws SQLException{
		String checkBalanceQuery="Select balance from account where accid=?";
		try(PreparedStatement ps=conn.prepareStatement(checkBalanceQuery)){
			ps.setInt(1, accountId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getDouble("balance");
			}
		}
		return 0;
	}
	
	private String getAccountType(Connection conn,int accountId) throws SQLException{
		String sql="Select acctype from account where accid=?";
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setInt(1,accountId);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getString("acctype");
			}else {
				throw new SQLException("Account not found...");
		}
		}
	}
	private double getOverdraftLimit(Connection conn,int accountId)throws SQLException{
		String sql="Select overdraft_limit from currentaccountwhere accid=?";
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setInt(1,accountId);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getDouble("overdraft_limit");
			}else {
				throw new SQLException("Current account not found or overdraft limit not set.....");
		}
			}
		
	}
	@Override
    public void withdraw(int account_id, double amount) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
      conn.setAutoCommit(false);
      String accounttype = getAccountType(conn, account_id);
      double currentbalance = getCurrentBalance(conn, account_id);
      if(accounttype.equals("current")) {
    	  double overdraftlimit =getOverdraftLimit(conn,account_id);
    	  if(amount>=overdraftlimit) {
    		  throw new Exception("Insufficient balance !");
    	  }
      }if(amount>currentbalance) {
    	  throw new Exception("insufficient balnce for withdrawal");
      }
      
      String updateBalanceQuery= "UPDATE Account SET balance = balance - ? WHERE accid=?";
      String InsertTransactionQuery = "INSERT INTO transaction (accid,transtype,amount) VALUES(?,'withdrawal',?)";
      executeTransaction(conn, account_id, amount, updateBalanceQuery, InsertTransactionQuery);
      
      conn.commit();  
      
      System.out.println("Withdrawal of Rs." + amount + " from account " + account_id + " has been completed successfully");
        }
    }

	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTransactionHistory(int accountId) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void executeUpdate(Connection conn,String query,double amount,int accountId ) throws SQLException {
		try(PreparedStatement ps=conn.prepareStatement(query)){
			ps.setDouble(1, amount);
			ps.setInt(2, accountId);
			ps.executeUpdate();
		}
	}
	private void executeTransaction(Connection conn,int accountId,double amount,String updateBalanceQuery,String insertTransactionQuery ) throws SQLException {
		executeUpdate(conn,updateBalanceQuery,amount,accountId);
		try(PreparedStatement ps=conn.prepareStatement(insertTransactionQuery)){
			ps.setInt(1,accountId);
			ps.setDouble(2, amount);
			ps.executeUpdate();
		}
	}
}
