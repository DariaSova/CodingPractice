import java.util.*;
import java.math.*;

public class FruitBasket2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int[n];
		
		for(int i=0; i<n; i++){
			nums[i] = sc.nextInt();
		}
		
		long allSets = 0;


		
		long set1 =0, set2 =0, set3 = 0;
		
		for(int i=0; i<n; i++){
			if(nums[i]<200) set1+=nums[i];
			allSets += nums[i];
		}
		
//		allSets *= Math.pow(2,n-1);
		//int will overflow
		allSets *= 1L << (n-1);


		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				if(nums[i]+nums[j]<200)	set2 +=	nums[i]+nums[j];
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				for(int k=j+1; k<n; k++){
					long sum = nums[i] + nums[j] +nums[k];
					if(sum<200) set3+= sum;
				}
			}
		}
		
		long res = allSets - set1 - set2 - set3;
		System.out.println(res);
		sc.close();
	}
}
