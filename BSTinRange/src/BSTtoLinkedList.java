
public class BSTtoLinkedList {
	
	public static class Node {
		int val;
		Node l;
		Node r;
		
		public Node(int x){
			val=x;
			l=null;
			r=null;
		}
	}
	
	
	static Node traverseBST(Node root){
		
		Node current = root;
		Node newRoot;
		
		if(root==null)
			return null;
		
		current = root;
		while(current!=null){
			if(current.l!=null){
				Node mostRight = current.l;
				while(mostRight.r!=null && mostRight.r!=current)
					mostRight = mostRight.r;
				if(mostRight.r==null){
					mostRight.r = current;
					current = current.l;
				}else{ //a;ready traversed
					mostRight.r = null;
					System.out.println(current.val);
					newRoot = current;
					newRoot.l = newRoot;
					newRoot = newRoot.r;
					current=current.r;
				}
			}else{ //traverse right
				System.out.println(current.val);
				newRoot = current;
				newRoot.l = newRoot;
				newRoot = newRoot.r;
				current = current.r;
			}
		}	
		return null;
	}
	
	public static void main(String[] args){
		Node root = new Node(10);
		root.l = new Node(5);
		root.r= new Node(30);
		root.l.l = new Node(-2);
		root.l.l.r = new Node(2);
		root.l.l.r.l = new Node(-1);
		root.l.r = new Node(6);
		root.l.r.r = new Node(8);
		root.r.r= new Node(40);	
//		Node current;
		traverseBST(root);	
	}
}
