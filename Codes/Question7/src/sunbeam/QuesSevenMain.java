//7. Singly linked list of double stores coefficients of a 
//polynomial f(a) from power 0 (first element) to n (last element).
//	f(a) = -2a$3 + 5a - 3
//Then linked list will be: -3 -> 5 -> 0 -> -2
//Write a program to input coefficients from the user and build 
//the linked list. Then input the value of variable "a" and solve 
//the polynomial for the result.

package sunbeam;

import java.util.Scanner;

class SinglyList {
	static class Node {
		private double data;
		private Node next;
		public Node() {
			data = 0;
			next = null;
		}
		public Node(double val) {
			data = val;
			next = null;
		}
	}
	
	private Node head;
	
	public SinglyList() {
		head = null;
	}
	
	void addFirst() {
		Scanner sc =new Scanner(System.in);
		for(int i=3;i>=0;i--) {
		System.out.println("Enter coefficients for a$"+i);	
		Node newNode=new Node(sc.nextDouble());
		newNode.next=head;
		head=newNode;
	}
	}
	
	void display()
	{
		System.out.println("Cofficient of a$0 to a$n:");
		Node trav=head;
		while(trav!=null)
		{
			System.out.print((int)trav.data + "->");			
			trav=trav.next;
		}
		System.out.println(" ");
	}

	public void calculate() {
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter value of a : ");
		double a=sc.nextDouble();
		double sum=0;
		Node temp=head;
		for(double i=0;i<4;i++)
		{
			sum=sum + temp.data * Math.pow(a,i );
			temp=temp.next;
		}
		System.out.println("Final result : " + sum);
	}

}
public class QuesSevenMain {

	public static void main(String[] args) {
		SinglyList list= new SinglyList();
		int val,i=0;
		list.addFirst();
		list.display();
		System.out.println();
		list.calculate();
	}

}
