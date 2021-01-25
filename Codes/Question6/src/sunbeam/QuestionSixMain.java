//For a singly linked list of integers perform following operations:
//a. find middle node of list
//b. count number of integers matching given criteria -- pass Predicate<> object.
//Java class SinglyList {
//public int countMatching(Predicate<integers> pred) 
//{ Node trav = head;
//int count = 0; 
//while(trav != null) 
//{ if(pred.test(trav.data)) count++; 
//trav = trav.next; } } return count; } 
//class Main() { 
//public static void main(String[] args) 
//{ // ... int cnt = list.countMatching(i -> i % 2 == 0); 
//System.out.println("Count: " + cnt); // ... } } 
//c. reverse the linked list using recursion
//d. add difference of two consecutive nodes before them.
//input: 4 -> 7 -> 9 -> 1 -> 2 -> 6 -> 5
//output: 3 -> 4 -> 7 -> 8 -> 9 -> 1 -> 4 -> 2 -> 6 -> 5
//3 = | 4 - 7 |
//8 = | 9 - 1 |
//4 = | 2 - 6 |

package sunbeam;

import java.util.function.Predicate;

class SinglyList {
	static class Node {
		private int data;
		private Node next;
		public Node() {
			this.data = 0;
			this.next = null;
		}
		public Node(int val) {
			this.data = val;
			this.next = null;
		}
	}
	
	private Node head;
	public SinglyList() {
		head = null;
	}
	public void addLast(int val) {
		Node newNode = new Node(val);
		if(head == null)
			head = newNode;
		else {
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			trav.next = newNode;
		}
	}
	public void display() {
		System.out.print("List: ");
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + " -> ");
			trav = trav.next;
		}
		System.out.println("");
	}
	public void reverse() {
		// consider current list as old and new list as empty.
		Node oldhead = head;
		head = null;
		while(oldhead != null) {
			// delete first (temp) from old list
			Node temp = oldhead;
			oldhead = oldhead.next;
			// add first (temp) to new list
			temp.next = head;
			head = temp;
		} // repeat until old list is finished
	}
	
	private Node recReverse(Node h) {
		if(h.next == null) {
			head = h;
			return h;
		}
		Node t = recReverse(h.next);
		t.next = h;
		h.next = null;
		return h;
	}
	
	public void recReverse() {
		if(head != null)
			recReverse(head);
	}
	
	public int findMid() {
		Node fast = head, slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
	
	
	public void diffDisplay() {
		Node trav=head,temp=null,diff=null;
		while(trav.next!=null)
		{
			diff= new Node(Math.abs(trav.data - trav.next.data));
			diff.next=trav;
		if(trav==head)
		{
			temp=trav.next;
			trav=trav.next.next;
			head=diff;
		}
		else {
			temp.next=diff;
			temp=trav.next;
			trav=trav.next.next;	
		}
		}
	}
	
	public int conntMatching(Predicate<Integer> obj) {
		Node trav = head;
		int count = 0;
		while (trav != null) {
			if (obj.test(trav.data))
				count++;
			trav = trav.next;
		}
		return count;
	}
	
	
}
public class QuestionSixMain {

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.addLast(4);
		list.addLast(7);
		list.addLast(9);
		list.addLast(1);
		list.addLast(2);
		list.addLast(6);
		list.addLast(5);
		list.display();
		
		//list.recReverse();
		//list.display();
		
		//System.out.println("Middle: " + list.findMid());
		
		//list.diffDisplay();
		//list.display();
		
		System.out.println("Count : " + list.conntMatching(i -> i % 2 == 0));

	}

}
