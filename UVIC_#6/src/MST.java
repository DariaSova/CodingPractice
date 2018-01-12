import java.util.*;

 
class MST
{
    // Number of vertices in the graph
    private static int V=0;
    private static int INVALID = Integer.MAX_VALUE;
    private static long FCOSTS=0;
    static Map<Edge, Integer> GR;
    static ArrayList<Edge> EDGES;
    static Map<Integer, Integer> parent;
    
    public static class Edge{
    	int from;
    	int to;
    	int weight;
 
    	
    	public Edge(int x, int y, int z){
    		this.from = x;
    		this.to= y;
    		this.weight = z;
    	}
    }
 

    static int minKey(int key[], Set<Integer> mstSet)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int mini=-1;
 
        for (int i = 0; i < V; i++){
            if (!mstSet.contains(i) && key[i] < min){
                min = key[i];
                mini = i;
            }
        }
 
        return mini;
    }
 

    static void printMST(Map<Integer, Integer> parent, int n, int graph[][]){
    	int count =0;
    	for (int i = 1; i < V; i++) {
    		if(parent.containsKey(i)&&parent.get(i) != INVALID){
    			FCOSTS+=graph[i][parent[i]];
    			count++;
    		}
    	
    	}
    	if(count<V-1){
    		System.out.println("Impossible");
    	}else{
    	
    	System.out.println(FCOSTS);
//    	System.out.println("edges " +count);
//    	int j =0;
    	for(int j=0; j<V; j++){
    		for (int i = 1; i < V && j<V; i++){
    			if(parent[i]==j) System.out.println(parent[i]+" "+ i+"    ");
                               //graph[i][parent[i]]);
    		}
    	}
    	}
    }
 

    static void prims(int graph[][]){
        parent = new HashMap<>();
 
        int key[] = new int [V];
 
//        boolean mstSet[] = new boolean[V];
        Set<Integer> mstSet = new HashSet<>();
 
        // Initialize all keys as INFINITE
//        for (int i = 0; i <V; i++){
//            key[i] = Integer.MAX_VALUE;
////            mstSet[i] = false;
//        }
 
        //first vertex
        key[0] = 0;     
//        parent[0] = -1;

        
        for (int cnt = 0; cnt < V-1; cnt++){

            int u = minKey(key, mstSet);
            if(u==-1){
            	System.out.println("Impossible");
            	break;

            }else{
            mstSet.add(u); //[u] = true;
 
            for (int v = 0; v < V; v++){
 
                if (graph[u][v]!=INVALID && !mstSet.contains(v) && graph[u][v] <  key[v]){
                    parent.put(v,u);
                    key[v] = graph[u][v];
                }
            }

        }
 
  
        }
        printMST(parent, V, graph);
    }
 
    public static void main (String[] args){
    	Scanner sc = new Scanner(System.in);
    	int nodes = sc.nextInt();
    	
    	int edges = sc.nextInt();
    	while(nodes!=0 || edges !=0){
    		V=nodes;
    		FCOSTS=0;
    	if(nodes<=0) {
    		System.out.println("Impossible");
    	}else if(edges<=0) {
    		System.out.println("Impossible");
//    		System.exit(0);
    		
    	}else{
    	
    		int[][] graph = new int[nodes][nodes];
    	
    	//remove?
    		for(int i=0; i<nodes;i++){
    			for(int j=0; j<nodes; j++){
    				graph[i][j] = INVALID; //-1;
    			}
    		}
    	
    	for(int i=0; i<edges; i++){
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int weight = sc.nextInt();
    		
    		graph[a][b] = weight;
    		graph[b][a] = weight;
    	}
    	
        	prims(graph);
        	
    		}
    	nodes = sc.nextInt();
    	edges = sc.nextInt();
    	}
    }
}

/*
5 4
0 1 6
1 2 1
3 4 5
1 2 4
*/