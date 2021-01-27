package java;

import java.util.Scanner;

public class t1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// 1
		int y;
		try {
			Scanner cons = new Scanner(System.in);
			System.out.println("enter num 1");
			int x = cons.nextInt();
			System.out.println("enter num 2");
			y = cons.nextInt();
			System.out.println(x + y);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// תרגיל 2
		try {
			Scanner cons1 = new Scanner(System.in);
			System.out.println("enter num 1");
			int a = cons1.nextInt();
			System.out.println("enter num 2");
			int b = cons1.nextInt();
			if (a > b) {
				System.out.println("x is biger");
			} else {
				System.out.println("y is bigger");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// תרגיל 3
		try {
			Scanner cons2 = new Scanner(System.in);
			System.out.println("enter num 1");
			int c = cons2.nextInt();
			if (c > 0) {
				System.out.println("positive");
			} else if (c < 0) {
				System.out.println("negative");
			} else {
				System.out.print(0);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// תרגיל 4
		try {
			Scanner cons3 = new Scanner(System.in);
			System.out.println("enter num 1");
			int x = cons3.nextInt();
			System.out.println("enter num 2");
			int y1 = cons3.nextInt();
			System.out.println("enter num 3");
			int z = cons3.nextInt();
			if (x > y1 && x > z) {
				System.out.println("x is biggest number");
			} else if (y1 > z && y1 > x) {
				System.out.println("y is biggest  number");
			} else {
				System.out.println("z is biggest  number");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// תרגיל 5
		try {
			Scanner cons4 = new Scanner(System.in);
			System.out.println("enter num");
			int g = cons4.nextInt();
			if (g % 2 == 0) {
				System.out.println("The number X is even");
			} else {
				System.out.println("The number X is not even");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// תרגיל 6
		try {
			Scanner cons5 = new Scanner(System.in);
			System.out.println("enter num between 1 - 100");
			int h = cons5.nextInt();

			if (h < 100 && h > 1) {
				System.out.println("The number in the correct range");
			} else if (h < 1) {
				System.out.println("The number is too low");
			} else {
				System.out.println("The number is too high");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// תרגיל 7
		try {
			Scanner cons6 = new Scanner(System.in);
			System.out.println("enter age");
			int u = cons6.nextInt();

			if (u < 20) {
				System.out.println("You are too young");
			} else if (u > 50) {
				System.out.println("You are too old");
			} else if (u > 20 && u < 50) {
				System.out.println("enter height");
				int i = cons6.nextInt();
				if (u > 20 && u < 50 && i > 180) {
					System.out.println("You were accepted into the team");
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Scanner cons7 = new Scanner(System.in);
			System.out.println("enter num 1");
			int t = cons7.nextInt();
			System.out.println("enter num 2");
			int p = cons7.nextInt();
			System.out.println(t * p);
		} catch (Exception e) {
			System.err.println("error");
		}
		try {
			Scanner cons8 = new Scanner(System.in);
			System.out.println("enter num 1");
			int r = cons8.nextInt();
			System.out.println("enter num 2");
			int m = cons8.nextInt();
			System.out.println(r * m);
		} catch (Exception e) {
			System.err.println("error 2");
		}

	}

}
