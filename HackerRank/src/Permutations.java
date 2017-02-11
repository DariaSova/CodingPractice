
public class Permutations {
	static int perm(int N, int K, int i){
		int res = 0;
		
		if(N==0)
			return 1;
		else if(N<0)
			return 0;
		else{
			if(i>K)
				return 0;
			//for(int i=1; i<=K; i++){
			//	res+= perm(N-i, K);
			//}
			res = perm(N-i, K, i) + perm(N, K, i+1);
		}
		
		
		
		return res;
	}
	
	public static void main(String[] args){
		int res = perm(3, 10, 1);
		System.out.println(res);
	}

}
