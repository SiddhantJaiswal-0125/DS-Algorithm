package BST;

public class DeletionOfANode
{

    public static void main(String[] args) {
        BST a = new BST();
        a.insert(5);
        a.insert(3);
        a.insert(6);
        a.insert(2);
        a.insert(4);
        a.insert(7);
        a.print(BST.root);
        System.out.println();

        a.deleteNode(BST.root,3 );
        a.print(BST.root);
    }



}
class BST
{
    static Node root;
    BST()
    {
        System.out.println("HERE AT CONSTRUCTOR");
        root = null;
    }
    void insert(int key)
    {
      root =   insertTraversal(root, key);
    }
    private Node insertTraversal(Node root, int key)
    {
        if(root == null) {
        return   root = new Node(key);
        }
        if(root.data < key)
        root.right =  insertTraversal(root.right, key);
        else if(root.data>key)
        root.left = insertTraversal(root.left, key);

        return  root;
    }
    void print(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.data+"--> \t");
        print(root.left);
        print(root.right);
    }



    public Node deleteNode(Node root, int key)
    {
        if(root==null)
            return  null;
        if( root.data==key)
        {
            //check
            if(root.left ==null && root.right==null)
            {
                //leaf node


               return null;
            }
            else if(root.left==null && root.right!=null)
            {
                //1Child

                return  root.right;


            }

            else if(root.left!=null && root.right==null)
            {
                //1 Child
                return root.left;

            }
            else
            {
              //  both child

                // successor (smallest in the right subtree)
                root.data = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteNode(root.right, root.data);


            }
        }


        if(key<root.data)
        root.left = deleteNode(root.left,key);
        else if (key>root.data)
        root.right = deleteNode(root.right,key);



        return root;




    }
    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

}
class Node
{
    int data;
    Node left , right;
    Node (int data)
    {
        this.data = data;
        left  = null ;
        right = null;
    }
}