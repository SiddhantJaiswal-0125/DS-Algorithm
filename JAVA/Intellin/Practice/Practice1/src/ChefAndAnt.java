import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

 class ChefAndAnt
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while  (test-->0)
        {


            int n = sc.nextInt();
            long total = 0l;
            long count = 0l;
            HashSet<Integer> totalPos = new HashSet<Integer>();




            HashSet add =  new HashSet<>();
            Hashtable <Integer,Integer> ht= new Hashtable<>();

            while(n-->0)
            {
                int size = sc.nextInt();
                int m[] = new int[size];

                long collisionAtCenter = 0l;
                for(int  i = 0;i<size;i++)
                {
                    m[i] = sc.nextInt();
                    int k = 1;

                    if(ht.contains((int)Math.abs(m[i])))
                    {
                        k =ht.get((int)Math.abs(m[i]));
                        k=k+1;

                    }
                    ht.replace((int)Math.abs((m[i])),k);
                }
            }
            System.out.println(total-count);
            }



        }
    }

