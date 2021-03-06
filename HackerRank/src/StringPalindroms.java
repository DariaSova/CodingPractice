import java.util.*;

public class StringPalindroms {
	
	static boolean isPalindrome(String s){
		int j = s.length()-1;
		char[] chars = s.toCharArray();
		for(int i=0; i<s.length()/2; i++){
			if(chars[i]!=chars[j])
				return false;
			j--;
		}
		
		return true;
	}
	
	static int allPalindromes(String[] words){
		int count =0;
		Map<String, Set<String>> set = new HashMap<String, Set<String>>();
		
		for(int i=0; i<words.length; i++){
			String curr = words[i];
			StringBuilder reversed = new StringBuilder(curr).reverse();
			if(set.containsKey(reversed.toString()))
				count+=set.get(reversed.toString()).size();
			Set<String> s = new HashSet<String>();
			s.add(curr);
			set.put(curr, s);
			///seperate function
			for(int j=1; j< curr.length(); j++){
				String left = curr.substring(0, j);
				String right = curr.substring(j);
				if(isPalindrome(left)){
					String rev = new StringBuilder(right).reverse().toString();
					Set<String> s2 = new HashSet<String>();
					if(set.containsKey(rev)&&set.get(rev).contains(rev)) //maybe 1?
						count++;
					
					if(set.containsKey(right)){
						s2 = set.get(right);
					}
					s2.add(left);
					set.put(right, s2);
				}
				if(isPalindrome(right)) {
					String rev = new StringBuilder(left).reverse().toString();
					Set<String> s2 = new HashSet<String>();
					if(set.containsKey(rev)&&set.get(rev).contains(rev))
						count++;
					if(set.containsKey(left)){
						s2 = set.get(left);
					}
					s2.add(right);
					set.put(left, s2);
				}
			}
		}
		return count;
	}
	
	static int findPalindromes(String[] words){
		int count =0;
		Set<String> set = new HashSet<String>();
		
		for(int i=0; i<words.length; i++){
			String curr = words[i];
			StringBuilder reversed = new StringBuilder(curr).reverse();
			if(set.contains(reversed.toString()))
				count++;
			set.add(curr);
		}
		return count;
	}
	
	//kkl
	
	public static void main(String[] args){
		String[] words = {"abc", "cat", "cd", "tac", "car", "rac", "mk", "cba", "cba"}; //2possible palindromes
		System.out.println(findPalindromes(words));
		String[] otherWords = {"abc", "ba", "cb", "cat", "ta", "atmmmmmm"};
		String[] w3 = {"abc", "ba", "cat", "ta", "atmmmmmm"};
		String[] w4 = {"a", "c", "ba", "ta", "cakmk", "ac"};
		//System.out.println(allPalindromes(otherWords));
		System.out.println(allPalindromes(w4));
	}

}
