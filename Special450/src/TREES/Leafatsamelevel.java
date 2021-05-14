package TREES;

public class Leafatsamelevel
{
    static Node newNode(int item) {
       Node temp = new Node();
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }
    static class Node {
        int data;
        Node left, right;
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
//        root.left.left = newNode(10);
//        root.left.right = newNode(10);
        System.out.println(check(root));
    }

static boolean check(Node root)
{
    return check2(root, 0, 0);


}
static boolean check2(Node root, int l,int finalLevel)
{
    if(root==null)
        return  true;

    if(root.left==null && root.right==null)
    {
        if(finalLevel == 0)
        {
            finalLevel = l;
            return true;

        }
        return  l==finalLevel;
    }

    return  check2(root.left, l+1, finalLevel) && check2(root.right, l+1, finalLevel);


}


}
