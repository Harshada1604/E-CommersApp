package com.eommers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GuestOperations {
	Scanner sc = new Scanner(System.in);
	PreparedStatement ps=null;
	Connection con=null;
	Statement stmt =null;
	ResultSet rs =null;
	public  boolean loop;
	
	
			
    public void viewProductDetailsToGuest() {
			 //productId1, productName1, productDesc1, productQuantity1, productPrice1);
			   Connection con = null;
			   		try {
			   			
			   			con=ConnectionDetails.getConnectionDetails();
			   			  stmt = con.createStatement();
			   			
			           	         String query =("SELECT * FROM ecommersdata.productDetails");	
			           	         ps=con.prepareStatement(query );
			   			 rs = ps.executeQuery();
			   			 System.out.println("===========Available products=========== ");
			   	     
			   	        	 while(rs.next()) {
			   	        		
			   	        		 int productId = rs.getInt("productId1");
			   	        		 String productName = rs.getString("productName1");
			   	        	     String productDesc = rs.getString("productDesc1");
			                     int productQuantity = rs.getInt("productQuantity1");
			                     int productPrice = rs.getInt("productPrice1");
			                      
			   	             System.out.println("----------------------------------------");
			   	             System.out.println("Product id is \t\t: " +productId); 
			   	             System.out.println("Product name is \t: " +productName); 
			   	        	 System.out.println("Product description is \t: " +productDesc); 
			   	             System.out.println("Product quantity is\t: " +productQuantity);
			                 System.out.println("Product price is\t: " +productPrice);
			                 System.out.println("----------------------------------------");
			                 }
			   	        	
			   		
			   		}catch(Exception e) {
			   			e.printStackTrace();
			   			
			   		}
			   		finally {
			   			try {
			   				con.close();
			   				ps.close();
			   				rs.close();
			   			} catch (SQLException e) {
			   				// TODO Auto-generated catch block
			   				e.printStackTrace();
			   			}
			   		}
			   		System.out.println("If you want to buy produts \nthen you have to register first.");
			   	    System.out.println("----------------------------------------");
			   	}
    
	}


