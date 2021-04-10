import java.util.*;
public class subset {

    static void solve(String inp, int i , int n , String res)
    {
        if(i>=n)
        {   
            System.out.println(res);
            return;
        }
        solve(inp, i+1, n, res);
        res+=inp.charAt(i);
        solve(inp, i+1, n, res);  
        return;  
            
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.next();
        solve(ip, 0, ip.length(), "");

        sc.close();
    }
}
