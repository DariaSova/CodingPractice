import java.util.*;

import FindDuplicates.Node;
public class Graph {
	List<Vertex> g;
	
	public static class Vertex {
		String name;
		boolean visited;
		List<Vertex> neighbours;
		
		public Vertex(String n, List<Vertex> l){
			name = n;
			neighbours = l;
			visited = false;
		}
		
		public Vertex getUnvisited(){
			if(neighbours!=null){
				for(Vertex v: neighbours){
					if(!v.visited)
						return v;
				}
			}
			return null;
		}
		
	}
	
	public static class Node{
		public int x;
		public Node right;
		public Node left;
		
		public Node(int val){
			x = val;
			right = null;
			left = null;
		}
	}
	
	public void listToBST(Node n){
		int len =0;
		Node head = n;
		while(head!=null){
			len++;
			head = head.right;
		}
		helper(n, len);
	}
	
	public Node helper(Node n , int len){
		if(len==0)
			return null;
		Node h = n;
		h.left = helper(n, len/2);
		h.right = helper(n.right, len/2);
		
		return h;
	}
	
	public Graph(){
		g = new ArrayList<Vertex>();
	}
	
	public boolean hasPath(Vertex a, Vertex b){
		Queue<Vertex> q = new LinkedList<Vertex>();
		
		q.add(a);
		a.visited = true;
		
		while(!q.isEmpty()){
			Vertex curr = q.poll();
		//check if it's null
		if(curr.neighbours!=null && !curr.neighbours.isEmpty())	{
			for(Vertex n: curr.neighbours){
				if(!n.visited){
					if(n==b)
						return true;
					q.add(n);
					n.visited = true;
				}
			}
		}
		}
		
		return false;
	}
	
	public boolean hasPathDFS(Vertex a, Vertex b){
		Stack<Vertex> s = new Stack<Vertex>();
		
		s.add(a);
		a.visited = true;
		
		while(!s.isEmpty()){
			Vertex curr = s.peek();
			if(curr.getUnvisited()!=null){
				Vertex child = curr.getUnvisited();
				if(child == b)
					return true;
				s.add(child);
				child.visited = true;
			}else{
				s.pop();
			}
		}
		
		return false;
	}
	
	public static void main (String[] args){
		Graph g = new Graph();
		Vertex b = new Vertex("b", null);
		Vertex c = new Vertex("c", null);
		Vertex d = new Vertex("d", null);
		List<Vertex> an = new ArrayList<Vertex>();
		an.add(b);
		an.add(c);
		an.add(d);
		Vertex a = new Vertex("a", an );
		
		System.out.println(g.hasPath(a,c));
		System.out.println(g.hasPath(b,a));
		System.out.println(g.hasPathDFS(a,c));
		System.out.println(g.hasPathDFS(b,a));
		
	}
}
