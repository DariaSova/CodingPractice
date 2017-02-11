
	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class Reverse {
	    
	    public static int[] reverse(int[] arr, int n){
	        int swaps = n/2;
	        int j = n-1;
	        for(int i=0; i<swaps; i++){
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            j--;
	        }
	        return arr;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int arr[] = new int[n];
	        for(int arr_i=0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }
	        arr = reverse(arr, n);
	        for(int i=0; i<n; i++){
	            System.out.print(arr[i]+" ");
	        }
	    }
	}
