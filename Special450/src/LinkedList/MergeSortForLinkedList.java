package LinkedList;

import java.util.Scanner;

public class MergeSortForLinkedList
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


    }
   static class Node
    {
        int data ;
            Node next;
        Node( int data)
        {
            this.data = data;
            next = null;

        }
    }

}
