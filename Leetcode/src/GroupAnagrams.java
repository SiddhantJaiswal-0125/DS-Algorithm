import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GroupAnagrams
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sr[] = new String[n];
        for(int i =0;i<n;i++)
            sr[i]= sc.next();
        List<List<String >>res = new GroupAnagrams().groupAnagrams(sr);
        System.out.println(res);

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();


        for(int i = 0;i<strs.length;i++)
        {


            List<String>  li = new ArrayList<>();
            if(strs[i]== null)
                continue;
            else
                li.add(strs[i]);

            String check = "";
            char c[] = strs[i].toCharArray();
            Arrays.sort(c);
            check = new String(c);

            strs[i] = null;
            for(int j = i+1;j<strs.length;j++)
            {

                if(strs[j] ==  null)
                    continue;
                c = strs[j].toCharArray();
                Arrays.sort(c);
                String cp =new String(c);
                if(check.equalsIgnoreCase(cp))
                {
                    li.add(strs[j]);
                    strs[j] = null;
                }
            }


            res.add(li);
        }
        return  res;

    }
}
