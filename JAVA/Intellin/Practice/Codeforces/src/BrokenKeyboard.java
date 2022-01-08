import java.util.Scanner;

public class BrokenKeyboard
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s  = sc.next();
            int  n = s.length();
//            int c[] = new int[26];
            boolean check [] = new boolean[26];

//            for(int i=0;i<s.length();i++)
//                c[s.charAt(i)-'a']++;
//            for(int i =0;i<26;i++)
//                if(c[i]%2!=0)
//                    System.out.print((char)(i+'a')+"");
//                System.out.println();


            int k =1;
            for(int i =1;i<n;i++)
            {
                if(s.charAt(i)==s.charAt(i-1))
                    k++;
                else
                {
                    if(k%2!=0)
                        check[s.charAt(i-1)-'a'] = true;

                    k = 1;

                }
            }
            if(k%2!=0)
                check[s.charAt(n-1)-'a'] = true;




            for(int i =0;i<26;i++)
                if(check[i])
                    System.out.print((char)(i+'a')+"");
            System.out.println();

        }
    }
}
