import java.util.*;
/*Shortest Path in Binary Maze*/

class Point{
	int x;
	int y;
	int steps;
	Point(int xin, int yin, int d){
		x = xin;
		y = yin;
		steps = d;
	}
}

public class MNPath {

	static Point getUnvisited(int r, int c, int[][] arr, boolean[][] visited, int d){
		if(c+1<arr[0].length&&arr[r][c+1]==1&&!visited[r][c+1]){
			Point p = new Point(r, c+1, d+1);
			return p;
		}else if(r+1<arr.length&&arr[r+1][c]==1&&!visited[r+1][c]){
			Point p = new Point(r+1, c, d+1);
			return p;
		}else if(r-1>=0&&arr[r-1][c]==1&&!visited[r-1][c]){
			Point p = new Point(r-1, c, d+1);
			return p;
		}
			
		return null;
	}
	
	static int minPath(int[][] arr){
		int rows = arr.length;
		int columns = arr[0].length;
		boolean[][] visited = new boolean[rows][columns];
		
		if(arr[0][0]==0) return 0;
		
		Queue<Point> q = new LinkedList<Point>();
		int r=0;
		int c=0;
		//int costs = 0;
		
		q.add(new Point(r,c,1));
		visited[r][c] = true;
		
		while(!q.isEmpty()){
			Point curr = q.remove();
			//costs++;
			r = curr.x;
			c = curr.y;
			Point child = getUnvisited(r, c, arr, visited, curr.steps);
			while(child!=null){
				q.add(child);
				visited[child.x][child.y] = true;
				if(child.x==rows-1&&child.y==columns-1)
					return child.steps;
				child = getUnvisited(r, c, arr, visited, curr.steps);
			}
		}
		return 0;
		
	}
	
	/*number of all possible paths in binary Maze*/
	static int numberOfPaths(int[][] a) {
	      int r = a.length;
	      int c = a[0].length;
	      int[][] res = new int[r][c];
	        
	      int i=0;
	      while(i<c&&a[0][i]==1){   
	        a[0][i++]=1;
	      }
	      for(i=i; i<c; i++){ 
	        a[0][i] = 0;
	      }
	      i=0;
	      while(i<r&&a[i][0]==1)   
	        a[i++][0]=1;
	      for(i=i; i<r; i++){ 
	        a[i][0] = 0;
	      }
	      
	      for(int k=1; k<r; k++){
	          for(int j=1; j<c; j++){
	              if(a[k][j]==1){
	                  res[k][j] = res[k-1][j] + res[k][j-1];
	              }else{
	                  res[k][j] = 0;
	              }
	          }
	      }
	      
	        return res[r-1][c-1];

	    }

	
	public static void main(String[] args){
		int[][] ar = {{1,1},{0,1}};
		int[][] array = {{1, 0, 1, 1, 1, },
                		 {1, 0, 1, 1, 1  },
                		 {1, 1, 1, 0, 1}};
		//System.out.println("RES: "+ numberOfPaths(ar));
		System.out.println("Min PATH costs: "+ minPath(array));
	}
}
