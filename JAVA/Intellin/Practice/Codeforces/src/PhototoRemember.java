
import java.util.*;
class Sol
{
    static Node root = null;

    static Queue<Node> q =
            new LinkedList<>();
    static class Node
    {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    };

    static Node newNode(int item)
    {
        Node temp = new Node(item);
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }


    static int findCousinSum(Node root, int key)
    {
        if (root == null)
            return -1;
        if (root.data == key)
        {
            return -1;
        }

        int currSum = 0;
        int size;

        Queue<Node> q=new LinkedList<Node>();
        q.add(root);

        boolean found = false;

        while (q.size() > 0)
        {

            if (found == true)
            {
                return currSum;
            }


            size = q.size();
            currSum = 0;

            while (size > 0)
            {
                root = q.peek();
                q.remove();

                if ((root.left!=null && root.left.data == key)
                        || (root.right!=null && root.right.data == key))
                {
                    found = true;
                }

                else
                {
                    if (root.left != null)
                    {
                        currSum += root.left.data;
                        q.add(root.left);
                    }

                    if (root.right != null)
                    {
                        currSum += root.right.data;
                        q.add(root.right);
                    }
                }

                size--;
            }
        }

        return -1;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Sol   t2 = new Sol();
        int k = sc.nextInt();
        int n = sc.nextInt();
        int size =(int) Math.pow(2,n+1) -1;
        int ar[] = new int[size];
         for(int i= 0;i<size;i++)
            ar[i] = sc.nextInt();

        t2.root = t2.insertLevelOrder(ar, t2.root, 0);
    }

    public Node insertLevelOrder(int[] arr, Node root,
                                 int i)
    {

        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }

    public void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
}


