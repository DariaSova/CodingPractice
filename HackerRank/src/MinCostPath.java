import java.util.*;



public class MinCostPath {
	//sls
	static int minPath(int[][] graph, int source, int destination){
		int len = graph.length;
		int[] distance = new int[len];
		int[] path = new int[len];
		boolean[] visited = new boolean[len];
		
		for(int i=0; i<len; i++){
			distance[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		//the source
		distance[source] = 0;
		visited[source] = true;
		int minVertex =source;
		
		for(int i=0; i<len; i++){
		
			
			for(int j=0; j<len; j++){
				if(graph[minVertex][j]!=0&&distance[minVertex]!=Integer.MAX_VALUE){
//					distance[j] = Math.min(distance[j], distance[minVertex]+graph[minVertex][j]);
					if(distance[j] > distance[minVertex]+graph[minVertex][j]){
						distance[j] = distance[minVertex]+graph[minVertex][j];
						path[j] = minVertex;
					}
				}
			}
			minVertex = getMin(distance, visited);
			//visited[minVertex] = true;
		
		}
		for(int p: path)
			System.out.print(p);
		return distance[destination];
	}
	
	static int getMin(int[] distance, boolean[] visited){
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i=0; i<distance.length; i++){
			if(!visited[i]&&distance[i]< min || index==-1&&!visited[i]){
				index = i;
				min = distance[index];
			}
		}
		if(index!=-1)
			visited[index] = true;
		return index;
	}
	
	
	public static void main(String[] args){
		int[][] array = {{0, 7, 4, 15 },
						{0, 0, 0, 5  },
						{0, 2, 0, 0 },
						{0, 0, 0, 0 }};
		System.out.println(minPath(array, 0, 3));
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
         //  System.out.println(minPath(graph, 3));
	}
}
