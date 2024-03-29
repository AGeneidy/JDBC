package DBMS;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DBMS mainDBMS;
		try {
			mainDBMS = new StdDBMS();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			scan.close();
			return;
		}
		SQLParser parser = new SQLParser(mainDBMS);
		System.out.println("Omario Database Management System 1.0");
		System.out.println("Loading the interactive shell...");

		while(true) {
			System.out.print("SQL>> ");
			String cmd = scan.nextLine();
			if (cmd.equalsIgnoreCase("exit") || cmd.equalsIgnoreCase("quit")) {
				scan.close();
				return;
			}
			parser.parseSQL(cmd);
		}
	}
	
}
