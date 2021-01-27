package java1;

public class t6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int [] numbers= new int[201];
			for (int i = 0; i < numbers.length; i++) {
				numbers[i]=i;
				String containSeven = String.valueOf(numbers[i]);
				if ((numbers[i]%7==0)|| containSeven.contains("7")) {
					System.out.println("boom!");
				}else {
					System.out.println(numbers[i]);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
