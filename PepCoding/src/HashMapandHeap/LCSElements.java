package HashMapandHeap;

import java.util.*;

public class LCSElements{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int ar[] = new int[size];
        for(int i=0;i<size;i++)
            ar[i] = sc.nextInt();
        ArrayList<Integer> res = solve3(ar, size);

        for(int i : res)
            System.out.println(i);


    }
    static ArrayList<Integer> solve(int ar[], int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<>();

        Arrays.sort(ar);

        if(size==0)
            return res;

        temp.add(ar[0]);
        for(int i =1; i<size; i++)
        {
            if(ar[i] - ar[i-1] <= 1)
            {
                if(ar[i] - ar[i-1] == 0)
                    continue;
                temp.add(ar[i]);
            }

            else
            {
                if(temp.size() >  res.size())
                    res =  temp;
                temp = new ArrayList<>();
                temp.add(ar[i]);
            }

        }
        if(temp.size()>res.size())
            res = temp;
        return res;


    }
    static ArrayList<Integer> solve2(int ar[], int size)
    {
        int max = -1;
        HashSet<Integer>  set = new HashSet<>();
        ArrayList<Integer> res =  new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i : ar)
            set.add(i);



        for(int i =0;i<=15;i++)
        {

            if(i<max) {
                continue;
            }else
            {
                max = i;
                temp = new ArrayList<>();

                while(set.contains(max)) {
                    temp.add(max);
                    max++;
                }

                if(temp.size()>res.size())
                {
                    res = temp;
                }
            }
        }
        if(temp.size()>res.size())
            res = temp;



        return  res;
    }

    //BEST APPROACH
    static ArrayList<Integer>  solve3(int ar[], int size)
    {
        ArrayList<Integer>  res = new ArrayList<>();
        ArrayList<Integer>  temp = new ArrayList<>();
        HashMap<Integer, Boolean> hmap = new HashMap<>();
        for(int i:ar)
            hmap.put(i, true);

        for(int i : ar)
        {
            if(hmap.containsKey(i-1))
                hmap.put(i, false);
        }
        for(int i : ar)
        {
            if(hmap.get(i) == true)
            {
                temp = new ArrayList<>();
                int key = i;
                while(hmap.containsKey(key))
                    temp.add(key++);

                if(temp.size()>res.size())
                    res = temp;
            }
        }
        if(temp.size()>res.size())
            res = temp;




        return res;
    }



}