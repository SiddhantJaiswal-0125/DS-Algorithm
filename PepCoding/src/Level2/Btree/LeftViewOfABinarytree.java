package Level2.Btree;



import java.util.*;

public class LeftViewOfABinarytree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

   static int maxlevel = 0;
    public static ArrayList<Integer> leftView(TreeNode root) {

        ArrayList <Integer> res = new ArrayList<>();

        getleftView(root,1, res);

        return res;

    }
    static  void getleftView(TreeNode root, int curlevel, ArrayList<Integer> res)
    {
        if(root == null)
            return;
        if(curlevel>maxlevel)
        {
            res.add(root.val);
            maxlevel++;
        }
        getleftView(root.left,curlevel+1, res);
        getleftView(root.right,curlevel+1, res);
        return;
    }

    // input_section=================================================

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

        ArrayList<Integer> ans = leftView(root);
        for(Integer i : ans) System.out.println(i);
    }

    public static void main(String[] args) {
        solve();
    }
}