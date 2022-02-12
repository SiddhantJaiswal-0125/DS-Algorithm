package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<List<String>> res = new PalindromePartitioning().partition(s);
        System.out.println(res);

    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s,0,ans, new ArrayList<String>());
     return  ans;
    }

    void partitionHelper(String s, int index,  List<List<String>> ans, List<String>temp)
    {
        int size = s.length();
        if(index==size)
        {
            System.out.println("HERE");
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i= index; i<size;++i)
        {
            if(isPalin(s, index, i))
            {
                temp.add(s.substring(index,i+1));
                partitionHelper(s,  i+1, ans, temp);
                temp.remove(temp.size()-1);
            }
        }



    }










    boolean isPalin(String s, int start, int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;


            start++;
            end--;
        }

        return true;
    }

}
