import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class BellmanFordShortestPath {
	
	static class Graph<T>{

	    private List<Edge<T>> allEdges;
	    private Map<Long,Vertex<T>> allVertex;

	    
	    public Graph(){
	        allEdges = new ArrayList<Edge<T>>();
	        allVertex = new HashMap<Long,Vertex<T>>();
	    }
	    
	    public void addEdge(long id1, long id2){
	        addEdge(id1,id2,0);
	    }
	    

	    public void addVertex(Vertex<T> vertex){
	        if(allVertex.containsKey(vertex.id)){
	            return;
	        }
	        allVertex.put(vertex.id, vertex);
	        for(Edge<T> edge : vertex.edges){
	            allEdges.add(edge);
	        }
	    }
	    
	    public Vertex<T> addSingleVertex(long id){
	        if(allVertex.containsKey(id)){
	            return allVertex.get(id);
	        }
	        Vertex<T> v = new Vertex<T>(id);
	        allVertex.put(id, v);
	        return v;
	    }
	    
	    public Vertex<T> getVertex(long id){
	        return allVertex.get(id);
	    }
	    public void addEdge(Vertex id1, Vertex id2, int weight){
	    	
	    }
//	    public void addEdge(long id1,long id2, int weight){
//	        Vertex<T> vertex1 = null;
//	        if(allVertex.containsKey(id1)){
//	            vertex1 = allVertex.get(id1);
//	        }else{
//	            vertex1 = new Vertex<T>(id1);
//	            allVertex.put(id1, vertex1);
//	        }
//	        Vertex<T> vertex2 = null;
//	        if(allVertex.containsKey(id2)){
//	            vertex2 = allVertex.get(id2);
//	        }else{
//	            vertex2 = new Vertex<T>(id2);
//	            allVertex.put(id2, vertex2);
//	        }
//
//	        Edge<T> edge = new Edge<T>(vertex1,vertex2,weight);
//	        allEdges.add(edge);
//	        vertex1.addAdjacentVertex(edge, vertex2);
//
//
//	    }
	    
	    public List<Edge<T>> getAllEdges(){
	        return allEdges;
	    }
	    
	    public Collection<Vertex<T>> getAllVertex(){
	        return allVertex.values();
	    }


	}


	static class Vertex<T> {
	    long id;
	     T data;
	     List<Edge<T>> edges = new ArrayList<>();
	     List<Vertex<T>> adjacentVertex = new ArrayList<>();
	    
	    Vertex(long id){
	        this.id = id;
	    }
	    
	    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
	        edges.add(e);
	        adjacentVertex.add(v);
	    }
	    
	    public String toString(){
	        return String.valueOf(id);
	    }
	   
	}

	static class Edge<T>{
	    Vertex<T> vertex1;
	    Vertex<T> vertex2;
	    int weight;
	    
	    Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight){
	        this.vertex1 = vertex1;
	        this.vertex2 = vertex2;
	        this.weight = weight;
	    }

	}


    private static int INFINITY = 10000000;

    class NegativeWeightCycleException extends RuntimeException {
    }
    
    public Map<Vertex<Integer>, Integer> getShortestPath(Graph<Integer> graph,
            Vertex<Integer> sourceVertex) {

        Map<Vertex<Integer>, Integer> distance = new HashMap<>();
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();

        //set distance of every vertex to be infinity initially
        for(Vertex<Integer> v : graph.getAllVertex()) {
            distance.put(v, INFINITY);
            parent.put(v, null);
        }

        //set distance of source vertex to be 0
        distance.put(sourceVertex, 0);

        int V = graph.getAllVertex().size();

        //relax edges repeatedly V - 1 times
        for (int i = 0; i < V - 1 ; i++) {
            for (Edge<Integer> edge : graph.getAllEdges()) {
                Vertex<Integer> u = edge.vertex1;
                Vertex<Integer> v = edge.vertex2;
                //relax the edge
                //if we get better distance to v via u then use this distance
                //and set u as parent of v.
                if (distance.get(u) + edge.weight < distance.get(v)) {
                    distance.put(v, distance.get(u) + edge.weight);
                    parent.put(v, u);
                }
            }
        }

        //relax all edges again. If we still get lesser distance it means
        //there is negative weight cycle in the graph. Throw exception in that
        //case
        for (Edge<Integer> edge : graph.getAllEdges()) {
            Vertex<Integer> u = edge.vertex1;
            Vertex<Integer> v = edge.vertex2;
            if (distance.get(u) + edge.weight < distance.get(v)) {
                throw new NegativeWeightCycleException();
            }
        }
        return distance;
    }

    public static void main(String args[]){
        
        Graph<Integer> graph = new Graph<Integer>();
        Vertex<Integer> v1;
        Vertex<Integer> v2;
        if(graph.allVertex.get(0)==null) v1 = new Vertex<>(0);
        else v1 = graph.allVertex.get(0);
        if(graph.allVertex.get(3)==null) v2 = new Vertex<>(3);
        else v2 = graph.allVertex.get(3);
        graph.addEdge(v1, v2, 8);
        
//        graph.addEdge(0, 1, 4);
//        graph.addEdge(0, 2, 5);
//        graph.addEdge(1, 2, -3);
//        graph.addEdge(2, 4, 4);
//        graph.addEdge(3, 4, 2);
//        graph.addEdge(4, 3, 1);

        BellmanFordShortestPath shortestPath = new BellmanFordShortestPath();
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
        Map<Vertex<Integer>,Integer> distance = shortestPath.getShortestPath(graph, startVertex);
        System.out.println(distance);
    }

}