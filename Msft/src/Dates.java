import java.util.*;

public class Dates {

	
	static char[] parseDate(String s){
		//System.out.println(s);
		char [] format = s.toCharArray();
		//char delimeter = '';
		char[] order = new char[4];
		int cnt = 1;
		for(int i=0; i<format.length&&cnt<4; i++){
			if(format[i]!='y'&&format[i]!='d'&&format[i]!='m'&&format[i]!=' '){
//				System.out.println("al "+(char)format[i]);
				order[0] = (char)format[i];
			}
		}
		for(int i=0; i<format.length&&cnt<4; i++){
			//System.out.println("SYMBOL: " + format[i]);
//			System.out.println("Count"+cnt);
			if(format[i]=='y'){
				//System.out.println(cnt);
				order[cnt] = 'y';
				cnt++;
				i+=3;
			} else if(format[i]=='d' || format[i]=='m'){
				if(format[i]=='m') {
					order[cnt] ='m';
				} else {
					order[cnt]='d';
				}
				
				cnt++;
				i+=2;
			}
//			else if(format[i]!='y'&&format[i]!='d'&&format[i]!='m'&&format[i]!=' '){
//				//System.out.println("al "+(char)format[i]);
//				order[0] = (char)format[i];
//			}
		}
		return order;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String in = sc.nextLine();
		//String in ="2017-09-04 yyyy-mm-dd mm*yyyy*dd";
		while(sc.hasNextLine()){
			String in = sc.nextLine();
			String[] words = in.split(" ");
//			System.out.println("INPUT:" +words[0]);
			String date = words[0];
//			System.out.println(date);
			String currf = words[1];
//			System.out.println(words[1]);
			String newf = words[2];
//			System.out.println(words[2]);
			
			char[] order1 = parseDate(currf);
//			System.out.println(order1);
			char[] order2 = parseDate(newf);
//			System.out.println(order2);
			
//			System.out.println("Delimeter: "+ order1[0]);
			char n = order1[0];
			String n2;
			if(n=='*'||n=='?'||n=='.'||n=='\\'){
				n2 = "\\"+n;
			}else {
				n2 = ""+n;
			}
			//String[] nums = date.split((order1[0]+""));
			String[] nums = date.split(n2);
			//String[] nums = date.split(("."));

//			System.out.println("length"+date);
//			System.out.println("length"+nums.length);
			
			String[] res = new String[3];
			
			for(int i=1; i<order2.length;i++){
				char curr = order2[i];
				for(int j =1;j<4;j++){
					if(order1[j]==curr){
//						System.out.println("j: "+ j);
						
//						System.out.println(nums[j-1]);
						res[i-1] = nums[j-1];
					}
				}
					
			}
			
			String f = String.join(order2[0]+"", res);
			
			System.out.println(f);
				
		}
		
		
			
		}
	
}
