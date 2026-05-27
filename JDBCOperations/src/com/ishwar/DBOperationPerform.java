package com.ishwar;

import java.util.Scanner;
import com.ishwar.DBOperations;

public class DBOperationPerform {
	DBOperations db = new DBOperations();
	int option;
	void Operations(){
		
		do {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n***JDBC Operations***");
			System.out.println("1.Insert Record");
			System.out.println("2.Update Record");
			System.out.println("3.Delete Record");
			System.out.println("4.Get Record");
			System.out.println("5.Exit");
			
			System.out.print("Enter Option No:");
			option = sc.nextInt();
			
			switch(option) {
			case 1:
				db.InsertRecord();
				break;
			case 2:
				int op;
				System.out.print("1.Update Name:"+"\n2.Update Email:"+"\n3.Update Password:"+"\nEnter option :");
				op = sc.nextInt();
				if(op == 1) {
					db.UpdateName();
				}
				if(op == 2) {
					db.UpdateEmail();
				}
				if(op == 3) {
					db.UpdatePassword();
				}
				break;
			case 3:
				db.DeleteRecord();
				break;
			case 4:
				db.getRecord();
				break;
			case 5:
				System.out.println("Exit...!");
				break;
			default:
				System.out.println("Option No. Wrong");
				break;
			}
		}while(option!=5);	
	}
	
}
