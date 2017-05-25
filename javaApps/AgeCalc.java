package javaApps;

/*
IPO:

input:
birthDay
birthMonth
birthYear
repeat?

processes:
compare birthday and current date

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
import java.util.Calendar;

class AgeCalc {
	public static void main(String[] args) {
		char again;
		Date today;
		Date fullBirthDay;
		Scanner sc = new Scanner(System.in);
		int birthDay;
		int birthMonth;
		int birthYear;
		boolean valid = false;
		System.out.println("Welcome to my age calculator!");
		do {
			do {
				do {// get birthYear
					System.out.println("Please enter your birth year: ");
					while (!sc.hasNextInt()) {
						System.out.println("An integer please!!!");
						sc.next();
					}
					birthYear = sc.nextInt();
					if (birthYear <= 1900) System.out.println("LETS BE REAL, I KNOW YOU ARE NOT THAT OLD!!!");
				} while (birthYear <= 1900);
				
				do {// get birthMonth
					System.out.println("Please enter your birth month: ");
					while (!sc.hasNextInt()) {
						System.out.println("An integer please!!!");
						sc.next();
					}
					birthMonth = sc.nextInt();
					if (birthMonth < 1) System.out.println("come one! months are positive numbers");
					if (birthMonth > 12) System.out.println("you should know better then to claim " + birthMonth + " is a valid month...");
				} while (birthMonth < 1 || birthMonth > 12);

				do {// get birthDay
					System.out.println("Please enter your birth day: ");
					while (!sc.hasNextInt()) {
						System.out.println("A number please!!!");
						sc.next();
					}
					birthDay = sc.nextInt();
					if (birthDay > 0) {
						switch (birthMonth) {
						//if month has 31 days
						case 1: case 3: case 5: case 7: case 8: case 10: case 12:
							if (birthDay < 32) valid = true;
							else System.out.println("your birth month doesn't have " + birthDay + " days in it!!");
							break;
						//if month has 30 days
						case 4: case 6: case 9: case 11:
							if (birthDay < 31)
								valid = true;
							else System.out.println("your birth month doesn't have " + birthDay + " days in it!!");
							break;
						//if month is feb
						case 2:
							//if year is a leap year
							if ((birthYear % 400 == 0) || ((birthYear % 4 == 0) && (birthYear % 100 != 0))) {
								if (birthDay < 30) valid = true;
							} else if (birthDay < 29) valid = true;
							break;
						}
					} else System.out.println("please enter a positive number");
					if(!valid) System.out.println("your birth month doesn't have " + birthDay + " days in it!!");
				} while (!valid);
				
				//make Date() object for birth day and today
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, birthYear);
				cal.set(Calendar.MONTH, birthMonth);
				cal.set(Calendar.DAY_OF_MONTH, birthDay);
				fullBirthDay = cal.getTime();
				today = new Date();
				if (today.getTime() < fullBirthDay.getTime()) System.out.println("what the heck.. Please don't enter a future date!!");
			} while (today.getTime() < fullBirthDay.getTime());//this loops back to year input if a future date is entered
			
			//compare today and birthday
			long dif = (today.getTime() - fullBirthDay.getTime()) / 1000;
			long year = 31556952;
			dif = dif / year;
			System.out.println("you are " + dif + " years old!");
			do {// ask if user wants to get another age
				System.out.println("would you like to get another age? (y/n):  ");
				again = sc.next().charAt(0);
			} while (again != 'N' && again != 'Y' && again != 'n' && again != 'y');
		} while (again == 'y' || again == 'Y');
		System.out.println("thanks for using my age calc");
	}

}
