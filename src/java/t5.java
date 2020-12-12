package java;

public class t5 {
	public static void main(String[] args) {
	
	try {
		String fullphone = "052-5253676";
		String replacePhone = fullphone.replace("052", "050");
		System.out.println(replacePhone);
		//עם רוצים לבצע  משהו על המערך
		String [] arr= {"hey","good bey"};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i);
		}
		//עם רק רוצים להציג את המשתנים במערך
			for (String s:arr) {
				System.out.println(s);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
		
	//	
	}
	//
}
