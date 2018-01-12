import java.util.*;


public class GraphProblems{
	
	    public static long dist[];
	    public static long prev[];
	    public static LinkedList<DirectedEdge> edgesList = new LinkedList<DirectedEdge>();
	    
	    public static class DirectedEdge{
	        int from; 
	        int to; // edge
	        int weight; // weight;
	        
	        public DirectedEdge(int v, int w, int weight){
	            this.from = v;
	            this.to = w;
	            this.weight = weight;
	        }
	        
//	        public int from(){
//	            return v;
//	        }
//	        
//	        public int to(){
//	            return w;
//	        }
//	        
//	        public int weight(){
//	            return weight;
//	        }
	        
	
	    }
	    
	    public static class WeightedDiGraph{
	        int V; //vertex;
	        int E; //edges;
	        ArrayList<DirectedEdge>[] adj;
	        
	             
	        public WeightedDiGraph(int V){
	            this.V = V;
	            this.E = 0;
	            adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
	            for (int v = 0; v < V; v++) {
	                adj[v] = new ArrayList<DirectedEdge>();
	            }
	            
	        }
//	        public int V(){
//	            return this.V;
//	        }
//	        
//	        public int E(){
//	            return this.E;
//	        }
	        
	        
	        public void addEdge(int v, int w, int weight){
	            this.E++;
	            DirectedEdge item = new DirectedEdge(v, w, weight);
	            adj[v].add(item);
	            edgesList.add(item);
	        }
	        
//	        public String toString() {
//	            StringBuilder s = new StringBuilder();
//	            String NEWLINE = System.getProperty("line.separator");
//	            s.append(V + " vertices, " + E + " edges " + NEWLINE);
//	            for (int v = 0; v < V; v++) {
//	                s.append(String.format("%d: ", v));
//	                for (DirectedEdge e : adj[v]) {
//	                    s.append(e + "  ");
//	                }
//	                s.append(NEWLINE);
//	            }
//	            return s.toString();
//	        }
	        public Iterable<DirectedEdge> adj(int v) {
	            if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
	            return this.adj[v];
	        }
	        
	    }
	    
	   
	    
	    
	    public static int BellmanFord(WeightedDiGraph g){
	        Arrays.fill(dist, Long.MAX_VALUE);
	        Arrays.fill(prev, -1);
	        dist[0] = 0;
	        for(int i = 1; i < g.V - 1; i++){
	            for(DirectedEdge e : g.adj(i)){
	                
	                if(dist[e.to] > dist[e.from] + e.weight){
	                    dist[e.to] = dist[e.from] + e.weight;
	                    prev[e.to] = e.to;
	                }
	            }
	        }
	        
	        for(int i = 0; i < g.V; i++){
	            for(DirectedEdge e : g.adj(i)){
	                if(dist[e.to] > dist[e.from] + e.weight)
	                    return 1;
	            }
	        }
	        return 0;
	    }
	   
	    public static void main(String args[]){
	        int n, m, v, w, weight;
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        m = sc.nextInt();
	        dist = new long[n];
	        prev = new long[n];
	        WeightedDiGraph g = new WeightedDiGraph(n);
	        for(int i = 0; i < m; i++){
	            v = sc.nextInt();
	            w = sc.nextInt();
	            weight = sc.nextInt();
	            g.addEdge(v - 1, w - 1, weight);
	        }

	        System.out.println(BellmanFord(g));
	    }
	}

//4 4
//1 2 1
//4 1 2
//2 3 2
//3 1 -5