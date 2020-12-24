package java;


import java.util.Scanner;


public class t3 {
	
	public static void comper (String x ,String y) {
		if(x.equals(y)) {
			System.out.println("the compar pass");
		}else {
			System.err.println("the compar fail");
		}
	}
public static int bigger(int a,int b) {
	if (a>b) {
		return a;
	}else {
		return b;
	}
}
	public static  void print () {
		
		for (int i = 0; i < 15; i++) {
			System.out.print("_");
		}
		System.out.println();	
	}
	
public static  void compar (String first, String laste, String descripsion) {
		
		if (first.equals(laste)) {
			
			System.out.println(descripsion + "the comper pass");
			
		} else {

			System.err.println(descripsion + "the comper fail");
		}
}
public static  void string_number (String some_string) {
	
	System.out.println("Number Of Characters with Space : " +  some_string.length());
	int count = 0;
	
	for (int i = 0; i < some_string.length(); i++) {
		char x = some_string.charAt(i);
		if (x  == ' '){
			count++;
		}
		
	}
	System.out.println("Number Of Characters without  Space : " +  (some_string.length() - count));
}


	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner cons1 = new Scanner(System.in);
		int x=-1;
		while (x!=0) {
			System.out.print("enter number");
			x=cons1.nextInt();
		}
		
		/* תרגיל 1
		int x=1;
		while (x<=10) {
			if (x!=4) {
				System.out.println(x);
			}
			x++;
		}
		*/
		/* תרגיל 2
int x=1;
while (x<=100) {
	if (x%3==0 && x%7==0) {
		System.out.println(x);	
	}
	x++;	
}
        תרגיל 3
		int num = 20, sum = 0;

        for(int i = 1; i <= num; ++i)
        {
            sum += i;
        }

        System.out.println("Sum = " + sum);
        */
	/*
	String x = "a";
	String y = "a";
	comper(x, y);
	bigger(6,6);
	  System.out.println(bigger(7,6));
		*/
		/* תרגיל 4
		int x = 0;
		int sum = 0;
		int i=0;
		   while ( i <5 ) {
		    Scanner scanner = new Scanner(System.in);
			System.out.println("enter a number");
			x= scanner.nextInt();
			sum = sum+x;
			i++;
			}
			System.out.println(sum);
 תרגיל 5
		int count = 0;
		int sum = 0;
		int y = -1;

		Scanner scanner = new Scanner(System.in);

		while (count<10 ) {
			System.out.println("enter a number");
			y = scanner.nextInt();
			if (y==0) {
				break;
			}
			count++;
			sum=sum+y;
		}

		System.out.println("הקשת " + count + " מספרים");
		System.out.println("סכום המספרים הוא " + sum);
		System.out.println("ממוצע המספרים הוא " + sum/count);
תרגיל 6
		int x =1;
		int y = 1;

		while (y<=10) {
			x=1;
			while (x<=10) {
				System.out.print(x*y+" ");
				x++;
			}
			y++;
			System.out.println();}
			תרגיל 7
		int x = 1;
		int y = 1;

		while (y<=10) {
			x=1;
			while (x<=10) {
				if ((x*y)/10<1) {
					System.out.print("0"+(x+y)+" ");
					}else {
						System.out.print(x*y+" ");
					}
				x++;
			}
			y++;
			System.out.println();}
			תרגיל 8
		int x =  (int) (Math.random()*12)+1; 
		Scanner scanner = new Scanner(System.in);

		int counter = 1;
		boolean z = false;
		int r = 1;
		while (counter<=5) {
			if (r==1) {
			System.out.println("enter a num between 1-12");
			r=2;
			}
			else {
				System.out.println("guss again");
			}
			int y = scanner.nextInt();
			if (x==y){
				System.out.println("you win");
				z = true;
				break;
			}
			if (y>x) {
				System.out.println("your num too high ");
			}
			else {
				System.out.println("your num too low");
			}
			counter++;
		}
		if (z==false){
			System.out.println("you lose");
		}
 תרגיל 9
		int numbers[] = {951 , 402 , 984 , 651 , 360 , 69 , 408 , 319 , 601 , 485 , 980 , 507 , 725 , 547 , 544 ,615 , 83 , 165 , 141 , 501 , 263 , 617 , 865 , 575 , 219 , 390 , 984 , 592 , 236 , 051 , 942 ,941 ,386 , 462 , 47 , 418 , 907 , 344 , 236 , 375 , 823 , 566 , 597 , 978 , 328 , 615 , 953 , 345 ,	399 , 162 , 758 , 219 , 918 , 237 , 412 , 566 , 826 , 248 , 866 , 950 , 626 , 949 , 687 , 217 ,815 , 67 , 104 , 58 , 512 , 24 , 892 , 894 , 767 , 553 , 81 , 379 , 438 , 831 , 445 , 742 , 717 ,958 , 609 , 842 , 451 , 688 , 753 , 854 , 685 , 93 , 857 , 440 , 380 , 126 , 721 , 328 , 753 ,470 ,743	};
		for (int e: numbers) {
            if (e<=237) {
                System.out.print(e+" , ");
            }
		}
		תרגיל 10
Scanner console = new Scanner(System.in);
        
        int number,          
            countPositive = 0, 
            countNegative = 0,
            countZero = 0;

        char choice;
	
        do {
            System.out.print("Enter the number ");
            number = console.nextInt();
            if(number > 0){
                countPositive++;
            }
            else if(number < 0){
                countNegative++;
            }
            else{
                countZero++;
            }
            System.out.print("Do you want to continue y/n? ");
            choice = console.next().charAt(0);
            }
        while(choice=='y' || choice == 'Y');
        System.out.println("Positive numbers: " + countPositive);
        System.out.println("Negative numbers: " + countNegative);
        System.out.println("Zero numbers: " + countZero);
        תרגיל 11
		Scanner console = new Scanner(System.in);
	     
        int base;
        int power;
        int result = 1;
        
        System.out.print("Enter the base number ");
        base = console.nextInt();
        
        System.out.print("Enter the power ");
        power = console.nextInt();

        for(int i = 1; i <= power; i++)
        {
	    result *= base;
        }

        System.out.println("Result: "+ result);
*/
		//פונקציות
		/* תרגיל 1

		System.out.println("helo world");
			
		print();
		
		System.out.println("my name is Roi");
			
		print();
		*/
		
// תרגיל 2
		/*
        Scanner scan = new Scanner(System.in);
		System.out.println("enter first name");
		String first  = scan.nextLine();
		
		System.out.println("enter laste name");
		String laste  = scan.nextLine();
		
		String descripsion = "test one : ";
		compar(first, laste,descripsion);	
		*/	
		
		
		Scanner scan = new Scanner(System.in);
				System.out.println("enter some string");
				String some_string  = scan.nextLine();
				
				string_number(some_string);

		
 			//
		}
	//
}
