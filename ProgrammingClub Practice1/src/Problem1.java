import java.util.*;

public class Problem1 {
	static HashMap<Character, String> hm = new HashMap<Character, String>();
	
	static void HashInit(){
		
		char[] old = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String[] new_alp = {"@","8","(","|)","3","#","6","[-]","|","_|","|<","1","[]\\/[]","[]\\[]","0","|D","(,)","|Z","$","']['","|_|","\\/","\\/\\/","}{","`/","2"};
		for(int i =0; i<old.length; i++){
			hm.put(old[i], new_alp[i]);
		}
	}
	
	static String Translate(String in){
		in = in.toLowerCase();
		String result = "";
		
		char[] input = in.toCharArray();
		
		for(int i=0; i<input.length; i++){
			char curr = input[i];
			String translated = hm.get(curr);
			//check for null?
			if(translated==null){
				result += curr;
			}else{
				result+= translated;
			}
			
		}
		
		
		return result;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(true){
			String in = scanner.nextLine();
		
			HashInit();
		
			String res = Translate(in);
			System.out.println("Translated:" + res);
		}
		
	}
}
