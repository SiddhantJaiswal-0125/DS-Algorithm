package BST;
import java.io.*;
import java.util.*;

public class TargetPair {
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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        // write your code here

        pdt = new ArrayList<>();
        root1 = root;
        findPairs(root, data);
        for(pairDT pd : pdt)
            System.out.println(pd.small+" "+pd.big);


    }
    static ArrayList<pairDT> pdt;
    static Node root1;

    static void findPairs(Node node, int data)
    {
        if(node == null)
            return ;

        findPairs(node.left, data);
        int ele = node.data;
        int comp = data - ele;
        if(ele<comp )
        if(findele(root1, comp))
        {
            //DUSRA BHAI MIL GYA
            pairDT p = new pairDT(Math.min(data-ele,ele), Math.max(data-ele, ele));
            pdt.add(p);


        }
        findPairs(node.right, data);




    }
    static boolean findele(Node root, int val)
    {
        if(root == null)
            return false;
        if(root.data ==  val)


            return true;




        if(root.data < val)
        {
            //RIGHT JAO
            return findele(root.right,val);


        }
        else
        {
            //LEFT JAO
            return findele(root.left,val);

        }


    }


    static class pairDT{
        int small,big;
        pairDT(int a, int b)
        {
            small = a;
            big = b;
        }
    }

}