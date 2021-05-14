package TREES;

import java.util.Scanner;

public class ContructBTfromString
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String s = sc.next();
//         Node root = getTree(s);
//         preorder(root);


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
    static void preorder(Node root)
    {
        if(root==null)
            return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);

    }
//    static Node getTree(String )
}
