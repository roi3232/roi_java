package java;

import java.time.LocalDate;
import java.util.Scanner;

public class t2 {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		
		
		// תרגיל 1
		try {
			Scanner cons = new Scanner(System.in);
			System.out.println("בחר יום");
			int day = cons.nextInt();
			String stringday;
			switch(day) {
			case 1:stringday = "יום ראשון";
			break;
			case 2:stringday = "יום שני";
			break;
			case 3: stringday = "יום שלישי";
			break;
			case 4: stringday = "יום רביעי";
			break;
			case 5: stringday = "יום חמישי";
			break;
			case 6: stringday = "יום שישי";
			break;
			case 7: stringday = "יום שבת";
			break;
			default: stringday = "מספר לא בטווח";
			break;
			}
			System.out.print(stringday);

			LocalDate date = LocalDate.now();
			LocalDate myObj = LocalDate.now();
			System.out.println(myObj);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// תרגיל 2
		try {
			Scanner input = new Scanner(System.in);

			int number_Of_DaysInMonth = 0; 
			String MonthOfName = "Unknown";

			System.out.println("Input a month number: ");
			int month = input.nextInt();

			System.out.println("Input a year: ");
			int year = input.nextInt();

			switch (month) {
			    case 1:
			        MonthOfName = "January";
			        number_Of_DaysInMonth = 31;
			        break;
			    case 2:
			        MonthOfName = "February";
			        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			            number_Of_DaysInMonth = 29;
			        } else {
			            number_Of_DaysInMonth = 28;
			        }
			        break;
			    case 3:
			        MonthOfName = "March";
			        number_Of_DaysInMonth = 31;
			        break;
			    case 4:
			        MonthOfName = "April";
			        number_Of_DaysInMonth = 30;
			        break;
			    case 5:
			        MonthOfName = "May";
			        number_Of_DaysInMonth = 31;
			        break;
			    case 6:
			        MonthOfName = "June";
			        number_Of_DaysInMonth = 30;
			        break;
			    case 7:
			        MonthOfName = "July";
			        number_Of_DaysInMonth = 31;
			        break;
			    case 8:
			        MonthOfName = "August";
			        number_Of_DaysInMonth = 31;
			        break;
			    case 9:
			        MonthOfName = "September";
			        number_Of_DaysInMonth = 30;
			        break;
			    case 10:
			        MonthOfName = "October";
			        number_Of_DaysInMonth = 31;
			        break;
			    case 11:
			        MonthOfName = "November";
			        number_Of_DaysInMonth = 30;
			        break;
			    case 12:
			        MonthOfName = "December";
			        number_Of_DaysInMonth = 31;
			}
			System.out.print(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days\n");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//  תרגיל 3
		try {
			Scanner input1 = new Scanner(System.in);
			double grade_a  , grade_b, grade_c;
			System.out.println("Enter garde a :");
			grade_a = input1.nextInt();
			System.out.println("Enter garde b :");
			grade_b = input1.nextInt();
			System.out.println("Enter garde c :");
			grade_c = input1.nextInt();
			double avg = (grade_a + grade_b + grade_c)/3;
			System.out.println(avg);

			if(avg>=90) System.out.println("Your grade A.");
			else if((avg>=70) && (avg<90)) System.out.println("Your grade B.");
			else if((avg>=50) && (avg<70)) System.out.println("Your grade C.");
			else if(avg<50) System.out.println("Your grade F.");
			else System.out.println("Invalid");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	// תרגיל 4
		try {
			int numProduct;
			int priceProduct;
			
			Scanner cons1 = new Scanner(System.in);
			System.out.println("enter number of product");
			numProduct = cons1.nextInt();
			
			System.out.println("enter price of product");
			priceProduct = cons1.nextInt();
			
			int sum = numProduct * priceProduct;
			
			if (sum<100) {
				System.out.println("you need to pay : " + sum);
			}else if (sum>200) {
				System.out.println("you need to pay : " + (sum * 0.75));
			}else if (sum>=100 && sum<120 ) {
				System.out.println("you need to pay : " +(sum * 0.90));
			}else if (sum >120 && sum<=200) {
				System.out.println("you need to pay : " + (sum * 0.85));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	//תרגיל 5
		try {	Scanner cons2 = new Scanner(System.in);
		System.out.println("enter num of month");
		int month1 = cons2.nextInt();
		     String monthString;
		     switch (month1) {
		       case 1:  monthString = "January";
		       break;
		       case 2:  monthString = "February";
		       break;
		       case 3:  monthString = "March";
		       break;
		       case 4:  monthString = "April";
		       break;
		       case 5:  monthString = "May";
		       break;
		       case 6:  monthString = "June";
		       break;
		       case 7:  monthString = "July";
		       break;
		       case 8:  monthString = "August";
		       break;
		       case 9:  monthString = "September";
		       break;
		       case 10: monthString = "October";
		       break;
		       case 11: monthString = "November";
		       break;
		       case 12: monthString = "December";
		       break;
		       default: monthString = "Invalid month";
		       break;
		        }			
				if (month1>=1 && month1<=12) {
					if (month1>=1 && month1<=4) {
						System.out.println("very cold in " + monthString);
					}
			        if (month1>=5 && month1<=7) {
						System.out.println("Quite comfortable in " + monthString);
					}
			        if (month1>=8 && month1<=12) {
						System.out.println("very hot in " + monthString);
					}
					}
					else {
						System.out.println(monthString);
					}
		} catch (Exception e) {
			System.out.println("There is a problem in the program");
		}
//	תרגיל 6
		try {
			Scanner cons3 = new Scanner(System.in);
			System.out.println("enter number of x");
			int x = cons3.nextInt();
			System.out.println("enter number of y");
			int y = cons3.nextInt();
			System.out.println("enter number of z");
			int z = cons3.nextInt();
			if (x == y && x== z) {
				System.out.println("All numbers are Equal");
			} else if (x==y && x!=z) {
				System.out.println("number x and y are Equal");
			} else if (x==z && x!=y) {
				System.out.println("number x and z are Equal");
			}else if (y==z && y!=x) {
				System.out.println("number y and z are Equal");
			} 
			else {
				System.out.println("None of the numbers is Equal");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// תרגיל 7
		try {
			int age = 61, high =180, weight =100, experience = 5;
			if (age<50 && age >= (1423%2)) {
			high = 180;
			}else if (weight<=100 || weight <high) {
			System.out.println("a");
			if (age<40) {
			System.out.println("b");
			}
			}
			if(experience<8){
			experience = 3;
			System.out.println("c");
			high = 170;
			if (high==165 || experience>4) {
			System.out.println("d");
			high = 190;
			} else {
			experience=5;
			weight=200;
			if (age>60 && experience<8) {
			System.out.println("e");
			}
			else {
			System.out.println("f");
			    }
			  }
   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
