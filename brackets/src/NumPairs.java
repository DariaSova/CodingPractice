import java.util.Arrays;

public class NumPairs {
	
	static void printPairs(int[] arr, int[] res, int k, int index, int currStart){
		int len = arr.length;
		//if(len<1)
		//	return;
		if(index==k)
			System.out.println(Arrays.toString(res));

		for(int i=currStart; i<len&&index<k; i++){
			res[index] =arr[i];
			printPairs(arr, res, k, index+1, i+1);

		}
		

		
	}
	
	
	public static void main(String[] args){
		int [] nums = {1,2,3,4};
		int k =2;
		int [] res = new int[k];
		printPairs(nums, res, k, 0, 0);
		
	
	}

}
