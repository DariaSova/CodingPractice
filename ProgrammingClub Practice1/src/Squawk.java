import java.util.*;

public class Squawk {
	static class Node{
		int name;
		ArrayList<Node> friends;
		public Node(int n){
			name = n;
			friends = new ArrayList<Node>();
				
		}
	}
	
 public static void main(String[] args) {
	 int usersNum, linksNum, startUser, time; 
	 
	 Scanner sc = new Scanner(System.in);
	 usersNum =  sc.nextInt();
	 linksNum = sc.nextInt();
	 startUser = sc.nextInt();
	 time = sc.nextInt(); 
	 
	 Node[] graph = new Node[usersNum];

	 for(int i=0; i<usersNum; i++){
		 graph[i] = new Node(i);
	 }
	 
	 for(int i=0; i<linksNum; i++){
		 int a = sc.nextInt();
		 int b = sc.nextInt();
		 graph[a].friends.add(graph[b]);
		 graph[b].friends.add(graph[a]);
	 }
	 
	 Stack<Node> q = new Stack<Node>();  
	 q.add(graph[startUser]);

	 
//	 //keep rack of iterations
//	 for(int i=0; i<time; i++){
//		 Stack<Node> nextq = new Stack<Node>();
//		 while(!q.isEmpty()){
//			 Node curr = q.pop();
//			 nextq.addAll(curr.friends);
//		 }
//		 q = nextq;
//	 }
//	 System.out.println(q.size());
	 
	 
	 //Another implementation
	 HashMap<Integer, Long> infected = new HashMap<Integer, Long>();
	 
	 infected.put(startUser, (long)1);
	 
	 for(int i=0; i<time; i++){
		 HashMap<Integer, Long> nInfected = new HashMap<Integer, Long>();
		 Set<Integer> keys = infected.keySet();
		 for(int k: keys){
			 ArrayList<Node> adj = graph[k].friends;
			 for(Node n: adj){
				 long cost = infected.get(k);
				 long newcost =0;
				 if (nInfected.containsKey(n.name)) newcost = nInfected.get(n.name);
				 nInfected.put(n.name, cost+newcost);
			 }
		 }
		 infected = new HashMap<Integer, Long>(nInfected);
	 }
	 long res = 0;
	 for(long c: infected.values()) res+=c;
	 System.out.println(res);
	 sc.close();
 }
}