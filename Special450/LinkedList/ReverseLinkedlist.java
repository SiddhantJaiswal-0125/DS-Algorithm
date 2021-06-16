import java.util.*;

class Rev{

public static void main(String [] args)
{
	Scanner sc = new Scanner(System.in);
	Node head = new Node(10);
	head.next = new Node(20);
	head.next.next = new Node(30);
	head.next.next.next = new Node(40);
	head.next.next.next.next = new Node(50);
print(head);
reverse(head);

	

}

static void reverse(Node head)
{
Node p = head;
if(p==null)
return ;
reverse(p.next);
System.out.print(p.data+" --> ");




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
