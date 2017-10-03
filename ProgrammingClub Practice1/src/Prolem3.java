import java.util.Scanner;

public class Prolem3 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int[] dogsTime = new int[4];
		for(int i=0; i<4;i++){
			dogsTime[i] = scanner.nextInt();
		}
		int[] peopleTime = new int[3];
		for(int i=0; i<3;i++){
			peopleTime[i] = scanner.nextInt();
		}

		
		int A = dogsTime[0];
		int B = dogsTime[1];
		int C = dogsTime[2];
		int D = dogsTime[3];
		
		for(int i=0; i<peopleTime.length; i++){
			int curr = peopleTime[i];
			
			//firstdog
			int dog1 = curr%(A+B);
			int dog2 = curr%(C+D);
			
			int count =0;
			if(dog1>0&&dog1<=A) count++;
			if(dog2>0&&dog2<=C) count++;
			
			if(count==0) System.out.println("none");
			if(count==1) System.out.println("one");
			if(count==2) System.out.println("both");
		}
	}
}
