package Level2.Btree;
import java.util.Scanner;

public class HouseOfRobber {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static  housepair HouseRobber_(TreeNode root)
    {
        if(root == null)
            return  new housepair();
        housepair left = HouseRobber_(root.left);
        housepair right =  HouseRobber_(root.right);
        housepair myAns = new housepair();
        myAns.withRobbery = left.withoutrobbery+ root.val+ right.withoutrobbery;
        myAns.withoutrobbery = Math.max(left.withRobbery, left.withoutrobbery)+Math.max(right.withoutrobbery, right.withRobbery);

        return  myAns;

    }

    static  class housepair{
        int withRobbery  =0;
        int withoutrobbery = 0;

    }
    public static int HouseRobber(TreeNode root) {
        if(root == null)
            return 0;
        housepair h =  HouseRobber_(root);
        return  Math.max(h.withoutrobbery, h.withRobbery);
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}