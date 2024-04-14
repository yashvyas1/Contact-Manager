package com.jspiders.contactmanagerwithjdbc.operations;

import java.util.Scanner;

import com.jspiders.contactmanagerwithjdbc.jdbclogic.JDBCLogic;

public class ContactOperations {

	public static void addContact(Scanner scanner) {

		System.out.println("Enter id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter your first name");
		String firstName = scanner.nextLine();
		System.out.println("Enter your last name");
		String lastName = scanner.nextLine();
		System.out.println("Enter your mobile number");
		long mobileNumber = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter your email");
		String email = scanner.nextLine();
		System.out.println("Select category");
		System.out.println("1. Family\n"
						 + "2. Friend\n"
						 + "3. Colleague");
		String category = null;
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			category = "Family";
			break;
		case 2:
			category = "Friend";
			break;
		case 3:
			category = "Colleague";
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		
		JDBCLogic.addData(id, firstName, lastName, mobileNumber, email, category);
	}

	public static void viewContact() {
		JDBCLogic.viewData();
		
	}

	public static void editContact(Scanner scanner) {
		
		System.out.println("Enter the id of the contact you want to edit");
		int id = scanner.nextInt();
		System.out.println("What do you want to edit?");
		System.out.println("1. First Name\n"
					 	 + "2. Last Name\n"
					 	 + "3. Mobile Number\n"
					 	 + "4. Email\n"
					 	 + "5. Category");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			editFirstName(scanner,id);
			break;
		case 2:
			editLastName(scanner, id);
			break;
		case 3:
			editMobileNumber(scanner, id);
			break;
		case 4:
			editEmail(scanner, id);
			break;
		case 5:
			editCategory(scanner, id);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		
		
	}

	private static void editFirstName(Scanner scanner, int id) {
		
		System.out.println("Enter new First Name");
		scanner.nextLine();
		String firstName = scanner.nextLine();
		JDBCLogic.updateFirstName(firstName, id);	
	}
	
	private static void editLastName(Scanner scanner, int id) {

		System.out.println("Enter new Last Name");
		scanner.nextLine();
		String lastName = scanner.nextLine();
		JDBCLogic.updateLastName(lastName, id);	
	}
	
	private static void editMobileNumber(Scanner scanner, int id) {
		
		System.out.println("Enter new Mobile Number");
		long mobileNumber = scanner.nextLong();
		JDBCLogic.updateMobileNumber(mobileNumber, id);
	}
	
	private static void editEmail(Scanner scanner, int id) {

		System.out.println("Enter new Mobile Number");
		scanner.nextLine();
		String email = scanner.nextLine();
		JDBCLogic.updateEmail(email, id);
	}
	
	private static void editCategory(Scanner scanner, int id) {

		System.out.println("Choose new Category");
		System.out.println("1. Family\n"
						 + "2. Friend\n"
						 + "3. Colleague");
		int choice = scanner.nextInt();
		String category = null;
		switch (choice) {
		case 1:
			category = "Family";
			break;
		case 2:
			category = "Friend";
			break;
		case 3:
			category = "Colleague";
		default:
			System.out.println("Invalid Choice");
			break;
		}
		if (category != null) {
			JDBCLogic.updateCategory(category, id);
		}else {
			System.out.println("Try again...");
		}
		
	}

	public static void searchContact(Scanner scanner) {
		
		System.out.println("Select your choice");
		System.out.println("1. Search by Id\n"
						 + "2. Search by First Name\n"
						 + "3. Search by Last Name\n"
						 + "4. Search by Mobile Number\n"
						 + "5. Search by Email\n"
						 + "6. Search by Category");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			searchById(scanner);
			break;
		case 2:
			searchByFirstName(scanner);
			break;
		case 3:
			searchByLastName(scanner);
			break;
		case 4:
			searchByMobileNumber(scanner);
			break;
		case 5:
			searchByEmail(scanner);
			break;
		case 6:
			searchByCategory(scanner);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		
		
	}

	private static void searchById(Scanner scanner) {

		System.out.println("Enter your id");
		int id = scanner.nextInt();
		JDBCLogic.searchById(id);
	}

	private static void searchByFirstName(Scanner scanner) {

		System.out.println("Enter your first name");
		scanner.nextLine();
		String firstName = scanner.nextLine();
		JDBCLogic.searchByFirstName(firstName);
	}
	
	private static void searchByLastName(Scanner scanner) {
		
		System.out.println("Enter your last name");
		scanner.nextLine();
		String lastName = scanner.nextLine();
		JDBCLogic.searchByLastName(lastName);
	}
	

	private static void searchByMobileNumber(Scanner scanner) {

		System.out.println("Enter your mobile number");
		long mobileNumber = scanner.nextLong();
		JDBCLogic.searchByMobileNumber(mobileNumber);
	}
	
	private static void searchByEmail(Scanner scanner) {

		System.out.println("Enter your email");
		scanner.nextLine();
		String email = scanner.nextLine();
		JDBCLogic.searchByEmail(email);
	}
	
	private static void searchByCategory(Scanner scanner) {
		
		System.out.println("Select your category");
		System.out.println("1. Family\n"
						 + "2. Friend\n"
						 + "3. Colleague");
		int choice = scanner.nextInt();
		String category = null;
		switch (choice) {
		case 1:
			category = "Family";
			break;
		case 2:
			category = "Friend";
			break;
		case 3:
			category = "Colleague";
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		JDBCLogic.searchByCategory(category);
	}

	public static void deleteContact(Scanner scanner) {

		System.out.println("Enter the id of the contact you want to delete");
		int id = scanner.nextInt();
		JDBCLogic.deleteData(id);
	}
}
