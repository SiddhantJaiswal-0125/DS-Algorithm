package Level2.Btree;
import java.util.Scanner;

public class BtreefromPreAndIn {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;

        return buildInPre(preorder, 0, size -1, inorder, 0, size -1);
    }
    static TreeNode buildInPre(int pre[], int psi, int pei, int in[], int isi, int iei)
    {
        if(iei<isi)
            return  null;
        TreeNode root = new TreeNode(pre[psi]);


        int idx = isi;
        while(in[idx]!=pre[psi])
            idx++;
        int count = idx - isi;
        root.left = buildInPre(pre, psi+1, pei+count, in, isi, idx-1);
        root.right = buildInPre(pre, psi+count+1, pei, in, idx+1, iei);

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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}