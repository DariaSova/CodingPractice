import java.util.*;

class Node{
	String name;
	ArrayList<Node> neighbours;
	
	public Node(String n){
		name = n;
		neighbours = new ArrayList<Node>();
	}
}

class Graph{
	ArrayList<Node> nodes;
	public Graph(){
		nodes = new ArrayList<Node>();
	}
}

public class Torn2Pieces {
	
	static void DFS(Graph graph, Node start, String destination){
		Stack<Node> stack = new Stack<Node>();
		//Node current = start;
		for(Node n : start.neighbours){
			stack.add(n);
		}
		
		Node curr = stack.pop();
		while(!stack.isEmpty()){
			
		}
	}


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		Graph graph = new Graph();
		for(int i=0; i<n; i++){
			String input = scanner.nextLine();
			String[] in = input.split(" ");
			Node current = new Node(in[0]);
			for(int j =1; j<in.length; j++){
				current.neighbours.add(new Node(in[j]));
			}
			graph.nodes.add(current);
		}
		
		//read destination
		
		scanner.close();
	}
}
