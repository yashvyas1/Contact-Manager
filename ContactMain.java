package com.jspiders.contactmanagerwithjdbc.main;

import java.util.Scanner;

import com.jspiders.contactmanagerwithjdbc.operations.ContactOperations;

public class ContactMain {
	
	private static boolean exit = true;
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (exit) {
			menu();
		}	
	}

	public static void menu() {
		System.out.println("WELCOME TO CONTACT MANAGER!");
		System.out.println("Choose the operation");
		System.out.println("1. Add Contact\n"
						 + "2. View All Contact\n"
						 + "3. Edit Contact\n"
						 + "4. Search Contact\n"
						 + "5. Delete Contact\n"
						 + "6. Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			ContactOperations.addContact(scanner);
			break;
		case 2:
			ContactOperations.viewContact();
			break;
		case 3:
			ContactOperations.editContact(scanner);
			break;
		case 4:
			ContactOperations.searchContact(scanner);
			break;
		case 5:
			ContactOperations.deleteContact(scanner);
			break;
		case 6:
			exit();
		default:
			break;
		}
	}

	private static void exit() {
		exit = false;
		System.err.println("THANK YOU!!");
	}
}
