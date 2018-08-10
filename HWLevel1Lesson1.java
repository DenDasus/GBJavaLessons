/**
*	Java Level 1. Lesson 1. Homework.
*
*	@author Denis Kuzovin
*	@version Aug 11, 2018
*/

public class HWLevel1Lesson1 
{
	public static void main(String[] args) 
	{
		// Task 2
		vars();
		
		// Task 3
		System.out.println("Task 3 result = " + calculate(2, 5, 9, 1));
		
		// Task 4
		System.out.println("Task 4 result = " + isFrom10To20(7, 5));
		
		// Task 5
		isNegativePrint(9);
		
		// Task 6
		System.out.println("Task 6 result = " + isNegative(-6));
		
		// Task 7
		printHelloName("Сергей");
		
		// Task 8
		int year = 2018;
		if(isLeapYear(year))
		{
			System.out.println("Year " + year + " is leap year");
		}
		else
		{
			System.out.println("Year " + year + " is NOT leap year");
		}
	}
	
	static void vars() 
	{
		byte b = 5;
		short a = 77;
		int i = -345;
		long z = 99999;
		float y = 0.55f;
		double c = 23348.89;
		char k = 's';
		boolean test = false;
	}
	
	static int calculate(int a, int b, int c, int d) 
	{
		return a * (b + (c / d));
	}
	
	static boolean isFrom10To20(int a, int b) 
	{
		if(a+b >= 10 && a+b <=20) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}	
	
	static void isNegativePrint(int a)
	{
		if(a < 0)
			System.out.println("This number is negative");
		else
			System.out.println("This number is positive (or zero)");
	}
	
	static boolean isNegative(int a)
	{
		if(a < 0)
			return true;
		else
			return false;
	}
	
	static void printHelloName(String name)
	{
		System.out.println("Привет, " + name + "!");
	}
	
	public static boolean isLeapYear(int year)
	{
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
		{
			return true;
		}
		return false;
	}
}
