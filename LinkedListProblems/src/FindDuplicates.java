import java.util.*;

public class FindDuplicates {
	public static class Node{
		public int x;
		public Node next;
		
		public Node(int val){
			x = val;
			next = null;
		}
	}
	
	public static class LinkedList {
		public Node head;
		
		public LinkedList() {
			head = null;
		}
		
		public void addNode(int n) {
			if(head == null){
				head = new Node(n);
			}else{
				while(head.next!=null)
					head=head.next;
				head.next = new Node(n);
			}		
		}
	}

	static Node removeDuplicates(Node head){
		HashSet<Integer> hs = new HashSet<Integer>();
		
		Node prev = head;
		Node curr = head;
		while(curr!=null){
			
			if(hs.contains(curr.x)){
				prev.next = curr.next;
				curr = curr.next;
			}else{
				hs.add(curr.x);
				prev = curr;
				curr=curr.next;
			}
		}
		return head;
	}
	
	static Node rmeoveMiddle(Node head){
		Node p1 = head;
		Node p2 = head;
		Node prev = head;
		Node res = prev;
		
		while(p2.next!=null&& p2.next.next!=null){
			prev = p1;
			p1 = p1.next;
			p2 = p2.next.next;
		}
		prev.next = p1.next;
		
		return res;
	}
	
	static Node getKthElement(Node head, int k){
		Node p1=head;
		
		while(p1.next!=null&&k>1){
			p1=p1.next;
			k--;
		}
		
		Node p2 = p1;
		p1 = head;
		
		while(p2.next!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	static Node partition(Node node, int x){
		Node h = node;
		Node t = node;
		
		while(node!=null){
			Node next = node.next;
			if(node.x< x){
				node.next = h;
				h = node;
			}else{
				t.next = node;
				t = node;
			}
			node = next;
		}
		t.next = null;
		return h;
	}
	
	static Node findLoop(Node head){
		Node p1 = head;
		Node p2 = head;
		
		while(p2 != null && p2.next != null){
			p1  = p1.next;
			p2 = p2.next.next;
			
			if(p1==p2)
				break;
		}
		
		if(p1==p2){
			p1 = head;
			while(p1!=p2){
				p1=p1.next;
				p2 = p2.next;
			}
			return p1;
		}

		return null;
	}
	
	static Node findIntersection(Node l1, Node l2){
		int len1 =0;
		int len2 =0;
		
		Node h1 = l1;
		Node h2 = l2;
		
		while(l1.next != null){
			len1++;
			l1 = l1.next;
		}
		
		while(l2.next != null){
			len2++;
			l2 = l2.next;
		}
		
		if(l1 != l2)
			return null;
		
		if(len1!=len2){
			if(len1>len2){
				for(int i = 0; i< len1-len2; i++){
					h1 = h1.next;
				}
			}else{
				for(int i = 0; i< len2-len1; i++){
					h2 = h2.next;
				}
			}
				
		}
		
		while(h1!=h2){
			h1 = h1.next;
			h2 = h2.next;
		}
		
		return h1;
	}
	
	
	public static void main(String[] args){
		Node n = new Node(1);
		Node curr = n;
		for(int i=0; i<=5; i++){
			curr.next = new Node(i);
			curr=curr.next;
			curr.next = new Node(i);
			curr=curr.next;
		}
		Node loop = new Node(7);
		curr.next = loop;
		curr.next.next = new Node(3);
		curr.next.next.next = new Node(2);
		curr.next.next.next.next = loop;
		
		
		
		//Node res = removeDuplicates(n);
		//Node kth = getKthElement(res, 5);
		//System.out.println("Kth: " + kth.x);
//		while(res!=null){
//			System.out.println(res.x);
//			res = res.next;
//		}
		
//		Node res3 = rmeoveMiddle(res);
//		while(res3!=null){
//			System.out.println(res3.x);
//			res3 = res3.next;
//		}
		
		//Node res4 = partition(res, 3);
//		while(res4!=null){
//		System.out.println(res4.x);
//		res4 = res4.next;
//	}
		Node res5 = findLoop(n);
		System.out.println(res5.x);
		
//		LinkedList l1 = new LinkedList();
//		LinkedList l2 = new LinkedList();
//		l1.addNode(5);
//		l1.addNode(9);
		Node intersection = new Node(7);
		intersection.next = new Node(2);
		intersection.next.next = new Node(1);
		
		Node l1 = new Node(1);
		l1.next = new Node(5);
		l1.next.next = new Node(9);
		l1.next.next.next = intersection;
		
		Node l2 = new Node(4);
		l2.next = new Node(6);
		l2.next.next = intersection;
		
		System.out.println("INTERSECT AT: " + findIntersection(l2, l1).x);
		
	}
}
