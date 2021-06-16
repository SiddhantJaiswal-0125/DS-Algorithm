package BST;

import java.util.Scanner;

public class predecesor {


    public static void main(String[] args) {
        BST a = new BST();
        Scanner sc = new Scanner(System.in);
        a.insert(50);
        a.insert(30);
        a.insert(20);
        a.insert(40);
        a.insert(70);
        a.insert(60);
        a.insert(80);
        a.print(BST.root);
        System.out.println("ENTER KEY");
        int key = sc.nextInt();

       Res p = new Res(), s = new Res();
       a.findPreSuc(BST.root, p, s, key);
       if(p.pre==null)
           System.out.println(-1);
       else System.out.println("PRCESSOR is "+p.pre.data);
       if(s.succ==null)
           System.out.println(-1);
       else System.out.println("SUCC IS "+s.succ.data);


        System.out.println();
    }

   static class BST {

       public  void findPreSuc(Node root, Res p, Res s, int key)
       {
           findfloor(root, key , p);
           findCeil(root, key, s);

       }

    void findfloor(Node root, int key, Res p)
       {
           if(root==null)
               return ;
           if(root.data>key)
           {
               findfloor(root.left, key, p);
           }
           else
           {
               if(p.pre==null)
               {
                   p.pre = new Node(root.data);

               }
               else if(p.pre!=null&&p.pre.data < root.data)
               {
                   p.pre.data = root.data;
               }


            findfloor(root.right, key, p);
return;

           }

       }

      void findCeil(Node root, int key, Res s) {
           if (root == null)
               return ;
           if (root.data < key) {
                findCeil(root.right, key, s);
           } else {
               if (s.succ == null) {
                   s.succ = new Node(root.data);
               }
               else if (s.succ.data > root.data) {
                   s.pre.data = root.data;
               }

               findCeil(root.right, key, s);
               return;
           }
       }



       static Node root;

        BST() {
            System.out.println("HERE AT CONSTRUCTOR");
            root = null;
        }

        void insert(int key) {
            root = insertTraversal(root, key);
        }

        private Node insertTraversal(Node root, int key) {
            if (root == null) {
                return root = new Node(key);
            }
            if (root.data < key)
                root.right = insertTraversal(root.right, key);
            else if (root.data > key)
                root.left = insertTraversal(root.left, key);

            return root;
        }

        void print(Node root) {
            if (root == null)
                return;
            System.out.print(root.data + "--> \t");
            print(root.left);
            print(root.right);
        }


        public Node deleteNode(Node root, int key) {
            if (root == null)
                return null;
            if (root.data == key) {
                //check
                if (root.left == null && root.right == null) {
                    //leaf node


                    return null;
                } else if (root.left == null && root.right != null) {
                    //1Child

                    return root.right;


                } else if (root.left != null && root.right == null) {
                    //1 Child
                    return root.left;

                } else {
                    //  both child

                    // successor (smallest in the right subtree)
                    root.data = minValue(root.right);

                    // Delete the inorder successor
                    root.right = deleteNode(root.right, root.data);


                }
            }


            if (key < root.data)
                root.left = deleteNode(root.left, key);
            else if (key > root.data)
                root.right = deleteNode(root.right, key);


            return root;


        }

        int minValue(Node root) {
            int minv = root.data;
            while (root.left != null) {
                minv = root.left.data;
                root = root.left;
            }
            return minv;
        }

    }
static  class Res{
        Node pre  = null;
        Node succ = null;
}
   static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}