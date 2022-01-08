import java.util.HashSet;
import java.util.Scanner;

public class diffPasswords
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input[] = new String[n];
        for(int i = 0;i<n;i++)
            input[i] = new String(sc.next());
        int ans = countDifferent(input, n);
        System.out.println(ans);
    }
    static int countDifferent(String inp[], int n)
    {
        int count = 0;
        HashSet<String> hs = new HashSet<>();
        for(int i = 0;i<n;i++)
        {
            String _en = encodedString(inp[i].toCharArray());
            if(hs.contains(_en) == false)
            {
                count++;
                hs.add(_en);
            }
        }
     return   count;
    }
    static String encodedString(char c[])
    {
        int size = c.length;

        String encoded = "";

        int even[] = new int[26];
        int odd[] = new int[26];


        for(int i =0;i<size;i++)
        {
            if((i&1)==0)
            {
                even[c[i] - 'a']++;
            }
            else
                odd[c[i]-'a']++;
        }


        for(int i = 0; i < 26; i++)
        {
            encoded+=even[i];
            encoded+="-";
            encoded+=odd[i];
            encoded+="-";
        }




        return encoded;
    }
}
