package Level2.Btree;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return  new String(sb);
    }
    static  void preorder(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");
        preorder(root.left, sb);
        preorder(root.right,sb);
        return;
    }

    // Decodes your encoded data to tree.
    static  int idx = 0;
    public static TreeNode deserialize(String str) {

        String st[] = str.split(",");

        TreeNode root = dec(st);



        return  root;
    }
    static  TreeNode dec(String st[])
    {

        if(idx>= st.length)
        {
            idx ++;
            return  null;
        }
        String s = st[idx];
        if(s.equalsIgnoreCase("null"))
        {

            idx ++;
            return  null;
        }
        TreeNode root = new TreeNode( Integer.parseInt(st[idx]));
        idx++;
        root.left = dec(st);
        root.right = dec(st);
        return  root;

    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}