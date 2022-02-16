package Level2.Btree;

import java.util.Scanner;

public class ConstructBstFromPostorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstFromPostorder(int[] postOrder) {
        return createBst(postOrder, 0, postOrder.length-1);
    }
    static TreeNode createBst(int post[], int si, int ei)
    {
        if(si>ei)
            return  null;
        TreeNode root = new TreeNode(post[ei]);
        int idx = ei;
        while(idx>=si && post[idx] >= post[ei] )
            idx--;

        root.left = createBst(post, si, idx);
        root.right = createBst(post,idx+1, ei-1);
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

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}