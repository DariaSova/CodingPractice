
public class Brackets2 {
	
	static void printBr(char[] arr, int index, int op, int cl){
		int len = arr.length;
		
		//print if it's filled and balanced
		if(cl==2&&index==len){
			System.out.println(String.valueOf(arr));
			return;
		}
		
		int i =index;
//		for(int i=index; i<len; i++){
			if(op<2){
				arr[i++] = '(';
//				op++;
				printBr(arr, i, op+1, cl);
			}
			
			if(op>cl){
				arr[i++]= ')';
//				cl++;
				printBr(arr, i, op, cl+1);
			}
				
		//}
		
	}
	
	static void permutation(String s, int op, int cl, int n){
		if(cl==n&&op==n){
			System.out.println(s);
			return;
		}
		
		if(op<n){
			permutation(s+"(", op+1, cl, n);
		}
		if(cl<op){
			permutation(s+")", op, cl+1, n);
		}
		
	}
	
	static void printBr2(char[] arr, int index, int op, int cl){
		int len = arr.length;
		int n =len/2;
		
		//print if it's filled and balanced
		if(cl==n&&op==n&&index==len){
			System.out.println(arr);
			return;
		}
		
		int i =index;
//		for(int i=index; i<len; i++){
			if(op<n){
			//arr[i++]= '(';
			arr[i]='(';
			printBr2(arr, i+1, op+1, cl);
			}
			
			if(op>cl&&i<len){
				arr[i]= ')';
				//cl++;
				printBr2(arr, i+1, op, cl+1);
			}
	}
	
	
	public static void main(String[] args){
		int n=3;
		char[] arr = new char[2*n];
		printBr2(arr, 0, 0, 0);
		//permutation("", 0,0,5);
		
		
	}

}
