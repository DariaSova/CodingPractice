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
		
	}
}
