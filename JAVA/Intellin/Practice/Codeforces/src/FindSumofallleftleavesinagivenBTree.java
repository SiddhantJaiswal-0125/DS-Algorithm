


    class BinaryTree {
    static     class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
        Node root;

        // A utility function to check if a given node is leaf or not
     static    boolean isLeaf(Node node) {
            if (node == null)
                return false;
            if (node.left == null && node.right == null)
                return true;
            return false;
        }

        // This function returns sum of all left leaves in a given
        // binary tree

        static int leftLeavesSum(Node node) {
            // Initialize result
            int res = 0;

            // Update result if root is not NULL
            if (node != null) {
                // If left of root is NULL, then add key of
                // left child
                if (isLeaf(node.left))
                    res += node.left.data;
                else // Else recur for left child of root
                    res += leftLeavesSum(node.left);

                // Recur for right child of root and update res
                res += leftLeavesSum(node.right);
            }

            // return result
            return res;
        }

        // Driver program
        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(20);
            tree.root.left = new Node(9);
            tree.root.right = new Node(49);
            tree.root.left.right = new Node(12);
            tree.root.left.left = new Node(5);
            tree.root.right.left = new Node(23);
            tree.root.right.right = new Node(52);
            tree.root.left.right.right = new Node(12);
            tree.root.right.right.left = new Node(50);

//            System.out.println("The sum of leaves is " +
//                    tree.leftLeavesSum(tree.root));
            System.out.println(solve(tree.root));
        }


    static int solve(Node root) {
        if (root == null)
            return 0;
            if(isLeaf(root.left))
                return root.left.data + solve(root.right)  ;
            else
                return  solve(root.left) + solve(root.right);

//        return solve(root.left) ;


    }

    static  boolean isleaf(Node root)
    {
        return ( root.left== null && root.right==null) ;

    }

}
