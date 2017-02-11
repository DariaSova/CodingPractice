import java.util.*;

class Node{
	int value;
	Node right;
	Node left;
	boolean visited;
	
	public Node(int x) {
		value = x;
		right = null;
		left = null;
		visited = false;
	}
	
	Node getChild(){
		if(right!=null&&!right.visited)
			return right;
		else if(left!=null&&!left.visited)
			return this.left;	
		return null;
	}
}

public class BFS {
	
	static void DFS(Node root){
		if(root==null)
			return;
		
		Stack<Node> s = new Stack<Node>();
		
		s.add(root);
		root.visited = true;
		
		while(!s.isEmpty()){
			Node curr = s.pop();
			System.out.println(curr.value);
			Node child = curr.getChild();
			
			while(child!=null){
				s.add(child);
				child.visited=true;
				child = curr.getChild();
			}
			
			
		}
		
	}
	
	
	static void Bfs(Node root) {
		if(root==null)
			return;
		
		Queue<Node> q = new LinkedList<Node>(); 
		q.add(root);
		
		while(!q.isEmpty()){
			Node curr = q.remove();
			curr.visited = true;
			System.out.println(curr.value);
			
			Node child = curr.getChild();
			while(child!=null){
				child.visited = true;
				q.add(child);
				child = curr.getChild();
			}
		}
	}
	
	
	public static void main(String[] args){
		Node a = new Node(10);
		a.left = new Node(7);
		a.right = new Node(17);
		a.left.left = new Node(3);
		a.right.left = new Node(50);
		
		//Bfs(a);
		System.out.println("==========================");
		DFS(a);
	}

}
