
public class ChangeProblem {
	
	
	static int ways1(int n, int[] nums, int i){
		
		if(n<0||(i>=nums.length&&n>0))
			return 0;
		if(n==0)
			return 1;
		
		return ways1(n-nums[i], nums, i+1) + ways1(n, nums, i+1);
		
	}
	
	
	public static void main(String[] args){
		int[] nums = { 7, 2, 1, 4, 5, 6};
		
		System.out.println(ways1(6,nums,0));
		
	}

}
