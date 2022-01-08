import java.util.*;
public class CousinSumBT
{

    // A Binary Tree Node
    static class Node
    {
        int data;
        Node left, right;
    };

    static Node newNode(int item)
    {
        Node temp = new Node();
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

    // Driver Code
    public static void main(String args[])
    {
	/*
				1
			/ \
			3 7
		/ \ / \
		6 5 4 13
			/ / \
			10 17 15
	*/

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

        System.out.println(solve(root, 17));
        System.out.print( findCousinSum(root, 17) + "\n");
        System.out.print( findCousinSum(root, 13) + "\n");

        System.out.print( findCousinSum(root, 7) + "\n");
    }


    static  int solve(Node root, int key)
    {
        //MYCODE

        if(root==null) {
            System.out.println("HERE");
            return -1;
        } if (root.data==key) {
        System.out.println("HERE 2");
        return -1;
    }
        Queue <Node> q = new LinkedList<>();
        int sum = 0;
        q.add(root);
        boolean found = false;

        while(!q.isEmpty())
        {


            if(found )
                return  sum;
            sum = 0;

            int size = q.size();
            while(size>0)
            {
                root = q.peek();
                q.remove();
                if( (root.left!=null && root.left.data==key)
                        ||
                        (root.right!=null && root.right.data == key)) {
                    found = true;
                }
                else
                {
                    if(root.left!=null ) {
                        sum += root.left.data;
                        q.add(root.left);

                    }
                    if(root.right!=null ) {
                        sum += root.right.data;
                        q.add(root.right);

                    }



//                    if (root.left != null)
//                    {
//                        currSum += root.left.data;
//                        q.add(root.left);
//                    }
//
//                    if (root.right != null)
//                    {
//                        currSum += root.right.data;
//                        q.add(root.right);
//                    }


                }

                size--;
            }


        }



        return  -1;
    }
}

// This code is contributed by Arnab Kundu

