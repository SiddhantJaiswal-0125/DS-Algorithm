package Level2.Btree;
import java.util.*;


//JUST  INORDER TRAVERSAL

public class MorisTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> morrisInTraversal(TreeNode Treenode) {

        ArrayList<Integer> ar = new ArrayList<>();
        inorder(Treenode,ar);
        return ar;


    }
    static void inorder(TreeNode node,  ArrayList<Integer> ar)
    {
        if(node  ==  null)
            return ;
        inorder(node.left,ar);
        ar.add(node.val);
        inorder(node.right,ar);
        return ;

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<Integer> ans = morrisInTraversal(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}