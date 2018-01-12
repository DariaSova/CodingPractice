import java.util.*;

public class TornToPieces {
	static Map<String, HashSet<String>> GR;
	
	public static boolean dfs(String start, String finish, Set<String> visited, Stack<String> path){
		if (visited.contains(start)) return false;

	    visited.add(start);
	    path.push(start);

	    if (start.equals(finish)) return true;

	    for (String neighbor : GR.get(start)) {
	      if(!visited.contains(neighbor) && dfs(neighbor, finish, visited, path)) return true;
	    }

	    path.pop();
	    return false;
			
	}
	
	public static void addNode(String n){
		if(!GR.containsKey(n)) GR.put(n, new HashSet<String>());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int peices = sc.nextInt();
		GR = new HashMap<>(peices);
		sc.nextLine();
		
		//make graph connections
		for(int i =0; i<peices; i++){
			String[] stations = sc.nextLine().split(" ");
			
			String start = stations[0];
					
			for(int k=1; k<stations.length; k++){
				String n = stations[k];
				addNode(n); addNode(start);
				GR.get(start).add(n);
				GR.get(n).add(start);
			}
			
		}
		
		//read requirements
		String[] in = sc.nextLine().split(" ");
		String start = in[0]; addNode(start);
		String end = in[1]; addNode(end);
		
		Set<String> visited = new HashSet<String>();
		Stack<String> path = new Stack<String>();
		
		boolean res = dfs(start, end, visited, path);

		if(res){
			int j=0;
			for (j = 0; j < path.size()-1; j++) {
		        System.out.print(path.get(j)+ " ");
		      }
			System.out.print(path.get(j));
			
		}else{
			System.out.print("no route found");
		}
		  System.out.print("\n");
		  sc.close();
	}
}








