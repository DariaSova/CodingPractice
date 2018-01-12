import java.util.*;


class Roads {

static int[] uf; 
static int[] sz;
static int GROUPSN;


static int find ( int x ) {
	int curr = x;
	while(uf[curr] != curr){
		curr = uf[curr];
	}
	
	//compression
	while(x!=curr){
		int next = uf[x];
		uf[x] = curr;
		x = next;
	}
	
	return x;
}

static void union (int x, int y) {
	int pX = find(x);
	int pY = find(y);
	
	if(pX!=pY){
		if(sz[pX]> sz[pY]){
			uf[pY] = pX;
			sz[pX] += sz[pY];
		}else{
			uf[pX] = pY;
			sz[pY] += sz[pX];
		}
		
		GROUPSN--;
	}
}

public static void main ( String[] args ) {

  Scanner sc = new Scanner( System.in );
  int testCases = sc.nextInt();
  for (int n=0; n<testCases; ++n) { 
	  int citiesN = sc.nextInt();
	  GROUPSN = citiesN;
	  int pairs = sc.nextInt();
	  
	  uf = new int[citiesN];
	  sz = new int[citiesN];
	  
	  for(int i=0; i<citiesN; i++) uf[i] = i;
	  Arrays.fill(sz, 1);
	  
	  for(int i=0; i< pairs; i++){
		  int a = sc.nextInt();
		  int b = sc.nextInt();
		  
		  union(a,b);
	  }
	  
	  System.out.println(GROUPSN-1);
     
     
  }
     
}

}