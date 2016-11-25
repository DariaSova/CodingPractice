
public class BSTRange {
	
	public static class Node{
		int x;
		Node l;
		Node r;
		
		public Node(int val){
			x = val;
			l=null;
			r=null;
		}
	}
	
	public static int solution(Node root, int A, int B){
		int max =-1;
		if (root==null)
			return -1;

		int lh=0;
		int rh=0;
		boolean l=false;
		boolean r=false;
		if(root.x>=A){
			if(root.x<=B)
				lh = 1+solution(root.l, A, B);
			
			else
				lh = 0 + solution(root.l, A, B);
			l=true;
		}
		if(root.x<=B){
			if(root.x>=A)
				rh= 1+solution(root.r, A, B);
			else
				rh= 0+solution(root.r, A, B);
			r=true;
		}
		if(l)
			max = Math.max(lh,  max);
		if(r)
			max = Math.max(rh,  max);
		
		
		return max;
	}
	
	public static int count(Node root, int A, int B){
		int max =0;
		if (root==null)
			return 0;

		int lh=0;
		int rh=0;
		//boolean l=false;
		//boolean r=false;
		if(root.x<=B&&root.x>=A)
			max++;
		if(root.x>=A){
			//if(root.x<=B)
			//	max++;// = 1 + solution(root.l, A, B);
			//else
			lh =count(root.l, A, B);
			//l=true;
		}
		if(root.x<=B){
			//if(root.x>=A)
			//	rh= 1+solution(root.r, A, B);
			//else
			rh =count(root.r, A, B);
			//r=true;
		}
		//if(l)
			//max = Math.max(lh+rh,  max);
		//if(r)
//			max = Math.max(rh,  max);
		
		max= max+lh+rh;
		return max;
	}
	
	
	public static void main(String[] args){
		Node root = new Node(25);
		root.l = new Node(15);
		root.r = new Node(30);
		root.l.l = new Node(8);
		root.l.l.l = new Node(3);
		root.l.r = new Node(17);
		
		//System.out.println(solution(root, 1, 16));
		//System.out.println(solution(root, 1, 8));
		//System.out.println(solution(root, 1, 17));
		//System.out.println(solution(root, 3, 25));
		//System.out.println(solution(root, 25, 30));
		/*System.out.println(solution(root, 2, 16));
		System.out.println(solution(root, 3, 15));
		System.out.println(solution(root, 3, 25));
		System.out.println(solution(root, 3, 8));
		System.out.println(solution(root, 2, 2));
		System.out.println(solution(root, 15, 17));
		System.out.println(solution(root, 25, 25));
		System.out.println(solution(root, 8, 8));*/
		
		
		System.out.println(count(root, 3, 8));
		System.out.println(count(root, 2, 3));
		System.out.println(count(root, 15, 17));
		System.out.println(count(root, 25, 25));
		System.out.println(count(root, 2, 20));
		System.out.println(count(root, 2, 50));
		System.out.println(count(root, 15, 15));
		System.out.println(count(root, 1, 2));
		
	}

}
