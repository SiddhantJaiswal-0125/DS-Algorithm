package LeetCodeDaily;

import java.util.*;

//https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/?envType=daily-question&envId=2025-02-07
public class FindtheNumberofDistinctColorsAmongtheBalls {


    void printArray(int ar[])
    {
        for(int i:ar)
            System.out.print(i+"\t");
        System.out.println();
    }
        public int[] queryResults(int limit, int[][] queries) {
            int colors[] = new int[limit+1];
            HashMap<Integer, HashSet<Integer>> hmap = new HashMap<>();
            int size = queries.length;
            int ans[]  = new int[size];
            for(int i = 0; i< size; i++)
            {
                int x = queries[i][0];
                int y = queries[i][1];
                HashSet<Integer> temp;

                if(hmap.containsKey(y))
                {
                    temp = hmap.get(y);
                    temp.add(x);
                    hmap.put(y,temp);

                }
                else
                {
                    temp = new HashSet<>();
                    temp.add(x);
                    hmap.put(y,temp);
                }

                if(colors[x] !=0 && colors[x] != y)
                {
                    temp = hmap.get(colors[x]);
                    temp.remove(x);

                    if(temp.size() == 0)
                    {
                        //remove element from hashmap
                        hmap.remove(colors[x]);
                    }



                }

                ans[i] = hmap.size();

                colors[x] = y;

            }



            return ans;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int n = sc.nextInt();

        int q[][] = new int[n][2];

        for(int i=0;i<n;i++)
        {
            q[i][0] = sc.nextInt();
            q[i][1] = sc.nextInt();
        }

        int ans[] = new FindtheNumberofDistinctColorsAmongtheBalls().queryResults(limit,q);

        for(int i : ans)
            System.out.print(i+"\t");
        System.out.println();
    }
}
//1
//        5
//        0
//        1
//        0
//        4
//        0
//        4
//        0
//        1
//        1
//        2