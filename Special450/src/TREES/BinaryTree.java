package TREES;

import java.util.*;

public class BinaryTree {

    static class Node {
        int data;
        Node left, right;
    }



    static ArrayList<Integer> leftView(Node root)
    {

        // Your code here


        ArrayList<Integer> adj = new ArrayList<>();
        if (root == null)
            return adj;

//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();

            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();

                // Print the left most element at
                // the level
                if (i == 1)
                    adj.add(temp.data);
                // System.out.print(temp.data + " ");

                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);

                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return adj;


    }
    static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));


    }

    static Node mirrorify(Node root)
    {
        if (root == null)
        {
            return null;

        }

        // Create new mirror node from original tree node
        Node mirror = new Node();
        mirror.data = root.data;

        mirror.right = mirrorify(root.left);

        mirror.left = mirrorify(root.right);
        return mirror;
    }

   static ArrayList<Integer> reverseLevelOrder(Node node) {
        // code here


        ArrayList<Integer> ans = new ArrayList<Integer>();

            int h = height(node);
       for(int  i = h+1;i>=1;i--)
           addoflevel(node, i, ans);



        return ans;

    }

    static void addoflevel(Node root, int level, ArrayList<Integer> al) {
        if (root == null)
            return;
        if (level == 1)
            al.add(root.data);
        addoflevel(root.left, level - 1, al);
        addoflevel(root.right, level - 1, al);

    }





    static Node newNode(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
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
//      ArrayList<Integer> and =   reverseLevelOrder(root);
//
//
//        System.out.println(and);
        System.out.println(new BinaryTree().diameter(root));


    }

    static ArrayList<Integer> levelOrder(Node node) {
        // Your code here
        ArrayList<Integer> adj = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.peek();
            adj.add(n.data);
            q.remove();
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
        return adj;


    }






    //DIAMETER
    int diameter(Node root) {
        // Your code here
        if (root==null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);


        int leftdiameter = diameter(root.left);
        int rightdiameter = diameter(root.right);


        return  Math.max(1+leftHeight+rightHeight ,
                Math.max(leftdiameter,rightdiameter));

    }


    private void TopView(Node root)
    {
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, Node> topViewMap
                = new TreeMap<Integer, Node>();

        if (root == null) {
            return;
        }
        else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println(
                "The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left,
                        tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right,
                        tmpNode.hd + 1));
            }
        }
        for (Map.Entry<Integer, Node> entry :
                topViewMap.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }

}
