import java.util.Scanner;

public class BinaryRemovals
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0)
        {
            String s = sc.next();
            int l = s.length();
            int a = findSeq(s, "11");
            int b = findSeqend(s,"00");
            if(a!=-1 && b!=-1 && a<b)
                System.out.println("NO");
            else System.out.println("YES");

        }
    }
    static int findSeq(String s, String find)
    {
        int ind = -1;
        if(s.length()<2)
            return  -1;

        for(int i = 0;i<s.length()-1;i++)
        {
            if(s.substring(i,i+2).equalsIgnoreCase(find))
                return  i;
        }
        return  -1;
    }

    static int findSeqend(String s, String find)
    {
        int ind = -1;
        if(s.length()<2)
            return  -1;

        for(int i = s.length()-1;i>0;i--)
        {
            if(s.substring(i-1,i+1).equalsIgnoreCase(find))
                return  i;
        }
        return  -1;
    }
}
