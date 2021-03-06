
public class Landwater {
	
	
	static int maxGap(char[] input){
		String s = String.valueOf(input);
		
		boolean leftIsland = false;
		int left = -1;
		int right =-1;
		int[] res = new int[input.length];
		
		if(input[0]=='L')
			res[0] = 1;
		else {
			res[0] = 0;
			right++;
		}
		for(int i=1; i<input.length; i++){
		
			
			if(input[i]=='W'&&input[i-1]=='W'){
				right++;
				if(!leftIsland)
					res[i] = 0;
				else {
					res[i] = 1 + res[i-1];
					//right++;
				}
				
			}else if(input[i]=='W'&&input[i-1]=='L'){
				//only if there is right island
				if(s.substring(i).contains("L")){
					right++;
					res[i] = i - right +1;
					left = right;
					right = i;
				}else{
					res[i] = 0;
					break;
				}
				
			}else { //'L'
 				if(!leftIsland)
 					leftIsland = true;
 				
 				res[i] = res[i-1] +1;
 					
			}
			
		}
		
		for(int num: res){
			System.out.println(num);
		}
		return 0;
		
	}
	
	static int biggestIsland(char[] input){
		int max = 0;
		int left =-1;
		int right =-1;
		int[] res = new int[input.length];
		res[0] = 1;
		
		for(int i=1; i<input.length; i++){
			
			if(input[i]=='W' && input[i-1]=='W'){
				right++;
				res[i] = res[i-1] +1;
				
			}else if(input[i]=='W' && input[i-1]=='L'){
				right++;
				res[i] = i - right +1;
				left = right;
				right = i;
				
			}else{ //L, L
				res[i] = res[i-1] +1;
				//right++;
			}
			
		}
		
		for(int num: res){
			System.out.println(num);
		}
		return 0;
	}
	
	
	public static void main(String[] args){
		char[] input1 = { 'L', 'W', 'L', 'W', 'W', 'L', 'L' };
		char[] in2 ={'L', 'W', 'L', 'W', 'W', 'L', 'W'};
		char[] in3 ={'W', 'W', 'L', 'W', 'W', 'L', 'W', 'W', 'W'};
		biggestIsland(input1);
		System.out.println("=========");
		biggestIsland(in2);
		System.out.println("=========");
		maxGap(in3);
		
	}

}
