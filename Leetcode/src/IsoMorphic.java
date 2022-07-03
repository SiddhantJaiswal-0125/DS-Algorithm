import java.util.Arrays;
import java.util.Scanner;

public class IsoMorphic {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(new IsoMorphic().isIsomorphic(a, b));
    }
    public boolean isIsomorphic(String s, String t) {
        char ar1[] =new char[128];
        char ar2[] =new char[128];
        if(s.length() != t.length())
            return false;
        Arrays.fill(ar1, '-');
        Arrays.fill(ar2, '-');
        int i =0;
        while(i<s.length())
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(ar1[ c1 ] == '-' && ar2[c2] == '-')
            {
                //dono blank hai
                ar1[c1] = c2;
                ar2[c2 ] = c1;
            }
            else  if(ar1[c1] != '-' && ar1[c1] !=c2)
                return false;
            else  if(ar2[c2] != '-' && ar2[c2] != c1 )
                return false;

            i++;

        }


        return true;
    }
}
