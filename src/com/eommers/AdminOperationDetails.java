package com.eommers;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminOperationDetails {
	
	
	
	Scanner sc = new Scanner(System.in);
	PreparedStatement prs=null;
	Connection con=null;
	Statement stmt =null;
	ResultSet rs =null;
	public  boolean loop;
	
	public void insertProductDetails(int productId, String productName, 
			String productDesc, int productQuantity, int productPrice) {
		
		try {
			
			con=ConnectionDetails.getConnectionDetails();
			prs=con.prepareStatement("insert into ecommersdata.ProductDetails(productId1,productName1,"
					+ "productDesc1,productQuantity1,productPrice1)values(?,?,?,?,?)");
			prs.setLong(1, productId);
			prs.setString(2, productName);
			prs.setString(3, productDesc);
			prs.setLong(4, productQuantity);
			prs.setLong(5, productPrice);
			int i= prs.executeUpdate();
			//System.out.print("Product added successfully.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				prs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void getProductDetailAsInput() {
		try {
			//for(int i=0; i<input; i++) {
				
				System.out.println("Enter product id >>");
				int productId=sc.nextInt();
				System.out.println("Enter product name >>");
				String productName=sc.next();
				System.out.println("Enter product description >>");
				String productDesc=sc.next();
				System.out.println("Enter product quantity >>");
				int productQuantity=sc.nextInt();
				System.out.println("Enter product price >>");
				int productPrice=sc.nextInt();
				this.insertProductDetails(productId, productName, productDesc, productQuantity, productPrice);
				System.out.print("Product added successfully.");
				//sc.close();
				
			//}		
		}catch(Exception e ) {
			System.err.println("Enter valid input");
		}
		
		
		
	}
	
	public void calculateBill() {
		Connection con = null;
		try {
			
			con=ConnectionDetails.getConnectionDetails();
			  stmt = con.createStatement();
			 System.out.println("Enter Product id :");
        	 int id1 =sc.nextInt();
			
			 rs = stmt.executeQuery("SELECT * FROM ecommersdata.productdetails WHERE"
			 		+ " productId1 = '" +id1+ "'" );
	     
	        	 rs.next();
	        	 int price = rs.getInt("productPrice1");
	        	 int id = rs.getInt("productId1");
	        	 
	        	 if((id1==id) ) {
	        	 System.out.println("Product id is : " +id); 
	             System.out.println("Product Price: " +price);
	             loop=true;
	        	 }
	        	 else {
	        		 System.out.println("No data found");
	        	 }
	        	
	         
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
		public void checkQuantity() {
			Connection con = null;
			try {
				
				con=ConnectionDetails.getConnectionDetails();
				  stmt = con.createStatement();
				 System.out.println("----------------------------------------");
				 System.out.println("Enter Product id :");
	        	 int id1 =sc.nextInt();
				
				 rs = stmt.executeQuery("SELECT * FROM ecommersdata.productdetails WHERE"
				 		+ " productId1 = '" +id1+ "'" );
		     
		        	 rs.next();
		        	 int quantity = rs.getInt("productQuantity1");
		        	 int id = rs.getInt("productId1");
		        	 
		        	 if((id1==id) ) {
		             System.out.println("----------------------------------------");
		        	 System.out.println("Product id is : " +id); 
		             System.out.println("Product Quantity: " +quantity);
		             System.out.println("----------------------------------------");
		             
		        	 }
		        	 else {
		        		 System.out.println("No data found");
		        	 }
		        	
		         
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			finally {
				try {
					con.close();
					stmt.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	
	public void checkRegisteredUser() {
		Connection con = null;
		try {
			
			con=ConnectionDetails.getConnectionDetails();
			  stmt = con.createStatement();
			
        	         String query =("SELECT * FROM ecommersdata.UserDetails");	
        	         prs=con.prepareStatement(query );
			 rs = prs.executeQuery();
			 System.out.println("All customers data :");
	     
	        	 while(rs.next()) {
	        		 int regId1 = rs.getInt("registerId");
	        	     String username = rs.getString("username");
                     String firstName = rs.getString("firstName");
                     String lastName = rs.getString("lastName");
                     String mailid = rs.getString("mailid");
                     long mobileNo = rs.getLong("mobileNo");
	        	
	            
	             System.out.println("---------------------------------------------------------");
	        	 System.out.println("Customer Registration id is : " +regId1); 
	        	 System.out.println("Customer username is : " +username); 
	             System.out.println("Customer's First-name is: " +firstName);
                 System.out.println("Customer's last-name is: " +lastName);
                 System.out.println("Customer's mailid is: " +mailid);
                 System.out.println("Customer's Mobile number is: " +mobileNo);
                 System.out.println("---------------------------------------------------------");
                 
	             
	        	 }
		
	         
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
				prs.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void checkPerticularUserHistory() {
		Connection con = null;
		try {
			
			con=ConnectionDetails.getConnectionDetails();
			  stmt = con.createStatement();
			 System.out.println("Enter register id :");
        	int id1 =sc.nextInt();
			
			 rs = stmt.executeQuery("SELECT * FROM ecommersdata.UserDetails WHERE"
			 		+ " registerId = '" +id1+ "'" );
	     
	        	 rs.next();
	        	 int regId1 = rs.getInt("registerId");
	        	 String username = rs.getString("username");
                         String firstName = rs.getString("firstName");
                         String lastName = rs.getString("lastName");
                         String mailid = rs.getString("mailid");
                         long mobileNo = rs.getLong("mobileNo");
	        	 while(rs.next()) {
	        		
	     			
	        	 if((id1==regId1) ) {
	        	 System.out.println("Customer Details: Redistration id" +regId1); 
	        	 System.out.println("Username is: " +username);
	             System.out.println("First-name is: " +firstName);
                 System.out.println("last-name is: " +lastName);
                 System.out.println("mailid is: " +mailid);
                 System.out.println("Mobile number is: " +mobileNo);
                 loop=true;
	        	 
	             
	             
	        	 }
	        	 else {
	        		 System.out.println("No data found");
	        	 }
	        	 }
	         
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
