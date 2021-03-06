
public class MergeSort {
	
	static void sort2(int[] arr){
		int [] temp = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length-1);
	}
	
	static void mergeSort(int[] arr, int[] tmp, int left, int right){
		if(left<right){
			int n = left+right;
			int middle = n/2;
			mergeSort(arr, tmp, left, middle);
			mergeSort(arr, tmp, middle+1, right);
			merge2(arr, tmp, left, middle+1, right);
		}
	}
	
	static void merge2(int[] arr, int[] tmp, int left, int right, int rEnd){
		int k=left;
		int lEnd =right-1;
		int n = rEnd - left +1;
		while(left<=lEnd&&right<=rEnd){
			if(arr[left]<arr[right]){
				tmp[k++] = arr[left++];
			}else{
				tmp[k++] = arr[right++];
			}
		}
		
		while(left<=lEnd){
			tmp[k++] = arr[left++];
		}
		while(right<=rEnd){
			tmp[k++] = arr[right++];
		}
		
		for(int i=0; i<n; i++, rEnd--){
			arr[rEnd] = tmp[rEnd];
		}
	}
	
	
	static int[] sort(int[] arr){
		int n = arr.length;
		
		if(n==1) return arr;
		
		int res[] = new int[n];
		
		int [] left = new int[n/2];
		System.arraycopy(arr, 0, left, 0, n/2);
		int [] right = new int[n-n/2];
		System.arraycopy(arr, n/2, right, 0, n-n/2);
		
		left = sort(left);
		right = sort(right);
		res = merge(left, right);
		
		return res;
	}
	
	static int[] merge(int[] arr1, int[] arr2){
		int [] res = new int[arr1.length+arr2.length];
		
		int l =0;
		int h = 0;
		int i=0;
		
		while(l<arr1.length && h<arr2.length){
			if(arr1[l] < arr2[h]){
				res[i++] = arr1[l++];
			}else{
				res[i++] = arr2[h++];
			}
		}
		
		while(l<arr1.length){
			res[i++] = arr1[l++];
		}
		while(h<arr2.length){
			res[i++] = arr2[h++];
		}
		
		return res;
	}
	
	public static void main(String[] args){
		//int [] nums = {1, 5, 3, 0, 2};
		int [] nums = {100, -1, 0, 1, 5, 3, 0, 2, 12};
		//int[] sorted = sort(nums);
		//sort2(nums);
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		
		System.out.print("============");
		
		mergeSort3(nums);
	}
	
	
	
	
	
	
	
	
	
	static void mergeSort3(int[] nums){
		int len = nums.length;
		int[] temp = new int[len];
		divide(nums, temp, 0, len-1);
		for(int num: nums)
			System.out.println(num);
		
	}
	
	static void divide(int[] nums, int[] temp, int left, int right){
		if(left<right){
			int middle = (right+left)/2;
			divide(nums, temp, left, middle);
			divide(nums, temp, middle+1, right);
			merge(nums, temp, left, middle+1, right);
		}
	}
	
	static void merge(int[] nums, int[] temp, int left, int right, int rEnd){
		int l = left;
		int r = right;
		int i = left;
		
		while(l<right && r<= rEnd){
			if(nums[l]<nums[r]){
				temp[i++] = nums[l];
				l++;
			}else{
				temp[i++] = nums[r];
				r++;
			}
		}
		
		while(l<right){
			temp[i++] = nums[l++];
		}
		
		while(r<= rEnd){
			temp[i++] = nums[r++];
		}
		
		//copy back
		for(int j=left; j<=rEnd; j++){
			nums[j] = temp[j];
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
