import java.util.*;

public class ABC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[3];
		for(int i=0; i<3; i++){
			nums[i] = sc.nextInt();
		}
		sc.nextLine();
		char [] in = sc.nextLine().toCharArray();
//		int peices = sc.nextInt();
		
		Map<Character, Integer> hm = new HashMap<>(3);
		
		Arrays.sort(nums);
		hm.put('A', nums[0]);
		hm.put('B', nums[1]);
		hm.put('C', nums[2]);
		
//		for(char c: in){
			System.out.print(hm.get(in[0])+" ");
			System.out.print(hm.get(in[1])+" ");
			System.out.print(hm.get(in[2]));
//		}
	}
}
