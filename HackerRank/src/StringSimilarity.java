
public class StringSimilarity {
	/*
	 * Complete the function below.
	 */
    static int[] zArray(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] res = new int[len];
        
        res[0] = 0;
        int right =0;
        int left = 0;
        int k;
        
        for(k=1; k<len; k++){
           if(k>right){
               left=right=k;
               while(right<len&&chars[right]==chars[right-left]){
                   right++;
               }
               res[k] = right-left;
               right--;
               
           }else{//k is inside Zbox
               int k1 = k-left;
               if(k+res[k1]<right){
                   //just copy the old value
                   res[k] = res[k1];
               }else{//recalculate
                   left = k;
                   
                   while(right<len&&chars[right]==chars[right-left]){
                    right++;
                   }
                    res[k] = right-left;
                    right--;     
               }
           }
            
        }
        return res;
    }


    static int[] stringSimilarity(String[] inputs) {
        int[] finalRes = new int[inputs.length];
        
        for(int n=0; n<inputs.length; n++){
            int sum=0;
            int [] res = zArray(inputs[n]);
            for(int i=0; i<res.length; i++){
                sum+=res[i];
            }
            finalRes[n] = sum+res.length;
        }
        
       
        return finalRes;
    }
	    
	    public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        final String fileName = System.getenv("OUTPUT_PATH");
	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	        int[] res;
	        
	        int _inputs_size = 0;
	        _inputs_size = Integer.parseInt(in.nextLine().trim());
	        String[] _inputs = new String[_inputs_size];
	        String _inputs_item;
	        for(int _inputs_i = 0; _inputs_i < _inputs_size; _inputs_i++) {
	            try {
	                _inputs_item = in.nextLine();
	            } catch (Exception e) {
	                _inputs_item = null;
	            }
	            _inputs[_inputs_i] = _inputs_item;
	        }
	        
	        res = stringSimilarity(_inputs);
	        for(int res_i=0; res_i < res.length; res_i++) {
	            bw.write(String.valueOf(res[res_i]));
	            bw.newLine();
	        }
	        
	        bw.close();
	    }
	}


}
