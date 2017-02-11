
public class Similarity {
	static int similarity(String s1, String s2){
        if(s1.startsWith(s2)){
                System.out.println("p:"+s2.length()+s2);
            return s2.length();
        
        }
        return 0;
    }

    static int[] stringSimilarity(String[] inputs) {
        int[] fres = new int[inputs.length];
        for(int i=0; i<inputs.length; i++){
            //each string
            String curr = inputs[i];
            int res = curr.length();
            //for(int j=0; j<curr.length(); j++){
                for(int k=1; k<curr.length(); k++){
                    String sub = curr.substring(k, curr.length());
                    res+= similarity(curr, sub);
                }
            //}
            fres[i] = res;
        }
        return fres;
    }
    
    public static void main(String[] args) {
    	String[] in = {"ababaa"};
       stringSimilarity(in);
    }

}
