
public class QuickSort {

	static void babbleSort(int[] arr){
		boolean changed = true;
		
		while(changed){
			changed = false;
			for(int i = 0; i<arr.length-1; i++){
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					changed = true;
				}
			}
		}
	}
	
	static void quickSort(int[] arr, int low, int high){
		int n = arr.length;
		
		if(arr==null || n==0 || low>=high) 
			return;
		
		int middle = (low +high)/2;
		int pivot = arr[middle];
		
		int l=low;
		int h=high;
		
		while(l<h){
			while(arr[l]<pivot){
				l++;
			}
			while(arr[h]>pivot){
				h--;
			}
			
			if(l<=h){
				int temp = arr[l];
				arr[l++] = arr[h];
				arr[h--] = temp;
			}
		}
		
		if(low<h)
			quickSort(arr, low, h);
		if(high>l)
			quickSort(arr, l, high);
		
	}
	
	
	public static void main(String[] args){
		//int [] nums = {1, 5, 3, 0, 2};
		int [] nums = {100, -1, 0, 1, 5, 3, 0, 2, 12, 4, 96};
		//int[] sorted = sort(nums);
		quickSort(nums, 0, nums.length-1);
		//babbleSort(nums);
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println("Sort finished.");
	}
}
