package LinkedList;

import java.util.HashSet;
import java.util.Scanner;
 class Node
{
    int data ;
    Node next;
    Node( int data)
    {
        this.data = data;
        next = null;

    }
}
public class RemoveDuplicates
{


   static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         head = new Node(5);
        head.next = new Node(6);
        head.next.next = new Node(7);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(8);

        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(9);
      RemoveDuplicates r = new RemoveDuplicates();


        r.print();
       r.print();
//       Node q = r.removeDuplicates(head);
//       r.print(q);


    }


    Node removelast(Node head)
    {
        Node res = head;
        if(res==null || res.next==null)
            return null;
//        res = res.next;
        while(res.next.next!=null)
            res = res.next;

        return  res;

    }
     void print()
    {
        while(head!=null)
        {
            System.out.print(head.data+ "   ");
            head = head.next;
        }
        System.out.println();
    }



    Node removeDuplicates(Node head)
    {
        if(head ==null)
            return null;
       Node res = new Node(head.data);
        HashSet<Integer> hs = new HashSet<>();
        hs.add(head.data);
        head = head.next;

        while(head!=null)
        {
            if(hs.contains(head.data)==false)
            {

                add2(head.data);
                hs.add(head.data);
            }

            head = head.next;
        }
        return res;
    }


    void add2(int data)
    {
        Node res  = new Node(5);
        Node q = new Node(data);
        if (res == null)
        {
            res = new Node(data);
            return;
        }


        q.next = null;
        Node last = res;
        while (last.next != null)
            last = last.next;

        last.next = q;
        return;


    }

}
