package javaApps;

import java.util.Scanner;

public class DaysInMonth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String monthString = "none";
		int monthInt = 0;
		boolean valid = false;
		int monthNumber = 1000;

		do {// get birthYear
			System.out.println("Please enter a month number or the first 3 letter of the month: ");
			if (sc.hasNextInt()) {
				monthInt = sc.nextInt();
			} else if (sc.hasNext()) {
				monthString = sc.nextLine();
			}
			if (monthInt < 13 || monthInt > 0) {
				valid = true;
			}
			monthString = monthString.toLowerCase();
			switch (monthString) {
			case "jan":
			case "feb":
			case "mar":
			case "apr":
			case "may":
			case "jun":
			case "jul":
			case "aug":
			case "sep":
			case "oct":
			case "nov":
			case "dec":
				valid = true;
				break;
			}
		} while (!valid);

		if (!monthString.equals("none")) {
			switch (monthString) {
			case "jan":
				monthInt = 1;
				break;
			case "feb":
				monthInt = 2;
				break;
			case "mar":
				monthInt = 3;
				break;
			case "apr":
				monthInt = 4;
				break;
			case "may":
				monthInt = 5;
				break;
			case "jun":
				monthInt = 6;
				break;
			case "jul":
				monthInt = 7;
				break;
			case "aug":
				monthInt = 8;
				break;
			case "sep":
				monthInt = 9;
				break;
			case "oct":
				monthInt = 10;
				break;
			case "nov":
				monthInt = 11;
				break;
			case "dec":
				monthInt = 12;
				break;
			}
		}

		if (monthInt != 0) {
			switch (monthInt) {
			case 1:
				monthString = "jan";
				break;
			case 2:
				monthString = "feb";
				break;
			case 3:
				monthString = "mar";
				break;
			case 4:
				monthString = "apr";
				break;
			case 5:
				monthString = "may";
				break;
			case 6:
				monthString = "jun";
				break;
			case 7:
				monthString = "jul";
				break;
			case 8:
				monthString = "aug";
				break;
			case 9:
				monthString = "sep";
				break;
			case 10:
				monthString = "oct";
				break;
			case 11:
				monthString = "nov";
				break;
			case 12:
				monthString = "dec";
				break;
			}
		}

		switch (monthString) {
		case "jan":
			monthNumber = 31;
			break;
		case "feb":
			int year = -10;
			do {// get year
				System.out.println("Please enter the year: ");
				while (!sc.hasNextInt()) {
					System.out.println("An integer please!!!");
					sc.next();
				}
				year = sc.nextInt();
			} while (year < 0);
			if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) monthNumber = 29;
			else monthNumber = 28;
			break;
		case "mar":
			monthNumber = 31;
			break;
		case "apr":
			monthNumber = 30;
			break;
		case "may":
			monthNumber = 31;
			break;
		case "jun":
			monthNumber = 30;
			break;
		case "jul":
			monthNumber = 31;
			break;
		case "aug":
			monthNumber = 31;
			break;
		case "sep":
			monthNumber = 30;
			break;
		case "oct":
			monthNumber = 31;
			break;
		case "nov":
			monthNumber = 30;
			break;
		case "dec":
			monthNumber = 31;
			break;
		}

		System.out.println(monthString + " has " + monthNumber + " days!");

	}

}
