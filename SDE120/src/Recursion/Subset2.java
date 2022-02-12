package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subset2
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i= 0;i<n;i++)
            ar[i] = sc.nextInt();

        List<List<Integer>> li =
        new Subset2().subsetsWithDup2(ar);
        for(List<Integer> l :li)
        {
            for(int i: l)
                System.out.print(i+" ");
            System.out.println();
        }


    }


        public List<List<Integer>> subsetsWithDup2(int[] nums) {
            List<List<Integer>> li = new ArrayList();
            Arrays.sort(nums);
            recur(0, li, new ArrayList<>(), nums);
            return li;

        }

        void recur(int start, List<List<Integer>> li, List<Integer> temp, int ar[])
        {

            li.add(new ArrayList(temp));

            for(int j = start;j<ar.length;j++)
            {
                if(j>start && ar[j]==ar[j-1]) continue;

                    temp.add(ar[j]);
                    recur(j+1, li, temp, ar);
                    temp.remove(temp.size()-1);


            }
            return;

        }


}
