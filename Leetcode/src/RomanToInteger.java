import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = solve(s);
        System.out.println( ans);
    }

    static int solve(String s)
    {
        Map<Character, Integer> mp = new HashMap<>();

        mp.put('I', 1);
        System.out.println( mp.get('I'));
//        int n = s.length();
//        int res = 0;
//        char c = s.charAt(n-1);
//        if(c=='I')
//        {
//            res = 1;
//            System.out.println("HERE `1");
//        }
//        else if(c=='V')
//        {
//            res = 5;
//        }
//        else if(c=='X')
//        {
//            res = 10;
//        }
//        else if(c=='L')
//        {
//            res = 50;
//        }
//        else if(c=='C')
//        {
//            res = 100;
//        }
//        else if(c=='D')
//        {
//            res = 500;
//        }
//        else if(c=='M')
//        {
//            res = 1000;
//        }
//
//
//        for(int i = n-2;i>=0;i--)
//        {
//            int temp =0;
//            c = s.charAt(i);
//
//
//            if(c=='I')
//            {
//                System.out.println("HERE 2");
//                temp = 1;
//            }
//            else if(c=='V')
//            {
//                temp = 5;
//            }
//            else if(c=='X')
//            {
//                temp = 10;
//            }
//            else if(c=='L')
//            {
//                temp = 50;
//            }
//            else if(c=='C')
//            {
//                temp = 100;
//            }
//            else if(c=='D')
//            {
//                temp = 500;
//            }
//            else if(c=='M')
//            {
//                temp = 1000;
//            }
//
//
//            if(temp<res)
//                res -= temp;
//            else
//                res += temp;
//        }
        return 0;
    }
}
