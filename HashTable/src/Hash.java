import java.util.*;

public class Hash {
	public static int ARRAY_SIZE = 31;
	
	public static Node hashArray[] = new Node[ARRAY_SIZE];
	
	
	public static void initHash() {
		//Arrays.fill(hashArray, -1);
		for(int i=0; i<hashArray.length; i++){
			hashArray[i] = new Node();
		}
	}
	
	public static int getHashKey(int value) {
		int key = value % ARRAY_SIZE;
		return key;
	}
	
	public static void insertIntoHash(int values[]){
		for(int i =0; i< values.length; i++)
		{
			int index = getHashKey(values[i]);
			if(hashArray[index].value ==-1)
				hashArray[index].value = values[i];
			else { //collision
				System.out.println("Collision! value: " + values[i] + "index" + index);
				Node current = hashArray[index];
				while(current.next!=null && current.next.value!=-1)
					current= current.next;
				Node newN = new Node();
				newN.value = values[i];
				current.next = newN;
					
			}
		}
	}
	
	public static boolean findValue(int value){
		int index = getHashKey(value);
		if(hashArray[index].value==-1)
			return false;
		if(hashArray[index].value==value) {
			System.out.println("Found " +value+" at index: "+index);
			return true;
		}
		else { //linkedlist case
			Node current = hashArray[index];
			while(current.next!=null){
				if(current.next.value == value){
					System.out.println("Found " +value+" at index: "+index);
					return true;
				}
				current = current.next;
					
			}
		}
			return false;
	}

	public static void main(String[] args) {
		//for testing
		int [] valuesArray = { 10, 20, 4, 6, 8, 12, 123};
		
		initHash();
		insertIntoHash(valuesArray);
		
		for(int i=0; i<ARRAY_SIZE; i++)
		{
			System.out.println("Index: "+i+"value: "+hashArray[i].value+"\t");
		}
		
		findValue(8);
		findValue(123);
	}
}
