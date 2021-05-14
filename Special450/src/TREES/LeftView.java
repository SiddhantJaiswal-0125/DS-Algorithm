package TREES;

import java.util.*;

public class LeftView
{
    public static void main(String[] args) {
//        BinaryTree bt = new BinaryTree();
        Node root = newNode(1);
        root.left = newNode(3);
        root.right = newNode(7);
        root.left.left = newNode(6);
        root.left.right = newNode(5);
        root.left.right.left = newNode(10);
        root.right.left = newNode(4);
        root.right.right = newNode(13);
        root.right.left.left = newNode(17);
        root.right.left.right = newNode(15);


       ArrayList<Integer> ans = leftView(root);
        System.out.println(ans);
    }
    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }
    static class Node {
        int data;
     Node left, right;
    }
    static int max = 0;
      static ArrayList<Integer> leftView(Node root) {
          ArrayList<Integer> adj =  new ArrayList<>();
          System.out.println("HERE");
          if(root==null) {
//              System.out.println("ROOT IS NULL");
              return adj;
          }
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
//            System.out.println("SIZE "+size);

//            q.remove();

            for(int i =0;i<size;i++)
            {
                root = q.peek();
                if(i==0)
                    adj.add(root.data);

                q.remove();
                if(root.left!=null)
                    q.add(root.left);
                if(root.right!=null)
                    q.add(root.right);

            }



        }
        return adj;
    }

}
