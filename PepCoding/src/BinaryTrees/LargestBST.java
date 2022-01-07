package BinaryTrees;
import java.io.*;
import java.util.*;

public class LargestBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    static Node maxSubtree;
    static int maxValue = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        maxSubtree = null;
        maxValue = -1;
        findSubtree(root);

        System.out.println(maxSubtree.data+"@"+maxValue);

    }
    static int findSubtree(Node node)
    {
        if(node == null)
            return 0;
        if(isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE) == true)
        {
            int count = child(node);
            if(count > maxValue)
            {
                maxValue = count;
                maxSubtree = node;

            }
        }
        else
        {
            findSubtree(node.left);
            findSubtree(node.right);
        }
        return 0;

    }


    static boolean isBST(Node node,int min, int max)
    {
        if(node == null)
            return true;

        if(node.data >= max && node.data <=min)
            return  false;
        return isBST(node.left, min, node.data-1) && isBST(node.right, node.data+1, max);
    }

    static int child(Node node)
    {
        if(node == null)
            return 0;
        return 1 + child(node.left)+child(node.right);
    }

}