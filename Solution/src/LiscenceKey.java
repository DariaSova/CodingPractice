
public class LiscenceKey {
	
	static String format(String s, int K){
		int len = s.length();
		char[] chars = s.toCharArray();
		int num = getCharLength(chars);
		int fullBlocks = num/K;
		int rem=0;
		if(num%K>0)
			rem=1;
		int dashes = fullBlocks+rem-1;
		int newLen = num+dashes;
		
		char[] newStr = new char[newLen];
		
		int cnt =0;
		int j = newLen-1;
		for(int i=len-1; i>=0; i--){
			if(Character.isDigit(chars[i])){
				newStr[j--] = chars[i];
				cnt++;
			}
			else if(Character.isLetter(chars[i])){
				newStr[j--] = Character.toUpperCase(chars[i]);
				cnt++;
			}
			if(cnt==K&&j>0){
				cnt=0; //reset
				newStr[j--] = '-';
			}
		}
		
		
		return String.valueOf(newStr);
	}
	
	static int getCharLength(char[] chars){
		int cnt=0;
		for(int i=0; i<chars.length; i++){
			if(Character.isDigit(chars[i])||Character.isLetter(chars[i]))
				cnt++;
		}
		return cnt;
	}
	
	String copyString(char[] chars, int len){		
		return String.valueOf(chars);
	}
	
	
	public static void main(String[] args){
		
		String s1 = "nM6-7-Kju-MnV";
		String s2 = "1knm-Lkio-HN-k8";
		
		System.out.println(format(s1, 3));
		System.out.println(format(s2, 4));
		System.out.println(format(s2, 2));
		System.out.println(format(s2, 1));
		System.out.println(format("k", 1));
		
	}
}
