import java.util.*;

public class AllSubsets {
	
	
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSets;
		if(set.size()==index){
			allSets = new ArrayList<ArrayList<Integer>>();
			allSets.add(new ArrayList<Integer>());
		}else {
			allSets = getSubsets(set, index -1);
			ArrayList<ArrayList<Integer>>  moreSets = new ArrayList<ArrayList<Integer>> ();
			//int item = set.get(index);
			int item = index;
			for(ArrayList<Integer> subSet : allSets){
				ArrayList<Integer> newSet = new ArrayList<Integer>();
				newSet.addAll(subSet);
				newSet.add(item);
				moreSets.add(newSet);
			}
			allSets.addAll(moreSets);

		}
		
		return allSets;
	}
	
	
	public static void main (String[] args){
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		ArrayList<ArrayList<Integer>> mySet = new ArrayList<ArrayList<Integer>>();
		mySet = getSubsets(new ArrayList<Integer>(), 3);
		
		for(ArrayList<Integer> cset: mySet){
			System.out.println(Arrays.toString(cset.toArray()));
			System.out.println("\nnext:");
		}
	
	}

}
