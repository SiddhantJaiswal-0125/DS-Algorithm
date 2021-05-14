package TREES;

import java.util.ArrayList;
import java.util.HashMap;

public class DiagonalTraversal
{
    static class Node {
        int data;
        Node left, right;
    }
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

//        ArrayList<Integer> ans = diagonal(root);
//        System.out.println(ans);





    }
    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }
//    static class Node {
//        int data;
//      Node left, right;
//    }
    public ArrayList<Integer> diagonal(Node root)
    {
        //add your code here.
        int finallevel = 0;

        ArrayList<Integer>  ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer> > hs = new HashMap<>();

        findmap(root, 0, hs, finallevel);
//        System.out.println("MAP IS");
//        System.out.println(hs);

        for(int i =0;i<=finallevel;i++)
        {
            ArrayList <Integer> aj = hs.get(i);
            for(Integer n : aj)
                ans.add(n);


        }



        return ans ;
    }
    public   void findmap(Node root, int level,
                        HashMap<Integer, ArrayList<Integer> > hs,
                        int finallevel)
    {
        if(root==null)
            return;
        if(level>finallevel)
            finallevel = level;

        ArrayList <Integer> as  = new ArrayList<>();
        if(level<0)
            level = 0;

        if(hs.containsKey(level))
        {
            as = hs.get(level);

        }
        as.add(root.data);
        hs.put(level, as);
        findmap(root.left, level+1, hs, finallevel);
        findmap(root.right, level, hs, finallevel);




    }

}
