package d2x;

import java.util.Scanner;

public class StringModification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = solve(s);
        System.out.println("OLD IS : "+s);
        System.out.println("RESULT IS : "+res);
    }


    static String solve(String s)
    {

        char [] ch =  s.toCharArray();
        int size = ch.length;
        for(int i  = 0; i < size; i++)
        {
            if(ch[i] == '?') {
                if (i > 1 && ch[i - 1] == ch[i - 2]) {
                    if (ch[i - 1] == 'a')
                        ch[i] = 'b';
                    else
                        ch[i] = 'a';
                }
                else if (i < size - 2 && ch[i+1] == ch[i+2])
                {
                    if (ch[i + 1] == 'a')
                        ch[i] = 'b';
                    else
                        ch[i] = 'a';
                }
                else  if ( i>0 && i+1 <size && ch[i+1]==ch[i-1])
                {

                    if (ch[i - 1] == 'a')
                        ch[i] = 'b';
                    else
                        ch[i] = 'a';
                }
                else
                {
                    ch[i] = 'a';

                }

            }


        }






        return new String(ch);

    }
}
