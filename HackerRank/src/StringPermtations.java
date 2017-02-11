import java.util.*;

public class StringPermtations {
	
	static Set<String> allPermutations(String s){
		Set<String> set = new HashSet<String>();
		
		if(s.length()==0){
			set.add("");
			return set;
		}
		
		char curr = s.charAt(0);
		String rem = s.substring(1);
		Set<String> words = allPermutations(rem);
		
		for(String word: words){
			for(int i=0; i<=word.length(); i++){
				String newS = insertChar(curr, word, i);
				set.add(newS);
			}
		}
		return set;
	}
	
	static String insertChar(char c, String word, int i){
		String left = word.substring(0, i);
		String right = word.substring(i);
		return left+c+right;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static Set<String> perms(String str){
		Set<String> set = new HashSet<String>();
		
		if(str.length()==0){
			set.add("");
			return set;
		}
		
		char curr = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = perms(rem);
		
		//join
		for(String word: words){
			for(int i=0; i<=word.length(); i++){
				String res = insert(word, curr, i);
				set.add(res);
			}
		}
		return set;
	}
	
	static String insert(String word, char curr, int i){
		String left = word.substring(0, i);
		String right = word.substring(i);
		return left+curr+right;
	}
	
	/*static ArrayList<String> getWords(String s){
		
	}
	
	static void permutations(String s, int index){
		char[] chars = s.toCharArray();
		int len = chars.length;
		
		for(int i=0; i<len; i++){
			String left = s.substring(0, i);
			char curr = chars[i];
			String right = s.substring(i+1, len-1);
			ArrayList<String> words = new ArrayList<String>();
			
		}
		
		
	}*/
	
	 public static void main(String args[]){
		 String s = "ABC";
//		 Set<String> res = allVariations(s);
		 Set<String> res = allPermutations(s);
		 System.out.println(res.size());
		 for(String r: res){
			 System.out.println(r);
		 }
	 }
	 
	 
	 static Set<String> allVariations(String str){
		 Set<String> set = new HashSet<String>();
		 
		 if(str.length()==0){
			 set.add("");
			 return set;
		 }
			 
		 
		 char curr = str.charAt(0);
		 String rem = str.substring(1);
		 Set<String> words = allVariations(rem);
		 
		 for(String word: words){
			 for(int i=0; i<=word.length(); i++){
				 String res = insert(word, curr, i);
				 set.add(res);
			 }
		 }
		 return set;
	 }

}
