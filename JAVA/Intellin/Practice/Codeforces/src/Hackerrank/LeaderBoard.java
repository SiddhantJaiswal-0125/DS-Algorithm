package Hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeaderBoard
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        int n =sc.nextInt();
//        List<Integer> ranked = new ArrayList<>();
//        for(int i =0;i<n;i++)
//        {
//            int a = sc.nextInt();
//            ranked.add(a);
//
//        }
//        int m =sc.nextInt();
//        List<Integer> player = new ArrayList<>();
//        for(int i =0;i<m;i++)
//        {
//            int a = sc.nextInt();
//            player.add(a);
//        }
//        List<Integer> res = climbingLeaderboard(ranked,player);
//        for(int i:res)
//            System.out.print(i+"\t");
//        System.out.println();
//      int a =   (-100 && 100)||(20&&-20)
            int a = 5;
            switch (a)
            {
//                System.out.println("HERE");
                case 1:
                    System.out.println("HEL");
            }

    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        int size1 = ranked.size();
        int totalrank =1;

        for(int i =1;i<size1;i++)
        {

            if(ranked.get(i)!=ranked.get(i-1))
                totalrank++;
        }
        totalrank++;

        ArrayList<Integer> res = new ArrayList<>();

        int j = ranked.size()-1;
        for(int i =0;i<player.size();)
        {
                if(j>0 && ranked.get(j)==ranked.get(j-1))
                    j--;
                else if(j>=0 && player.get(i) >= ranked.get(j))
                {
                    if(totalrank>1)
                        totalrank--;
                    j--;
                }
                else {
                    res.add(totalrank);
                i++;

                }




        }


        return res;

    }


}
