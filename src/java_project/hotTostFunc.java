package java_project;

import java.util.Arrays;
import java.util.Scanner;

public class hotTostFunc {
	public static int ageChack() {
		int age = 0;
		String strAge;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter age");
		while (age == 0) {
			strAge = scan.next();
			if (strAge.matches("^\\d+$")) {
				age = Integer.parseInt(strAge);
				if (age < 5 || age > 100) {
					System.out.println("enter only age betweem 5 and 100");
					age = 0;
				} else {
					break;
				}
			} else {
				System.err.println("enter only number");
			}
		}
		return age;
	}

	public static int Additions() {
		int extension = 0;
		int condition = 0;
		String[] addinfraStructcher = { "olives", "mushrooms", "corn", "onions", "tomatoes", "bulgarian" };
		String[] arryAdd;
		System.out.println("Please select toppings for toast Separate the toppings you are interested in using ,");
		System.out.println("Possible toppings are olives, mushrooms, corn, onions, tomatoes, bulgarian");
		System.out.println("If you do not want extras, type No");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String add = scan.nextLine().toLowerCase();
		while (condition == 0) {
			arryAdd = add.split(",");
			for (int i = 0; i < arryAdd.length; i++) { 
				String trimArray = arryAdd[i].trim();
				if (Arrays.asList(addinfraStructcher).contains(trimArray)) {
					if (trimArray.contains("olives") || trimArray.equals("corn") || trimArray.equals("mushrooms")) {
						extension = extension + 3;
						condition = 1;
					}
					else if (trimArray.contains("onions") || trimArray.contains("tomatoes")
							|| trimArray.contains("bulgarian")) {
						extension = extension + 4;
						condition = 1;
					}
				} else {
					if (trimArray.equals("no") || trimArray.equals("No")) {
						System.out.println("Sure? Additions add a lot");
						add = scan.nextLine().toLowerCase().toLowerCase();
						if (add.equals("sure") || add.equals("yes")) {
							System.out.println("Too bad, you're losing");
							condition = 1;
							break;
						} else {
							System.out.println("So what would you like to order?");
							System.out.println(
									"Possible toppings are olives, mushrooms, corn, onions, tomatoes, bulgarian");
							add = scan.nextLine().toLowerCase();
							break;
						}
					}
					System.err.println("Unlisted Please re-enter a standard list of additions: " + trimArray);
					condition = 0;
					System.out.println("Possible toppings are olives, mushrooms, corn, onions, tomatoes, bulgarian");
					add = scan.nextLine().toLowerCase();
					break;
				}
			}
		}
		return extension;
	}

	// שתיה
	public static int drink() {
		int extension_drink = 0;
		int breaker = 0;
		System.out.println("What do you want to drink? Cola or Orange Juice?");
		System.out.println("If you do not want anything enter Submit Order");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String add = scan.nextLine().toLowerCase();
		while (breaker == 0) {
			if (add.equals("orange juice") || add.equals("cola") || add.equals("Orange Juice") || add.equals("Cola")) {
				extension_drink = 8;
				breaker = 1;
			} else if (add.equals("orange juice") && add.equals("cola")) {
				System.err.println("Please choose only one drink");
				System.out.println("What do you want to drink? Cola or Orange Juice?");
				add = scan.nextLine().toLowerCase();
			} else if (add.equals("submit order")) {
				extension_drink = 0;
				breaker = 1;
			} else {
				System.err.println(" \"Only one drink should be selected from the list \"Cola\", \"Orange Juice");
				System.out.println("What do you want to drink? Cola or Orange Juice?");
				add = scan.nextLine().toLowerCase();
			}
		}
		return extension_drink;
	}
//
}
