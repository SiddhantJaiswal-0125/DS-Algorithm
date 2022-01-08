package HashMapandHeap;

import java.util.*;

public class getCommon{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);


        int n1 = sc.nextInt();
        int a1[]=  new int[n1];
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0;i< n1; i++)
        {
            a1[i] = sc.nextInt();
            int count = 0;
            count = hmap.get(a1[i]) ==  null ? 0:hmap.get(a1[i]);
            count++;
            hmap.put(a1[i], count);
        }
        int n2 = sc.nextInt();
        int a2[] = new int[n2];
        for(int i = 0;i <n2 ; i++)
            a2[i] = sc.nextInt();


        for(int i :a2)
        {
           int c1 = hmap.get(i) ==null?0:hmap.get(i);
           if(c1>0) {
               System.out.println(i);
               c1--;
               hmap.put(i, c1);

           }
        }

    }

}
