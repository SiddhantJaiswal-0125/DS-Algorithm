package Visa;
import  java.util.*;
class Node {
    public int data;
    public Node next;
    public Node child;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.child = null;
    }
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.child = null;
    }
    Node(int data, Node next, Node child)
    {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}
 class Solution {
    public static Node flattenLinkedList(Node head) {
        //Write your code here

        PriorityQueue<Node> minPq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2)
            {
                return n1.data - n2.data;

            }
        });

        Node runner = head;

        while(runner != null)
        {
            minPq.add(runner);
            runner = runner.next;
        }

        Node ans = new Node();
        Node temp = ans;
        while(minPq.size() > 0)
        {
            Node out = minPq.poll();
            temp.next = new Node(out.data);
            temp = temp.next;


            if(out.child != null)
                minPq.add(out.child);


        }

        return ans.next;



    }
}