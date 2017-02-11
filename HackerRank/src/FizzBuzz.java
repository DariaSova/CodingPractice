import java.util.*;

public class FizzBuzz {
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter a number from 1 to 100:");
			int number = in.nextInt();
			
			if(number==0)
				System.out.println(number +":(");
			if(number%3==0){
				if(number%5==0)
					System.out.println("FIZZBUZZ!!");
				else
					System.out.println("FIZZ");
			}else if(number%5==0){
				System.out.println("BUZZ");
			}else
				System.out.println(number +":(");
			
			
		}
		//in.close();
	}

}
