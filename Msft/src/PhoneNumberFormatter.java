import java.util.*;

public class PhoneNumberFormatter {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		input = input.replace("+", "").replace(" ", "");
		System.out.println(input);
		String[] arr = input.split("[-\\.\\-\\(\\)]");
		
		for(String s:arr)
			System.out.println(s);
		System.out.println("length: "+arr.length);
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.add("", 0)
	}

}