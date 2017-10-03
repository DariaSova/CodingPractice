import java.util.*;

public class WordArrangments {

	static boolean isSame(String s1, String s2){
		char[] ch1 = (s1.toLowerCase()).toCharArray();
		char[] ch2 = s2.toLowerCase().toCharArray();
		int[] count = new int[127];
		
		for(int i=0;i<ch1.length;i++){
			int ascii = (int)ch1[i];
			count[ascii]++;
		}
		
		for(int i=0;i<ch2.length;i++){
			int ascii = (int)ch2[i];
			count[ascii]--;
		}
		for(int i =0; i<count.length; i++){
			if(count[i]>0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		String[] words = in.trim().replace("\"", "").split(",");
		boolean res = isSame(words[0], words[1]);
		
		if(res){
			System.out.println("Valid Pattern");
		}
		else
			System.out.println("Invalid Pattern");
			
	}
}
