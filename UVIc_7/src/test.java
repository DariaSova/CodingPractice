
public class test {
	public static int[] fibonacci2(int n)  {
		int[] res = new int[n];
		if (n>=1)
			res[0] = 0;
		if(n>=2)
			res[1] =1;
		for(int i=2; i<n; i++){
			res[i] = res[i-1] + res[i-2];
		}
		return res;
	}
	
	public static int[] fibonacci(int n, int[] res)  {
	    if(n == 0)
	    	res[n] = 0;
//	        return 0;
	    else if(n == 1)
	    	res[n] = 1;
//	      return 1;
	   else
//	    fibonacci(n - 1, res);
//	    fibonacci(n - 2, res);
//	    res[n] = res[n] + res[n-2];
//	    res[n] = fibonacci(n - 1, res)[n-1] + fibonacci(n - 2, res)[n-2];

	    
	   return res;
	}
	
	public static void main(String[] args) {
		int[] result = new int[7];
		result = fibonacci2(0);
		
		for(int a: result) System.out.println(a);
	}
}
