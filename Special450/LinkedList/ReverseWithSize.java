import java.util.*;

class RevSize{

public static void main(String [] args)
{
	Scanner sc = new Scanner(System.in);
	Node head = new Node(1);
	head.next = new Node(2);
	head.next.next = new Node(2);
	head.next.next.next = new Node(4);
	head.next.next.next.next = new Node(5);
	head.next.next.next.next.next = new Node(6);
	head.next.next.next.next.next.next = new Node(7);
	head.next.next.next.next.next.next.next = new Node(8);

print(head);
head = Reverse(head);
System.out.println("changes");
print(head);

	

}


static Node revSize(Node head , int k )
{


}
public static  Node Reverse(Node root)
{
	if(root==null || root.next ==null)
		return root;
	Node newNode = null;
	while(root!=null)
	{
		Node  next = root.next;
		root.next = newNode;
		newNode = root;
		root = next;
		


	}
	return newNode;


}







static void print(Node head)
{
	Node p = head;
	while(p!=null)
	{

		System.out.println(p.data);
		p = p.next;
	}
}

}

class Node
{

int data ;
Node next;
Node(int data)
{
this.data = data;
next = null;
}


}
