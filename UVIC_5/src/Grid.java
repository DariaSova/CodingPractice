import java.util.*;

public class Grid {
//	static class Node{
//		int i;
//		int j;
//		Node(int x, int y){
//			this.i =x;
//			this.j =y;
//		}
//	}
	static HashMap<Integer, HashSet<Integer>> hm;
	static boolean isValid(int i, int j, int n, int m){
		if(i>=0&&i<n&&n>=0&&n<m) return true;
		return false;
	}
	
	public static boolean dfs(int start, int finish, Set<Integer> visited, Stack<Integer> path){
		if (visited.contains(start)) return false;

	    visited.add(start);
	    path.push(start);

	    if (start==finish) return true;

	    for (Integer neighbor : hm.get(start)) {
	      if(!visited.contains(neighbor) && dfs(neighbor, finish, visited, path)) return true;
	    }

	    path.pop();
	    return false;
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] table = new int[n][m];
		hm = new HashMap<>();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				table[i][j] = sc.nextInt();
				hm.put(i*10+j, new HashSet<>());
			}
		}
		
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				int val = table[i][j];
				if(val>0){
					if(isValid(i+val, j, n ,m)) hm.get(i*10+j).add((i+val)*10+j);
					if(isValid(i-val, j, n ,m)) hm.get(i*10+j).add((i-val)*10+j);
					if(isValid(i, j+val, n ,m)) hm.get(i*10+j).add(i*10+(j+val));
					if(isValid(i, j-val, n ,m)) hm.get(i*10+j).add(i*10+(j-val));
				}
			}
		}
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> path = new Stack<>();
		boolean res = dfs(0, 10*(n-1)+(m-1), visited, path);
		System.out.println(res);
	}
}
