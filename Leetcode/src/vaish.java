import java.util.Scanner;

public class vaish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ini = sc.next();
        String fin = sc.next();
        String res = solve(ini, fin);
        System.out.println(res);

    }
    static  String solve(String in, String fin)
    {
        int fr1[] = new int[26];
        int fr2[]  = new int[26];
        int size1 = in.length();
        int size2 = fin.length();

        if(in.equalsIgnoreCase("-"))
            return  fin;

        for(int i =0 ;i<size1;i++)
            fr1[in.charAt(i)-'a']++;
        for(int i = 0;i<size2;i++)
            fr2[fin.charAt(i)-'a']++;


        for(int i = 0;i<26;i++)
            if(fr1[i]!=fr2[i])
                return new String(""+(char)(i+'a'));
        return fin  ;
    }
}
