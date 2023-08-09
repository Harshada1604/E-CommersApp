package com.eommers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserOperations {
	Scanner sc = new Scanner(System.in);
	PreparedStatement ps=null;
	Connection con=null;
	Statement stmt =null;
	ResultSet rs =null;
	public  boolean loop;
	int quantity2;
	     
	public void insertUserdata(String firstname,String lastname,String username,String password,String city,long mobilenumber,String mailid) {
		try {
			
			con=ConnectionDetails.getConnectionDetails();
			// mtysql column name registerId, firstName, lastName, username, userPass, city, mailid, mobileNo
			String query= "insert into ecommersdata.UserDetails (firstName, lastName,username,userpass,city,mobileNo,mailid)"+ "values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1,firstname );
			ps.setString(2,lastname );
			ps.setString(3,username );
			ps.setString(4,password );
			ps.setString(5,city);
			ps.setLong(6,mobilenumber );
			ps.setString(7,mailid );
			
		   int i=ps.executeUpdate();
		 //  System.out.println("Data Inserted Succesfully.....!"+i);
	
		} catch (Exception e) {
			
		} finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	   
	   
   }
   
   public void execute(int input) {
	   Scanner sc= new Scanner(System.in); 
	   
	   for(int i=0; i<input;i++);
	   System.out.println("<<Enter the firstname>>");
	   String firstname=sc.next();
	   System.out.println("<<Enter the lastname>>");
	   String lastname=sc.next();
	   System.out.println("<<Enter the username>>");
	   String username=sc.next();
	   System.out.println("<<Enter the password>>");
	   String password=sc.next();
	   System.out.println("<<Enter the city>>");
	   String city=sc.next();  
	   System.out.println("<<Enter the mobilenumber>>");
	   long mobilenumber=sc.nextLong();
	   System.out.println("<<Enter the mailid>>");
	   String mailid=sc.next();
	   
	   this.insertUserdata(firstname, lastname, username, password, city, mobilenumber, mailid);
	   
	   System.out.println("Data Inserted Succesfully......");
	   System.out.println("----------------------------------------");
	   System.out.println("5. User login");
		System.out.println("0. Close application");
		System.out.println("----------------------------------------");
   }	
   
   
   public void userLogin() {
	   String username;
	   String password;
	  
		try {
			
			     con=ConnectionDetails.getConnectionDetails();
			     stmt = con.createStatement();
			     System.out.println("Enter username :");
       	         String username1 =sc.next();
                 System.out.println("Enter passwords");
       	         String password1 =sc.next();
       	         String query =("SELECT * FROM ecommersdata.UserDetails");	
       	         
       	         ps=con.prepareStatement(query);
			     rs = ps.executeQuery();
			     
			      rs.next();
	        	  username = rs.getString("username");
                  password = rs.getString("userPass");
                    
                  //System.out.println(username+ " " +password);
                
	            if((username1.equals(username)) && (password1.equals(password))) {
	             System.out.println("Congratulations...!!");
                 System.out.println("login successful");
	            }
	           else {
	            	System.out.println("Incorrect login informtion");
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
	}
   
   public void viewProductDetailsToUser() {
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
	   	        	 this.detailsOfBuyProduct();
	   		
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
	   	}
   public void detailsOfBuyProduct() {
	  
	   Connection con = null;
	
	try {
		
		 con=ConnectionDetails.getConnectionDetails();
		 stmt = con.createStatement();
		 // rs = stmt.executeQuery("SELECT * FROM ecommersdata.productdetails " );
   
      	 // rs.next();
      	 // int quantity3 = (rs.getInt("productQuantity1"))
      	  
      	  
		   System.out.println("Enter product id:");
           int productId = sc.nextInt();
           System.out.println("Enter the quantity :");
           int quantity = sc.nextInt();
      	  
           rs = stmt.executeQuery("SELECT * FROM ecommersdata.productdetails " );
           rs.next();
           int totalQuantity= (rs.getInt("productQuantity1"))-quantity;
           PreparedStatement prs = con.prepareStatement("UPDATE ecommersdata.ProductDetails SET productQuantity1=? WHERE productId1=?");
           prs.setInt(1, totalQuantity);
           prs.setInt(2, productId);
           int rowsAffected = prs.executeUpdate();
           
            if (rowsAffected > 0) {
            	  System.out.println("---------------------------------------------------------");
                  System.out.println("Your product is added in view cart.");
                  System.out.println("Go to view cart to generate your bill amount");
                  System.out.println("---------------------------------------------------------");
             } else {
               System.out.println("Your product is not added in view cart.");
          }
                } catch (SQLException e) {
             e.printStackTrace();
         } finally {
                 try {
               if (con != null) {
                con.close();
            }
          } catch (SQLException e) {
              e.printStackTrace();
        }
    }
}

   public void  getViewCart() {
	 //productId1, productName1, productDesc1, productQuantity1, productPrice1)
	   
	            System.out.println("Enter username :");
	            String username1=sc.next();
	   	
	           try{
	             con = ConnectionDetails.getConnectionDetails();
	             String query =( "select productId1,productName1,productDesc1,"
	             		+ "productQuantity1,productPrice1 from  ecommersdata.CartDetails1 "
	             		+ "cart join ecommersdata.UserDetails user on cart.regId = user.registerId"
	             		+ " join ecommersdata.ProductDetails product on "
	             		+ "product.productId1 = cart.prodid  where username = ? "
	             		+ "order by productid1");
	           
	             ps = con.prepareStatement(query);
	             ps.setString(1, username1);
	             rs = ps.executeQuery();
	             
	             while(rs.next()) {
	               System.out.println("Product Id>> " +rs.getInt(1));
	               System.out.println("Product Name>> " +rs.getString(2));
	               System.out.println("Product Description>> " +rs.getString(3));
	               System.out.println("Available Quantity>> " +rs.getInt(4));
	               System.out.println("Price>> " +rs.getDouble(5));
	             }
	           }catch (Exception e) {
	               System.out.println(e);
	           } finally {
	             try {
	               con.close();
	               ps.close();
	             } catch (SQLException e) {
	               e.printStackTrace();
	             }
	           } System.out.println(" Done....");
	       }
	   	      
	   
   }
   
   
   
	