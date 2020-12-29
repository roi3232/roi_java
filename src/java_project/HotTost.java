package java_project;

public class HotTost {

	public static void main(String[] args) {
		System.out.println("**Wellcome to the restaurant**");
		int tost = 15;
		int age = hotTostFunc.ageChack();
		int extension = hotTostFunc.Additions();
		int drinking = hotTostFunc.drink();
		if (age >= 15 && age <= 18) {
			System.out.println("We have a discount for teenagers - you received a NIS 5 discount");
			System.out.print("The price of your toast is only" + (tost + extension + drinking - 5) + " NIS");
			System.out.println(" instead of " + (tost + extension + drinking) + " NIS ");
			System.out.println("Appetite!");
		} else {
			System.out.println(" The price of your toast is  " + (tost + extension + drinking) + " NIS");
			System.out.println("Appetite!");
		}
	}
}
