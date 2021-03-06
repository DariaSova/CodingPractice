import java.util.*;

public class Alphabet {
	
	static class Vertex{
		char letter;
		ArrayList<Vertex> incoming;
		ArrayList<Vertex> outgoing;
		
		public Vertex(char c){
			letter = c;
			incoming = new ArrayList<Vertex>();
			outgoing = new ArrayList<Vertex>();
		}
		
		void addIncoming(Vertex in){
			incoming.add(in);
		}
		
		void addOutgoing(Vertex in){
			outgoing.add(in);
		}
		
	}
	
	static class Graph{
		Set<Vertex> vertices;
		
		public Graph(){
			vertices = new HashSet<Vertex>();
		}
		
		void removeVertex(Vertex v){
			for(Vertex out: v.outgoing){
				out.incoming.remove(v);
			}
			vertices.remove(v);
		}
		
		void addV(Vertex v){
			vertices.add(v);
		}
		
		Vertex findV(char c){
			for(Vertex v: vertices){
				if(v.letter==c)
					return v;
			}
			return null;
		}
		
		Vertex findNoIncoming(){
			for(Vertex v: vertices){
				if(v.incoming.size()==0)
					return v;
			}
			return null;
		}
	}
	
	static ArrayList<Character> alphabet(Graph graph){
		ArrayList<Character> res = new ArrayList<Character>();
		Vertex noIn = graph.findNoIncoming();
		
		while(noIn!=null){
			res.add(noIn.letter);
			graph.removeVertex(noIn);
			noIn = graph.findNoIncoming();
		}
		
		
		return res;
	}
	
	static Graph buildGraph(String[] words){
		int len = words.length;
		Graph graph = new Graph();
		
		for(int i=0; i<len-1; i++){
			char[] w1 = words[i].toCharArray();
			char[] w2 = words[i+1].toCharArray();
			int j=0;
			while(j<w1.length && j<w2.length && w1[j]==w2[j]){
				j++;
			}
			if(j<w1.length && j<w2.length){
				Vertex v1 = graph.findV(w1[j]);
				Vertex v2= graph.findV(w2[j]);
				
				if(v1==null){
					v1 = new Vertex(w1[j]);
					graph.addV(v1);
				}
				if(v2==null){
					v2 = new Vertex(w2[j]);
					graph.addV(v2);
				}
				
				v1.outgoing.add(v2);
				v2.incoming.add(v1);
			}
			
		}
		return graph;
	}
	
	public static void main(String[] args){
		String[] words = {"caa", "aaa", "aab"};
		String[] words2 = {"baa", "abcd", "abca", "cab", "cad"};
		
		Graph graph = buildGraph(words2);
		//Set<Character> letters = new HashSet<Character>();
		
		
		System.out.println("Built the graph!");
		System.out.println(alphabet(graph).toString());
	}

}
