package Level2.Btree;
import java.util.Scanner;

public class RecoverBST {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void recoverTree(TreeNode root) {

        TreeNode first = findfirst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        TreeNode second = findsecond(root, first, Integer.MIN_VALUE, Integer.MAX_VALUE );
        if(first==null ||  second==null)
            return;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return;

    }

    static TreeNode findsecond(TreeNode root,TreeNode first, int min, int max)
    {

        if(root ==  null)
            return null;


        if((root.val >= max || root.val <= min ) && root!=first) {
            System.out.println("FOUND Second AT "+root.val);
            return root;
        }

        TreeNode left =  findsecond( root.left, first, min, root.val) ;
        TreeNode right =  findsecond(root.right, first, root.val, max);

        if(left == null)
            return right;
        else
            return left;

    }
    static TreeNode findfirst(TreeNode root, int min, int max)
    {

        if(root ==  null)
            return null;


        if(root.val >= max || root.val <= min) {
            System.out.println("FOUND FIRST AT "+root.val);
            return root;
        }

        TreeNode left =  findfirst(root.left, min, root.val) ;
        TreeNode right =  findfirst(root.right, root.val, max);
        if(left == null)
            return right;
        else return left;

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
        display(root);
        System.out.println("AFTER RECOVERY");
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}