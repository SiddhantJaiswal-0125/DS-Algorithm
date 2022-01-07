package HashMapandHeap;

import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter
{
    public static void main(String[] args) throws Exception   {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashMap<Character, Integer> hm = new HashMap<>();
        int size = s.length();
        int max =  -1;
        char res = ' ';

        for(int i  =0; i < size; i++)
        {
            char c = s.charAt(i);
            int count = 0;

            count = hm.containsKey(c)?hm.get(c):0;
            count ++;


            hm.put(c, count);

            if(max<count)
            {
                max = count;
                res = c;

            }

        }
        System.out.println(res);

    }
}
