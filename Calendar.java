//Source for printf syntax: 
//https://alvinalexander.com/programming/printf-format-cheat-sheet

import java.util.Scanner;

/**
 *Contains methods to print a 12-month calendar for any year the user chooses.
 *
 *@version 1.0 20 Sept 2017
 *@author Andrea Dewhirst
 */
public class Calendar {
	
	/**
	 *Prints the name of the month, followed by the year.
	 *The weekdays are printed on the line beneath.
	 *
	 *@param m integer corresponding to the month, e.g. 1=January
	 *@param y year
	 */
	public static void printTitle(int m, int y) {
		String nameOfMonth = "";

		switch(m) {
			case 1: 
			   nameOfMonth = "January " + y; 
			   break;

			case 2: 
			   nameOfMonth = "February " + y; 
			   break;

			case 3: 
			   nameOfMonth = "March " + y; 
			   break;

			case 4: 
			   nameOfMonth = "April " + y; 
			   break;

			case 5: 
			   nameOfMonth = "May " + y; 
			   break;

			case 6: 
			   nameOfMonth = "June " + y; 
			   break;

			case 7: 
			   nameOfMonth = "July " + y; 
			   break;

			case 8: 
			   nameOfMonth = "August " + y; 
			   break;

			case 9: 
			   nameOfMonth = "September " + y; 
			   break;

			case 10: 
			   nameOfMonth = "October " + y; 
			   break;

			case 11: 
			   nameOfMonth = "November " + y; 
			   break;

			case 12: 
			   nameOfMonth = "December " + y; 
			   break;
		}
		
		System.out.printf("%n%" + (22+nameOfMonth.length())/2 + "s", nameOfMonth + "\n");
		System.out.print("Su Mo Tu We Th Fr Sa\n");
	}		

	/**
	 *Formats and prints the days of the month.
	 *
	 *@param d the horizontal position where the numbers begin
	 *@param numOfDays the number of days in the month
	 *@return the starting position of the next month's numbers
	 */ 
	public static int printDays(int d, int numOfDays) {

		//The days are aligned in an invisible grid shape,
		//where each block of the grid is 3 spaces wide.
		if(d!=0) System.out.printf("%" + d*3 + "s", " ");

		for(int i = 0; i < numOfDays; i++) {
			if(d == 7) {
				d=0;
				System.out.println();
				}
			System.out.printf("%3s", i+1 + " ");
			d++;
		}

		System.out.println();
		return d;
	}

	/**
	 *Recursive method that combines printTitle() and printDays() to
	 *print the entire year's calendar. Base case: the value of @month
	 *is not between 1 and 12 (inclusive.)
	 *
	 *@param isLY true if the year is a leap year
	 *@param y the year
	 *@param day the starting space for the first day of the month
	 *@param month the numerical value of the month, e.g. January=1
	 */
	public static void printCalendar(boolean isLY, int y, int day, int month) {

		int numberOfDays;

		switch(month) {
			case 9:
			case 4: 
			case 6: 
			case 11: 
			   numberOfDays = 30; 
			   break;

			case 1: 
			case 3: 
			case 5: 
			case 7: 
			case 8: 
			case 10: 
			case 12: 
			   numberOfDays = 31; 
			   break;

			case 2: 
			   if(isLY) numberOfDays = 29;
			   else numberOfDays = 28;
			   break;

			default: return;
		}

		printTitle(month, y);

		printCalendar(isLY, y, printDays(day, numberOfDays), month+1);
	} 
				
	/**
	 *User inputs the year and the day of the week that year began.
	 *Then the full calendar for that year is printed via printCalendar().
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String dayOfWeek; //the day of the week that the month begins
		int year, weekdayNumber=1; //if weekdayNumber = 0, it's Sunday
		boolean isLeapYear = false;

		System.out.println("Print calendar for what year?");
		year = input.nextInt();
		System.out.println("What day of the week did " + year + " start?");
		dayOfWeek = input.next();
		
		switch(dayOfWeek) {
			case "Sunday": 
			   weekdayNumber = 0; 
			   break;

			case "Monday": 
			   weekdayNumber = 1; 
			   break;

			case "Tuesday": 
			   weekdayNumber = 2; 
			   break;

			case "Wednesday": 
			   weekdayNumber = 3; 
			   break;

			case "Thursday": 
			   weekdayNumber = 4; 
			   break;

			case "Friday": 
			   weekdayNumber = 5; 
			   break;

			case "Saturday": 
			   weekdayNumber = 6; 
			   break;
		}
		
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			isLeapYear = true;
		}

		printCalendar(isLeapYear, year, weekdayNumber, 1);

	}
}
