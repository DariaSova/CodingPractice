import java.io.*;
import java.util.*;
import java.math.*;

public class Brackets {

	public static void main(String[] args) {
		
		int number = 3;

		char[] arr = new char[2*number];

		generateBrackets(arr, 0, 0);

	}

	private static void generateBrackets(char[] arr, int i, int balance) {
		
		if(i == arr.length){
			if(balance == 0) {
				
				for(int j=0; j<arr.length; j++)
					System.out.print(arr[j]);
				System.out.println();
			}
			return;
		}

		else {

			arr[i] = '{';
			generateBrackets(arr, i+1, balance+1);

			if(balance != 0){
				arr[i] = '}';
				generateBrackets(arr, i+1, balance-1);
			}
		}
	}	
}