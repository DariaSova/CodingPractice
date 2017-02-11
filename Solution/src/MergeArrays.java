import java.util.Arrays;

public class MergeArrays {
	static int[] merge(int[] a, int[] b,int k){

	int curr = a.length -1;
	int currA = k; //implement?
	int currB = b.length - 1;


	while(currB>=0){
		if(currA>=0 && a[currA]>b[currB]){
			a[curr] = a[currA];
			currA--;
		}else{
			a[curr] = b[currB];
			currB--;
		}
		curr--;
	}
	return a;
}
	public static void main(String[] args){
		int [] a = {1, 12, 13, 25, 30, 0,0,0,0,0};
		int [] b = {2, 4, 15, 26, 100};
		
		int [] res = merge(a,b,4);
		System.out.println(Arrays.toString(res));
	}

}
