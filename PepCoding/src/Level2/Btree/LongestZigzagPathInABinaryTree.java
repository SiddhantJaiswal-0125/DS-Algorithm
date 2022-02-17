package Level2.Btree;

import java.util.Scanner;

public class LongestZigzagPathInABinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static  int max = -1;
    public static int longestZigZagPath(TreeNode root) {
        max = -1;
        int left = traverseZigzag(root, false);
        int right = traverseZigzag(root, true);
        return Math.max(max,  Math.max(left, right));
    }
    static int traverseZigzag(TreeNode root, boolean goleft)
    {
        int left = 0, right = 0;
        if(root == null)
            return -1;
        left =  1+traverseZigzag(root.left, false);
        right =  1+traverseZigzag(root.right, true);

        if(left>max)
            max = left;
        else if(right> max)
            max = right;

        if(goleft)
            return left;
        else
            return right;

    }


    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
