package TREES;

import java.util.Scanner;

public class SumTree
{
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
    static  int get(Node root)
    {
        if(root==null)
            return  0;
        if(root.left==null && root.right==null)
            return  root.data;



        return root.data+get(root.left)+ get(root.right);
    }
    public static void main(String[] args) {
        Node root = newNode(10);
        root.left = newNode(20);
        root.right = newNode(30);
        root.left.left = newNode(10);
        root.left.right = newNode(10);
//        Node root = newNode(1);
//        root.left = newNode(3);
//        root.right = newNode(7);
//        root.left.left = newNode(6);
//        root.left.right = newNode(5);
//        root.left.right.left = newNode(10);
//        root.right.left = newNode(4);
//        root.right.right = newNode(13);
//        root.right.left.left = newNode(17);
//        root.right.left.right = newNode(15);
        System.out.println(isSumTree(root));

    }
   static  boolean isSumTree(Node root)
    {
        if(root==null)
            return  true;
        if(root.left==null && root.right==null)
            return  true;
        int sum = get(root);
        sum-=root.data;
        return  root.data==sum && isSumTree(root.left) && isSumTree(root.right);

        // Your code here
    }
}
