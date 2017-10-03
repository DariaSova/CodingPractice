import java.lang.reflect.Array;
import java.util.*;
import java.math.*;

public class FruitBasket {
	static long invalidSum = 0;
	
	public static void combinations(int[] nums, int index, long sum, int currLevel) {
		//rescusrece
			for(int i=index; i<nums.length&&currLevel<=3; i++){
				if(nums[i]+sum<200){
					invalidSum += nums[i]+sum;
					combinations(nums, i+1, nums[i]+sum, currLevel+1);
				}
			}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int[n];
		
		for(int i=0; i<n; i++){
			nums[i] = sc.nextInt();
		}
		
		long allSets = 0;


		
//		long set1 =0, set2 =0, set3 = 0;
		
		for(int i=0; i<n; i++){
			//if(nums[i]<200) set1+=nums[i];
			allSets += nums[i];
		}
		
//		System.out.println(allSets);
//		allSets *= 1 << (n-1);
		allSets *= Math.pow(2,n-1);
		combinations(nums, 0, 0, 1);
//		System.out.println(allSets);
		long res = allSets-invalidSum;
//		
//		for(int i=0; i<n; i++){
//			for(int j=i+1; j<n; j++){
//				if(nums[i]+nums[j]<200)	set2 +=	nums[i]+nums[j];
//			}
//		}
//		
//		for(int i=0; i<n; i++){
//			for(int j=i+1; j<n; j++){
//				for(int k=j+1; k<n; k++){
//					int sum = nums[i] + nums[j] +nums[k];
////					System.out.println();
//					if(sum<200) set3+= sum;
//				}
//			}
//		}
//		
////		System.out.println(allSets);
//		long res = allSets - set1 - set2 - set3;
		System.out.println(res);
		sc.close();
	}
}