package Level2.Btree;
import java.util.Scanner;

public class CamerasInBtree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count = 0;
    public static int MinCamerasInBT(TreeNode root) {
        if(root == null)
            return  count ;

        int leftneed =  find(root.left);
        int rightneed = find(root.right);
        if(leftneed == -1 || rightneed == -1)
            count++;
        if(leftneed == 1 && rightneed == 1 )
            count++;



        return count;
    }
    static  int find(TreeNode node)
    {
        if(node == null)
            return  1;
        if(node.left == null && node.right == null)
            return  -1;
        int leftneed =  find(node.left);
        int rightneed = find(node.right);
        if(leftneed == -1 || rightneed == -1) {
            count++;
            return  2;
        }
        if(leftneed == 1 && rightneed == 1 ) {
            count++;
            return  2;
        }
        return 1;
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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}