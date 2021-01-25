package sunbeam;

import java.util.Scanner;


class DoublyLinkedList{
	class Node {
		private Person data;
		private Node next;
		private Node prev;

		public Node() {
		}

		public Node(Person p) {
			this.data = p;
			this.next = null;
			this.prev = null;
		}
	}

	private Node head;

	public DoublyLinkedList() {
		this.head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void displayForward() {
		System.out.println("Forward List : ");
		if (isEmpty())
			return;
		Node trav = this.head;
		while (trav != null) {
			System.out.println(trav.data.toString());
			trav = trav.next;
		}

	}

	public void displayReverse() {
		System.out.println("Reverse List : ");
		if (isEmpty())
			return;

		Node trav = this.head;
		while (trav.next != null)
			trav = trav.next;

		while (trav != null) {
			System.out.println(trav.data.toString());
			trav = trav.prev;
		}

	}

	public void addFirst(Person p) {
		Node newNode = new Node(p);
		newNode.next = head;
		head = newNode;
	}

	public void addLast(Person p) {
		Node newNode = new Node(p);
		if (isEmpty())
			head = newNode;
		else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			newNode.prev = trav;
			trav.next = newNode;
		}
	}

	public void addAtPos(Person p, int pos) {
		if (isEmpty() || pos <= 1)
			addFirst(p);

		Node newNode = new Node(p);
		Node trav = head;
		for (int i = 1; i < pos - 1; i++) {
			if (trav.next == null)
				break;
			trav = trav.next;
		}
		newNode.next = trav.next;
		newNode.prev = trav;
		if (trav.next != null)
			trav.next.prev = newNode;
		trav.next = newNode;
	}

	public void delFirst() {
		if (isEmpty())
			throw new RuntimeException("List is Empty.");
		head = head.next;
		if (head != null)
			head.prev = null;
	}

	public void delLast() {
		if (isEmpty())
			throw new RuntimeException("List is Empty.");
		if (head.next == null)
			head = null;
		else {
			Node trav = head;
			while (trav.next != null)
				trav = trav.next;
			trav.prev.next = null;
		}
	}

	public void delAtPos(int pos) {
		if (pos == 1)
			delFirst();
		if (head == null || pos < 1)
			throw new RuntimeException(pos < 1 ? "Invalid Entry" : "List is empty.");

		Node trav = head;
		for (int i = 1; i < pos; i++) {
			if (trav == null)
				throw new RuntimeException("Invalid Entry");
			trav = trav.next;
		}
		trav.prev.next = trav.next;
		if (trav.next != null)
			trav.next.prev = trav.prev;
	}

}

public class DoublyList {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice, pos;
		DoublyLinkedList list = new DoublyLinkedList();

		while ((choice = DoublyList.menuList()) != 0) {
			switch (choice) {
			case 1:
				list.displayForward();
				list.displayReverse();
				break;
			case 2:
				
				list.addFirst(PersonUtil.accept());
				break;
			case 3:
				list.addLast(PersonUtil.accept());
				break;
			case 4:
				
				System.out.print("Enter Position : ");
				pos = sc.nextInt();
				list.addAtPos(PersonUtil.accept(), pos);
				break;
			case 5:
				list.delFirst();
				break;
			case 6:
				list.delLast();
				break;
			case 7:
				System.out.print("Enter Position : ");
				pos = sc.nextInt();
				list.delAtPos(pos);
				break;
			case 8:
				break;
			}
		}
		sc.close();
	}

	private static int menuList() {
		System.out.println("0. Exit");
		System.out.println("1. Display List ");
		System.out.println("2. Add Person at First Position");
		System.out.println("3. Add Person at Last Position");
		System.out.println("4. Add Person at any Position");
		System.out.println("5. Del Person at First Position");
		System.out.println("6. Del Person at Last Position");
		System.out.println("7. Del Person at any Position");
		System.out.print("Enter Choice : ");
		return sc.nextInt();
	}

}
