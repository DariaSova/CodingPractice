import java.util.*;

import Squawk.Node;

public class Squawk2 {

	 public static void main(String[] args) {
		 int usersNum, linksNum, startUser, time; 
		 
		 Scanner sc = new Scanner(System.in);
		 usersNum =  sc.nextInt();
		 linksNum = sc.nextInt();
		 startUser = sc.nextInt();
		 time = sc.nextInt(); 
		 
//		 int[][] graph = new int[usersNum];
		 
		 for(int i=0; i<usersNum; i++){
			 graph[i] = new Node(i);
		 }
		 
		 for(int i=0; i<linksNum; i++){
			 int a = sc.nextInt();
			 int b = sc.nextInt();
			 graph[a].friends.add(graph[b]);
			 graph[b].friends.add(graph[a]);
		 }
		 
//		 Queue<Node> q = new PriorityQueue<Node>();  
//		 q.add(graph[startUser]);
//		 int count = 0;
//		 
//		 //keep rack of iterations
//		 while(count<time){
//			 count++;
//			 Queue<Node> nextq = new LinkedList<Node>();
//			 while(!q.isEmpty()){
//				 Node curr = q.remove();
//				 for(Node n: curr.friends)
//					 nextq.add(n);
//			 }
//			 q = nextq;
//		 }
//		 System.out.println(q.size());
	 }
}
