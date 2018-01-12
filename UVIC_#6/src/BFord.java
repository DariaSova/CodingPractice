import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class BFord {
	
    private static int INFINITY = 10000000;
    static Map<Integer, HashSet<Integer>> GR;

    static class NegativeWeightCycleException extends RuntimeException {
    }
    
    static Map<Integer,Integer> getShortestPath(Map<String, Integer> graphEdges, int sourceVertex) {

        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer,Integer> parent = new HashMap<>();

        //set distance of every vertex to be infinity initially
        for(Integer v : GR.keySet()) {
            distance.put(v, INFINITY);
            parent.put(v, null);
        }

        //set distance of source vertex to be 0
        distance.put(sourceVertex, 0);

        int V = GR.size();

        //relax edges repeatedly V - 1 times
        for (int i = 0; i < V - 1 ; i++) {
            for (String edgeStr : graphEdges.keySet()) {
            	String[] edges = edgeStr.split("-");
                int u = Integer.parseInt(edges[0]);
                int v = Integer.parseInt(edges[1]);
                //relax the edge
                //if we get better distance to v via u then use this distance
                //and set u as parent of v.
                if (distance.get(u) + graphEdges.get(edgeStr) < distance.get(v)) {
                    distance.put(v, distance.get(u) + graphEdges.get(edgeStr));
                    parent.put(v, u);
                }
            }
        }

        //relax all edges again. If we still get lesser distance it means
        //there is negative weight cycle in the graph. Throw exception in that
        //case
        for (String edgeStr : graphEdges.keySet()) {
        	String[] edges = edgeStr.split("-");
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);
            if (distance.get(u) + graphEdges.get(edgeStr) < distance.get(v)) {
                throw new NegativeWeightCycleException();
            }
        }
        return distance;
    }

    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	int nodes = sc.nextInt();
    	int lines = sc.nextInt();
    	GR = new HashMap<>();
    	for(int i=0; i<nodes; i++){
    		GR.put(i, new HashSet<>());
    	}
    	
    	Map<String, Integer> graphEdges = new HashMap<>();
    	//read edges 6 for now
    	for(int i=0; i<lines; i++){
    		int v1 = sc.nextInt();
    		int v2 = sc.nextInt();
    		int weight = sc.nextInt();
    		graphEdges.put(v1+"-"+v2, weight);
    	}
        
       
 
//        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
    	int start =0;
        Map<Integer,Integer> distance = getShortestPath(graphEdges, start);
        System.out.println(distance);
    }

}