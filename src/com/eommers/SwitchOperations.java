package com.eommers;

import java.util.Scanner;

public class SwitchOperations {

	Scanner sc = new Scanner(System.in);
	UserOperations userOperations =new UserOperations();
	AdminOperationDetails adminOperationDetails =new AdminOperationDetails();
	GuestOperations GuestOperations = new GuestOperations();
	boolean loop=true;
	int option;
	
	
	public void ecommersDetails() {
		System.out.println("****************************************");
		System.out.println("Welcome to E-Commerce based application ");
		System.out.println("****************************************");
		System.out.println("1. User Operation");
		System.out.println("2. Admin Operation");
		System.out.println("3. Guest Operation");
		System.out.println("0. Close application");
		System.out.println("----------------------------------------");
		
	    System.out.println("Enter your choice :");
		int option = sc.nextInt();
		System.out.println("----------------------------------------");
		
		switch(option) {
		case 0 :
			loop=false;
			break;
		case 1 :
			this.userOperationDetails();
			break;
		case 2 :
			this.adminOperationDetails();
			break;
		case 3 :
			GuestOperations.viewProductDetailsToGuest();
			break;
		default :
				System.out.println("Invlid input");
			
		}
	}
	
	public void userOperationDetails() {
		System.out.println("----------------------------------------");
		System.out.println("Please select the option as your choice");
		System.out.println("----------------------------------------");
		System.out.println("4. User Registration");
		System.out.println("5. User login");
		System.out.println("6. See product");
		System.out.println("7. Buy Product");
		System.out.println("8. view cart");
		System.out.println("9. Calculate Bill");
		System.out.println("0. Close application");
		System.out.println("----------------------------------------");
		
		
		do {
			System.out.println("Enter your choice :");
			 option = sc.nextInt();
			switch(option) {
		case 0 :
			loop=false;
			break;
		case 4:
			userOperations.execute(2);
			break;
		case 5 :
			userOperations.userLogin();
			break;
		case 6 :
			userOperations.viewProductDetailsToUser();;
			break;
		case 7 :
			userOperations.detailsOfBuyProduct();
			break;
		case 8 :
			userOperations.getViewCart();
			break;
		case 9 :
			adminOperationDetails.calculateBill();
			break;
		default :
				System.out.println("Invlid input");
				
				
			
		}
		}while(loop);
	}
	
	public void adminOperationDetails() {
		System.out.println("----------------------------------------");
		System.out.println("Please enter admin login details");
		//System.out.println("----------------------------------------");
		System.out.println("Enter username :");
		String username = sc.next();
		System.out.println("Enter password :");
		String pass = sc.next();
		System.out.println("----------------------------------------");
		
		
		if((username.equals("admin")) && (pass.equals("admin"))){
		System.out.println("----------------------------------------");
		System.out.println("Please select the option as your choice");
		System.out.println("----------------------------------------");
		System.out.println("1. Add product item");
		System.out.println("2. Calculate Bill");
		System.out.println("3. Check Quantity");
		System.out.println("4. Check register user");
		System.out.println("1. Check perticular register history");
		System.out.println("0. Close application");
		System.out.println("----------------------------------------");
		do{
			System.out.println("Enter your choice :");
			option = sc.nextInt();
		    System.out.println("----------------------------------------");
		switch(option) {
		case 1:
			adminOperationDetails.getProductDetailAsInput();
			break;
		case 2:
			adminOperationDetails.calculateBill();
			break;
		case 3:
			adminOperationDetails.checkQuantity();
			break;
		case 4:
			adminOperationDetails.checkRegisteredUser();
			break;
		case 5:
			adminOperationDetails.checkPerticularUserHistory();
			break;
		case 0 :
			loop=false;
			break;
		default :
				System.out.println("Invlid input");
		}
			
		}while(loop);
		}
		else {
			System.out.println("Incorrect login details");
		}
	
}
}