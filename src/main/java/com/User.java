package com;

import java.util.Scanner;

public class User {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 1 to insert student");
		System.out.println("Enter 2 to find All");
		System.out.println("Enter 3 to find by student id");
		
		switch(scan.nextInt()) {
		
		case 1:
		StudentDetials.insertStudent();
		break;
		
		case 2:
		
		StudentDetials.fetchAll();
		break;
		
		case 3:
		StudentDetials.findById();
		}
	}
}
