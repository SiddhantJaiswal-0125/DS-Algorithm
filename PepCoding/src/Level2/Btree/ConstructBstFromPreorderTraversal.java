package Level2.Btree;

//ConstructBstFromPreorderTraversal


import java.util.Scanner;

public class ConstructBstFromPreorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {

        if(preorder.length == 0)
            return  null;

        return createBST(preorder, 0, preorder.length -1);
    }
    static  TreeNode createBST(int pre[] , int si, int ei)
    {
        if(si>ei)
            return  null;

        TreeNode root = new TreeNode(pre[si]);
        int idx = si;
        while(idx <= ei &&pre[idx] <= pre[si] )
            idx++;

        root.left = createBST(pre,si+1, idx-1);
        root.right = createBST(pre, idx, ei);

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

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}