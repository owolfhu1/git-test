/*
IPO:

input:
birthDay
birthMonth
birthYear
repeat?

processes:
compair birthdate and current date

output:
prompt for day
prompt for month
prompt for year
display age
prompt to repeate

algorithm:
prompt user for birthDay
prompt user for birthMonth
prompt user for birthYear
calculate age
display age
prompt to repeate
*/

import java.util.Scanner;
import java.util.Date; 

class AgeCalc{
	public static void main(String[] args){
 		Scanner sc = new Scanner(System.in);
        	int birthDay;
        	int birthMonth;
       	 	int birthYear;
		boolean valid = false;

		System.out.println("Welcome to my age calculator!");

		do {//get birthYear
			System.out.println("Please enter your birth year: ");
			while (!sc.hasNextInt()) {
				System.out.println("An integer please!!!");
        			sc.next();
			}
			birthYear = sc.nextInt();
		} while (birthYear <=  0);

		do {//get birthMonth
			System.out.println("Please enter your birth month: ");
			while (!sc.hasNextInt()) {
				System.out.println("An integer please!!!");
        			sc.next();
			}
			birthMonth = sc.nextInt();
		} while (birthMonth <  0  || birthMonth > 12 );

		do {//get birthDay
			System.out.println("Please enter your birth day: ");
			while (!sc.hasNextInt()) {
				System.out.println("A number please!!!");
        			sc.next();
			}
			birthDay = sc.nextInt();
			
			if (birthDay > 0){
				//if month has 31 days
				if (birthMonth == 1 ||
				      	birthMonth == 3 ||
				      	birthMonth == 5 ||
				      	birthMonth == 7 ||
				      	birthMonth == 8 ||
				      	birthMonth == 10 ||
				      	birthMonth == 12 ) {
						if (birthDay < 32) valid = true;
				}
				//if month has 30 days
				if (birthMonth == 4 ||
				      	birthMonth == 6 ||
				      	birthMonth == 9 ||
				 	birthMonth == 11) {
						if (birthDay < 31) valid = true;
				}
				//if month is feb
				if (birthMonth == 2){
					//if year is leap year
					if ((birthYear % 4 == 0) && birthYear % 100 != 0){
						if (birthDay < 30) valid = true;
					}  else if (birthDay < 29) valid = true;
				}
			}
		} while (!valid);


	}

}
