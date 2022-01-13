import java.util.HashSet;
import java.util.Scanner;

public class Banana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        solve(s,k);
        return;
    }
    static void solve(String s, int k )
    {
        int size = s.length();
        HashSet<Character> hs = new HashSet<>();
        for(int i  =0 ;i<size;i++)
            hs.add(s.charAt(i));
        if(hs.size()>k)
        {
            System.out.println("-1");
            return;
        }
        if(k>=size)
        {
            if(k==size)
            {
                System.out.println(1);
                System.out.println(s);
                return;
            }
            String res = s;
            for(int i = size;i<=k;i++)
                res+="a";
            System.out.println(1);
            System.out.println(res);
        }

        else
        {
            int freq[] = new int[26];
            for(int i  =0 ;i<size;i++) {
                freq[s.charAt(i) - 'a']++;
            }

            int sheets =2;
            while(true) {

                int ct[] = new int[26];
                for (int i = 0; i < 26; i++)
                    if (freq[i] == 0)
                        continue;
                    else {
                        ct[i] = (int) Math.ceil(freq[i] / (double) sheets);
                    }
                int value = 0;
                    for(int i =0;i<26;i++)
                        value+=ct[i];




                    if(value<=k)
                    {
                        String  res = "";

                        for(int i =0;i<26;i++)
                            while(ct[i]-->0)
                                res+= ""+((char)('a'+i));

                         while(res.length()< k)
                             res+="a";
                        System.out.println(sheets);
                        System.out.println(res);


                        break;
                    }
                    sheets++;


            }



        }







        return;
    }
}
