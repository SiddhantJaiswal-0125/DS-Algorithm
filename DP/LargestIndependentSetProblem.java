class Solution {
    static class Node
    {
        int data ;
        Node left, right;

    }
    public int LISS(Node node)
    {
        //Write your code here       
        if(node==null)
        return 0;
        return solve(node , true);
    }
    static int solve(Node node, boolean take)
    {
        if(node==null)
        return 0;

        if(take==false)
            return solve(node.left, !take) + solve(node.right, !take);
         else 
         return Math.max(1+ solve(node.left, false) + solve(node.right, false) , solve(node.left, true) + solve(node.right, true));   
    
    }
}