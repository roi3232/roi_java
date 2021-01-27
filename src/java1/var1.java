package java1;

public class var1 {

	public static void main(String[] args) {

		int x, y, z;
		x = 3;
		y = 4;
		z = 4;
		System.out.println(x * y);

		String a, b;
		a = "roi";
		b = "izchak";
		System.out.println(a + " " + b);

		String name;
		int age;

		name = "roi izchak";
		age = 29;

		System.out.println("hello my name is " + name + " and my age is " + age);

		int e;

		e = x + y - z;
		System.out.println(x + "+" + y + "-" + z + "=" + e);

		String week[] = { "ראשון", "שני", "שלישי", "רביעי", "חמישי" };
		week[1] = "h";
		System.out.println(week[1] + " " + week[4]);

		String f = "hey";
		String u = "hey";
		if (f.equals(u)) {
			System.out.println("true");
		}

	}

}
