package wmich.edu.cs3310.brennanmuir;

/*
 * Brennan Muir
 * CS3310 Gupta
 * HW 5 
 * 12/10/16
 */

import java.io.*;
import java.util.Scanner;

public class HashTable {

	public static long start, end;

	public static void main(String[] args) throws IOException {
		System.out.println("Starting a new Hash Table function");
		menu();
	}

	public static void menu() throws IOException {
		Scanner input = new Scanner(System.in);
		int action = 0;
		String[] insert = new String[20];

		//Get user input for action they wish to perform.
		while (action != 5) {

			System.out.println(
					"Select an option from the following menu:\n1) Add a student\n2) Find a student\n3) Delete a student \n4) Show all information\n5) Exit");

			action = input.nextInt();
			switch (action) {
			case 1:
				insert = add(insert);
				break;

			case 2:
				find();
				break;

			case 3:
				delete(insert);
				break;

			case 4:
				displayAll();
				break;

			case 5:
				System.out.println("Quitting Application");
				System.out.println("Displaying Hash File:");
				System.out.println();
				for (int i = 0; i < insert.length; i++) {
					System.out.println(insert[i]);
				}
				return;	//Quit program

			//Keep asking for number if input is outside of 1-5
			default:
				System.out.println("Please enter a correct number");
				break;
			}
		}
	}

	//Insert names into the file
	public static String[] add(String[] insert) throws IOException {
		Scanner reader = new Scanner(System.in);
		File outFile = new File("hashTable.txt");
		FileWriter write = new FileWriter(outFile);
		PrintWriter pWriter = new PrintWriter(write);
		String yes;
		do {
			System.out.println("Type a name to encrypt: ");
			String line = reader.nextLine();
			startTimer();
			pWriter.print(line + " ");
			int hash = 8;
			int hashValue = 0;
			for (int i = 0; i < line.length(); i++) {
				hash = hash ^ line.charAt(i);
				hashValue = +hash;
			}
			System.out.println();
			hashValue = hashValue % insert.length;
													
			insert[hashValue] = line; 

			System.out.println("The name was encrypted with the hash value of " + hashValue);
			pWriter.print(hashValue + "\n");
			System.out.println();
			endTimer();
			System.out.println("Would you like to add anymore names?");
			yes = reader.nextLine();
		} while (yes.equalsIgnoreCase("yes"));
		System.out.println("Successfully written name and hashcode to the file\n");
		pWriter.close();

		return insert;
	}
	
	
	//Search function
	public static void find() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("You can search by name or hash number. Type 'name' or 'hash'.");
		String here = input.nextLine();
		if (here.equalsIgnoreCase("hash")) {
			System.out.println("Type the hash number you wish to search for: ");
			String hashSearch = input.nextLine();
			startTimer();
			Scanner fileScanner = new Scanner(new File("hashTable.txt"));
			while (fileScanner.hasNext()) {
				String name = fileScanner.next();
				if (fileScanner.next().equals(hashSearch)) {
					System.out.println(hashSearch + " was found with the Name of " + name);
					endTimer();
				}
			}
		} else if (here.equalsIgnoreCase("name")) {
			Scanner input1 = new Scanner(System.in);
			System.out.println("Type the name you wish to search for: ");
			String nameSearch = input1.nextLine();
			Scanner fileScanner = new Scanner(new File("hashTable.txt"));
			while (fileScanner.hasNext()) {
				if (fileScanner.next().equals(nameSearch)) {
					System.out.println(nameSearch + " was found with the hash value of " + fileScanner.next());
					endTimer();
				}
			}
		}
	}

	//Delete Function
	public static String[] delete(String[] insert) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("You can delete by name or hash number. Type 'name' or 'hash'.");
		String here = input.nextLine();
		if (here.equalsIgnoreCase("hash")) {
			startTimer();
			System.out.println("Type the hash number you wish to delete: ");
			int hashSearch = input.nextInt();
			Scanner fileScanner = new Scanner(new File("hashTable.txt"));
			while (fileScanner.hasNext()) {
				String name = fileScanner.next();
				if (fileScanner.next().equals(hashSearch)) {
					System.out.println(hashSearch + " was found with the hash value of " + name);
					System.out.println(name +" was deleted");
					insert[hashSearch] = "null";
					endTimer();
				}
			}
		} else if (here.equalsIgnoreCase("name")) {
			Scanner input1 = new Scanner(System.in);
			System.out.println("Type the name you wish to delete: ");
			String nameSearch = input1.nextLine();
			Scanner fileScanner = new Scanner(new File("hashTable.txt"));
			while (fileScanner.hasNext()) {
				if (fileScanner.next().equals(nameSearch)) {
					int num = Integer.parseInt(fileScanner.next());
					System.out.println(nameSearch + " was found with the hash value of " + num);
					System.out.println(nameSearch + " was deleted");
					insert[num] = "null";
					endTimer();
				}
			}
		}
		return insert;
	}

	public static void displayAll() throws FileNotFoundException {
		File in = new File("hashTable.txt");
		Scanner into = new Scanner(in);
		startTimer();
		while (into.hasNextLine()) {
			String line = into.nextLine();
			System.out.println(line);
		}
		endTimer();
	}

	// Timers for calculating time complexity
	public static void startTimer() {
		start = System.nanoTime();
	}

	public static void endTimer() {
		end = System.nanoTime();
		System.out.println("Processing time is " + (end - start) / 1000.0 + " us.\n");
	}
}
