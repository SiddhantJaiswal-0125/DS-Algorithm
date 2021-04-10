import java.util.Scanner;

public class LongestPalindromicSubstring 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = new Solution1().longestPalindrome(s);
        System.out.println(ans);
        sc.close();
        }
    
}

class Solution1 {
    public String longestPalindrome(String str)
    {
        String max = "";
        int n = str.length();
        boolean dp[][] = new boolean [n][n];
        for(int gap = 0;gap<n;gap++)
        {

            for(int i =0, j = gap;j<n;i++, j++)
            {
                char c1 = str.charAt(i);
                char c2 = str.charAt(j);
                if(gap==0)
                dp[i][j] = true;
                else if(gap==1)
                dp[i][j] = c1==c2?true:false;
                else
                {
                    if(c1==c2)
                    dp[i][j] = dp[i+1][j-1];
                  else
                    dp[i][j] =  false;
              
                   
                }
                if(dp[i][j])
                {
                    // maxlen = gap+1;
                    max = str.substring(i, j+1);
                    
                } 
        
       

            }
        }
        return max;
        
    }


    static boolean ispalin(String str)
    {
       
          int i = 0, j = str.length() - 1;
 
    
          while (i < j) {
   
      
              if (str.charAt(i) != str.charAt(j))
                  return false;

              i++;
              j--;
          }
   
    
          return true;
    }

    
    
    
}