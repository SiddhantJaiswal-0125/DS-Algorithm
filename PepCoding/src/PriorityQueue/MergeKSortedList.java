package PriorityQueue;
import java.io.*;
import java.util.*;

public class MergeKSortedList {
    static class Pair implements Comparable<Pair>
    {
        int li, di, val;
        Pair(int a, int b, int c)
        {
            li = a;
            di = b;
            val = c;
        }

       public  int compareTo(Pair o)
        {
            return this.val - o.val;
        }
    }


    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        int size = lists.size();

        if(size==0)
            return rv;
        ArrayList<Integer> temp1 = lists.get(0);
        for(int i : temp1)
            rv.add(i);



        for(int i = 1;i<size;i++)
        {


            temp1 = lists.get(i);
            ArrayList<Integer> temp2 = new ArrayList<>(rv);
            int size1 = temp1.size();
            int size2 = rv.size();

            rv = new ArrayList<>();
            int x = 0, y = 0;

            while(x < size1 && y <size2)
            {
                if(temp1.get(x) < temp2.get(y))
                    rv.add( temp1.get(x++) );
                else
                    rv.add(temp2.get(y++));
            }
            while(x<size1)
                rv.add(temp1.get(x++));

            while(y<size2)
                rv.add(temp2.get(y++));
        }



        return rv;
    }

    static  ArrayList<Integer>   mergeKSortedLists2(ArrayList<ArrayList<Integer>> lists)
    {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i =0;i<lists.size();i++)
        {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }
        while(pq.size()>0)
        {
            Pair p = pq.remove();
            res.add(p.val);
            p.di++;
            if(p.di < lists.get(p.li).size())
            {
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }



        return  res;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists2(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }

}