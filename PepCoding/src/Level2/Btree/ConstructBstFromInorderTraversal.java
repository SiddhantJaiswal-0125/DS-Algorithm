package Level2.Btree;

import java.util.Scanner;

public class ConstructBstFromInorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        return createBST(inOrder, 0, inOrder.length-1);
    }

    static TreeNode createBST(int in[], int si, int ei)
    {
        if(si>ei)
            return null;
        int mid = (si + ei)/2;
        TreeNode root = new TreeNode(in[mid]);
        root.left = createBST(in, si, mid -1);
        root.right = createBST(in, mid+1, ei);


        return root;
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
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
