package TREES;

public class TransformToSumTree
{

    public static void toSumTree(Node root){

        //add code here.


        Node ans = new Node();

             ans =   solve(root);
//             root = new Node();
//             root = ans;
//        preorder(ans);
//        root = ans;

    }

    static Node solve(Node root)
    {
        if(root==null || root.left==null && root.right==null)
            return  new Node(0) ;
//        if()
//            return new Node(0) ;



        int data = get(root);
        root.data = data;

        Node res = new Node(data);
        Node temp1  = null, temp2 = null;
        if(root.left!=null)
        temp1 = solve(root.left);
        if(root.right!=null)
       temp2 = solve(root.right);

        root.right = temp2;
        root.left = temp1;

        return  res;
    }

    static  int get(Node root)
    {
        if(root==null)
            return  0;


        return  root.data+get(root.left)+ get(root.right);
    }
    static class Node {
        int data;
        Node left, right;
        Node()
        {
            data = 0;
            left = null;
            right = null;

        }
        Node(int d)
        {
            data = d;
            left = null;
            right = null;

        }

    }
    static void preorder(Node root)
    {
        if(root==null)
            return;

        System.out.println(root.data);

        preorder(root.left);
        preorder(root.right);

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

        toSumTree(root);


        preorder(root);




    }
    static Node newNode(int item) {
       Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }
}
