import java.util.*;

public class Islands {

	static boolean isValid(int r, int c, boolean[][] visited){
		int rLen = visited.length;
		int cLen = visited[0].length;
		
		return (r>=0&&r<rLen&&c>=0&&c<cLen&&!visited[r][c]); 
	}
	
	static void DFS(int[][] in, boolean[][] visited, int r, int c){
		// Stack<Integer> s = new Stack();
		int [] rows = {-1, 1, 0, 0};
		int [] columns = {0, 0, -1, 1};  //do we need to go up?
		
		for(int k=0; k<4; k++){
			if(isValid(r+rows[k], c+columns[k], visited)&&in[r+rows[k]][c+columns[k]]==1){
				visited[r+rows[k]][c+columns[k]] = true;
				DFS(in, visited, r+rows[k], c+columns[k]);
			}
		}
		
	}
	
	
	static int islandsCount(int[][] in){
		int cnt=0;
		int row = in.length;
		int col = in[0].length;
		boolean[][] visited = new boolean[row][col];
		
		for(int i =0; i<row; i++){
			for(int j=0; j<col; j++){
				if(in[i][j]==1&&!visited[i][j]){
					//do DFS on it
					DFS(in, visited, i, j);
					cnt++;
				}
			}
		}
		
		
		return cnt;
	}
	
	static void checkSet(Set<String> s){
		if(s.size()==0)
			s.add("A");
		else
			s.add("B");
		if(s.size()==2)
			return;
		checkSet(s);
		
		
	}
	
	public static void main(String[] args){
		int[][] map = {{1, 0, 1, 0, 1, },
       		 		   {1, 0, 0, 1, 0  },
       		 		   {1, 1, 1, 0, 1}};
		int[][] map2 = {{1, 1, 1, 1},
		 		   {1, 1, 1, 1},
		 		   {1, 1, 1, 1}};
		int[][] map3 = {{0, 0, 0, 0},
		 		   {0, 0, 0, 0},
		 		   {0, 0, 0, 0}};
		System.out.println(islandsCount(map));
		System.out.println(islandsCount(map2));
		System.out.println(islandsCount(map3));
		
		Set<String> set = new HashSet<String>();
		checkSet(set);
		for(String word: set){
			System.out.println(word);
		}
	}
}
