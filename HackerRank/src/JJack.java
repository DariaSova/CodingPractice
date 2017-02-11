
public class JJack {
	
    static boolean skipsK(int curr, int action, int n, int k){

        while(action<=n&&curr<=k){
            if(curr==k) //we step on broken step
                return false;
            curr+=action;
            action++;
        }
        //curr>k we know we jumped over it
        return true;
    }
	
	static int maxStep(int n, int k) {
        //return helper(n,k,0,1);
    	 int curr =0;
         int action =1;
         
         //for(int i=0; i<n; i++){
         while(action<=n){
             if(skipsK(curr, action, n, k))
                 return sum(action, n);
             //curr+=action;
             action++;
         }
         return 0;
     }
    
    static int sum(int curr, int n){
        int sum=curr;
        for(int i=curr+1; i<=n; i++){
            sum+=i;
        }
        return sum;
    }


     static int helper(int total, int skip, int curr, int currAction){
         if(curr==skip)
             return -1;
         if((currAction-1)==total)
             return curr;
         
         int max = Math.max(helper(total,skip,curr+currAction,currAction+1),             
        		 helper(total,skip,curr,currAction+1));
         
         return max;
     }
     
     public static void main(String[] args){
    	 System.out.println(maxStep(2,1));
     }

}
