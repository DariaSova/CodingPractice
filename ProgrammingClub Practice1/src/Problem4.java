import java.util.*;

public class Problem4 {
	
	static boolean check(int[] nums, int len){
		if(len<2) return false;
		
		int initd = nums[1]-nums[0];
		if(len>2){
		
			for(int i=2;i<len;i++){
				int diff = nums[i] - nums[i-1];
				if(diff!=initd) return false;
			}
		}
		return true;
	}
	
	static String isArithmetic(int[] nums){
		boolean notSorted = check(nums, nums.length);
		if(notSorted) return "arithmetic";
		
		Arrays.sort(nums);
		boolean sorted = check(nums, nums.length);
		if(sorted) return "permuted arithmetic";
		
		return "non-arithmetic";
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		
		//for each row
		for(int i=0; i<rows;i++){
			int numbersCount = scanner.nextInt();
			int[] nums = new int[numbersCount];
			
			//read nums
			for(int j=0;j<numbersCount;j++){
				//System.out.println(j + "num: "+ Integer.parseInt(scanner.next()));
				nums[j] = scanner.nextInt();
			}
			
			System.out.println(isArithmetic(nums));
			
		}
	}
}
