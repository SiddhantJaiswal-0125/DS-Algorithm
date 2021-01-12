import java.util.Scanner;

public class CountAndSay
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = countandSay(n);
    }
    static String countandSay(int n)
    {
        if(n==1)
            return "1";
        if(n==2)
            return "11";
        String ans = "11";
        for(int i = 3;i<=n;i++)
        {
            ans+='$';
            int len = ans.length();
            int cnt = 0;

            String tmp= "";
            char arr[] = ans.toCharArray();
            for(int j = 1;j<len;j++)
            {
                if(arr[j]!=arr[j-1])
                {
                    tmp += cnt + 0;

                    // Append str[j-1]
                    tmp += arr[j - 1];

                    // Reset count
                    cnt = 1;
                }

                // If matches, then increment
                // count of matching characters
                else cnt++;
            }

            // Update str
            ans = tmp;
        }

        return ans;
    }



}
