//Implement doubly circular linked list of any type, with following operations:
//a. addFirst()
//b. addLast()
//c. insertAtPos()
//d. delFirst()
//e. delLast()
//f. delAtPos()
//g. displayForward()
//h. displayReverse()

package sunbeam;

import java.util.Scanner;

class DoublyCircularList{
		static class Node{
			private int data;
			private Node next;
			private Node prev;
			
			public Node() {
				this.data = 0;
				this.next = null;
				this.prev = null;
			}
			public Node(int val) {
				data = val;
				next = null;
				prev = null;
			}	
		}
			private Node head;
			public DoublyCircularList() {
				this.head = null;
			}
			
			public boolean isEmpty()
			{
				return head==null;
			}
			
			public void displayForward() {
				System.out.println("List: ");
				if(isEmpty())
					return;
				Node trav = head;
				do {
					System.out.println(trav.data);
					trav = trav.next;
				} while(trav != head);
			}
			
			public void displayReverse() {
				System.out.println("Reverse List: ");
				if(isEmpty())
					return;
				Node trav = head.prev;
				do {
					System.out.println(trav.data);
					trav=trav.prev;
				}while(trav!=head.prev);
			}
			
			public void addIfNull(int val,Node newNode)
			{
				newNode.next=newNode;
				newNode.prev=newNode;
				head=newNode;
			}
			public void addLast(int val)
			{
				Node newNode= new Node(val);
				if(isEmpty())
				{
					addIfNull(val,newNode);
					return;
				}
				Node tail=head.prev;
				newNode.next=head;
				newNode.prev=tail;
				head.prev=newNode;
				tail.next=newNode;
				
			}
			
			public void addFirst(int val) {
				Node newNode= new Node(val);
				if(isEmpty())
				{
					addIfNull(val,newNode);
					return;
				}
				Node tail=head.prev;
				newNode.next=head;
				newNode.prev=tail;
				head.prev=newNode;
				tail.next=newNode;
				head=newNode;
			}

			public void addAtPos(int val, int pos) {
				if(head == null || pos <= 1)
					addFirst(val);
				else {
					Node newNode = new Node(val);
					Node trav = head;
					for(int i=1; i < pos-1; i++) {
						if(trav.next == head)
							break;
						trav = trav.next;
					}
					newNode.next = trav.next;
					newNode.prev=trav;
					trav.next.prev=newNode;
					trav.next = newNode;
				}
			}

			public void delFirst() {
				if(isEmpty())
					throw new RuntimeException("List is Empty");
				if(head.next==head)
					head=null;
				//general case
				else
				{	
					head.next.prev=head.prev;
					head.prev.next=head.next;
					head=head.next;
				}	
			}

			public void delLast() {
				if(isEmpty())
					throw new RuntimeException("List is Empty");
				if(head.next==head)
					head=null;
				else {
				Node trav=head.prev;
				head.prev=trav.prev;
				trav.prev.next=head;
				}
			}
			
			public void delAtPos(int pos) {
				if(pos == 1) {
					delFirst();
					return;
				}
				if(head == null || pos < 1)
					throw new RuntimeException("List is empty or Invalid position.");
				Node trav = head;
				for(int i = 1; i < pos; i++) {
					if(trav.next == head)
						throw new RuntimeException("Invalid position.");
					trav = trav.next;
				}
				trav.prev.next = trav.next;
				trav.next.prev = trav.prev;
			}

			public void delAll() {
				head=head.next=head.prev=null;	
			}
					
}


public class DoublyCircularMain {
	public static void main(String[] args) {
		int choice, val, pos;
		DoublyCircularList list = new DoublyCircularList();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n0. Exit\n1. Add First\n2. Add Last\n3. Add At Pos\n4. Del First\n5. Del Last\n6. Del At Pos\n7. Display Forward\n7. Display Reverse\nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // Add First
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				list.addFirst(val);
				break;
				
			case 2: // Add Last
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				list.addLast(val);
				break;
				
			case 3: // Add At Pos
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				System.out.print("Enter element position: ");
				pos = sc.nextInt();
				list.addAtPos(val, pos);
				break;
				
			case 4: // Del First
				try {
					list.delFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}			
				break;
				
			case 5: // Del Last
				try {
					list.delLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 6: // Del At Pos
				System.out.print("Enter element position: ");
				pos = sc.nextInt();
				try {
					list.delAtPos(pos);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 7: // Display Forward
				list.displayForward();
				break;
				
			case 8: // Display Reverse
				list.displayReverse();
				break;
				
			}
		} while(choice!=0);
		sc.close();
	}

}
